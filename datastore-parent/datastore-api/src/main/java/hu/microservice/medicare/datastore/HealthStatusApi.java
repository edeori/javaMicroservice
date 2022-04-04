package hu.microservice.medicare.datastore;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping(value = "/api/HealthStatus")
@Tag(name = "HealthStatus", description = "The Health Status API")
public interface HealthStatusApi {

    @Operation(summary = "Find HealthStatus by id", description = "Returns HealthStatus by the given id", tags = {
            "HealthStatus" })
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation."),
            @ApiResponse(responseCode = "404", description = "HealthStatus not found.") })
    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    HealthStatus getByUser();

    @Operation(summary = "Create or update HealthStatus", description = "", tags = {
            "HealthStatus" })
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation.") })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    HealthStatus createOrUpdate(@RequestBody HealthStatus healthStatus);

    @Operation(summary = "Delete HealthStatus", description = "", tags = {
            "HealthStatus" })
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation.") })
    @DeleteMapping(value = "/{id}")
    void delete(@PathVariable(value = "id") String id);
}
