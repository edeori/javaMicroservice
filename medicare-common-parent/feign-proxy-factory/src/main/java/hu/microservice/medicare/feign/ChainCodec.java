package hu.microservice.medicare.feign;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import feign.FeignException;
import feign.RequestTemplate;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import feign.codec.EncodeException;
import feign.codec.Encoder;

public class ChainCodec implements Encoder, Decoder {
    private static final Logger LOG = LoggerFactory.getLogger(ChainCodec.class);
    private final Set<Encoder> encoders;
    private final Set<Decoder> decoders;

    public ChainCodec(Collection<Encoder> encoders, Collection<Decoder> decoders) {
        this.encoders = Set.copyOf(encoders);
        this.decoders = Set.copyOf(decoders);
    }

    @Override
    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
        Object result = null;
        var contentType = response.headers().get("Content-Type");
        for (var decoder : decoders) {
            try {
                result = tryDecodeWith(response, type, decoder, contentType);
                if (result != null) {
                    break;
                }
            } catch (Exception e) {
                // It is normal to have an Exception here
            }
        }
        if (result != null) {
            return result;
        } else {
            throw new IOException("No decoders can decode the response");
        }
    }

    private Object tryDecodeWith(Response response, Type type, Decoder decoder, Collection<String> contentType)
            throws DecodeException, FeignException, IOException {
        Object result = null;
        if (decoder instanceof ContentTypeAware) {
            var supportsContentType = ((ContentTypeAware) decoder).supportsContentType(contentType);
            if (!supportsContentType) {
                return null;
            }
        } // else decoder is not Content-Type aware
        result = decoder.decode(response, type);
        return result;
    }

    @Override
    public void encode(Object object, Type bodyType, RequestTemplate template) throws EncodeException {
        var encodeOK = false;
        var contentType = template.headers().get("Content-Type");
        for (var encoder : encoders) {
            try {
                tryEncodeWith(object, bodyType, template, encoder, contentType);
                encodeOK = true;
            } catch (Exception e) {
                encodeOK = false;
            }
            if (encodeOK) {
                break;
            }
        }
        if (!encodeOK) {
            throw new EncodeException("No encoders can encode the request");
        }

    }

    private void tryEncodeWith(Object object, Type bodyType, RequestTemplate template, Encoder encoder,
            Collection<String> contentType) throws Exception {
        if (encoder instanceof ContentTypeAware) {
            var supportsContentType = ((ContentTypeAware) encoder).supportsContentType(contentType);
            if (!supportsContentType) {
                throw new EncodeException("Encoder does not support content type");
            }
        } // encoder is not Content-Type aware
        encoder.encode(object, bodyType, template);
    }
}
