package hu.microservice.medicare.datastore;

import java.util.Set;

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

@RequestMapping(value = "/api/DataStore", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Patients", description = "The Patient API")
public interface PatientApi {

    @Operation(summary = "Find all Patients", description = "Returns all Patients", tags = { "Patients" })
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation.") })
    @GetMapping(value = "/PatientData", produces = MediaType.APPLICATION_JSON_VALUE)
    Set<PatientData> getAll();

    @Operation(summary = "Find Patient by id", description = "Returns AlertRule by the given id", tags = {
            "Patients" })
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation."),
            @ApiResponse(responseCode = "404", description = "Patient not found.") })
    @GetMapping(value = "/PatientData/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    PatientData getById(@PathVariable(value = "id") String id);

    @Operation(summary = "Update Patient", description = "", tags = { "Patients" })
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation."),
            @ApiResponse(responseCode = "404", description = "Patient not found.") })
    @PostMapping(value = "/PatientData/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    PatientData updateById(@PathVariable(value = "id") String id, @RequestBody PatientData patientData);

    @Operation(summary = "Create new Patient", description = "", tags = { "Patients" })
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation.") })
    @PutMapping(value = "/PatientData", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    PatientData create(@RequestBody PatientData patientData);

    @Operation(summary = "Delete Patient", description = "", tags = { "Patients" })
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation.") })
    @DeleteMapping(value = "/PatientData/{id}")
    void delete(@PathVariable(value = "id") String id);
}
