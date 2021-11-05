package hu.microservice.medicare.feign;

import java.io.IOException;
import java.lang.reflect.Type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.MimeType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import feign.FeignException;
import feign.RequestTemplate;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import feign.codec.EncodeException;
import feign.codec.Encoder;

public class XmlCodec implements Decoder, Encoder, ContentTypeAware {

    private static final Logger LOG = LoggerFactory.getLogger(XmlCodec.class);
    private final XmlMapper mapper;

    public XmlCodec() {
        mapper = new XmlMapper();
    }

    @Override
    public void encode(Object object, Type bodyType, RequestTemplate template) throws EncodeException {
        try {
            template.body(mapper.writeValueAsString(object));
        } catch (JsonProcessingException e) {
            LOG.error(e.getMessage(), e);
            throw new EncodeException("Cannot encode to application/xml", e);
        }
    }

    @Override
    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
        var contentTypes = response.headers().get(HttpHeaders.CONTENT_TYPE);
        if (contentTypes == null || contentTypes.isEmpty()) {
            LOG.warn("Missing Content-Type!");
        } else {
            var hasContentType = contentTypes.contains(MediaType.APPLICATION_XML_VALUE);
            if (!hasContentType) {
                LOG.warn("Content type mismatch");
            }
        }
        var stream = response.body().asReader(response.charset());
        return mapper.readValue(stream, TypeFactory.rawClass(type));
    }

    @Override
    public boolean supportsContentType(String contentType) {
        MimeType type = MimeType.valueOf(contentType);
        return MediaType.APPLICATION_XML.isCompatibleWith(type);
    }

}
