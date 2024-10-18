package com.todevelop.todevelop.clients.endpoints;

import com.todevelop.todevelop.clients.dto.Client;
import com.todevelop.todevelop.clients.orchestrators.action.GetClientAction;
import com.todevelop.todevelop.clients.orchestrators.action.SaveClientAction;
import com.todevelop.todevelop.clients.services.client.model.ClientsModel;
import com.todevelop.todevelop.utils.StatusEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = "v1/clients")
public class ClientsController {

    private final GetClientAction getClientAction;
    private final SaveClientAction saveClientAction;


    @Operation(summary = "Get all clients")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Getting clients for develop",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Client.class))}
            ),
            @ApiResponse(
                    responseCode = "204",
                    description = "Not content",
                    content = {@Content}
            )
    })
    @GetMapping()
    public ResponseEntity<Page<Client>> getAllClients(Pageable page){
        return new ResponseEntity<>(getClientAction.getClientsByStatus(page), HttpStatus.OK);
    }

    @Operation(summary = "Get client by id ")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Getting client by id develop",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class))}
            ),
            @ApiResponse(
                    responseCode = "204",
                    description = "Not content",
                    content = {@Content}
            )
    })
    @GetMapping("/{clientId}")
    public ResponseEntity<Client> getClientById(@PathVariable("clientId") String clientId){
        return new ResponseEntity<>(getClientAction.findClientsModelByClientIdAndStatus(
                clientId,
                StatusEnum.ACTIVE
        ), HttpStatus.OK);
    }

    @Operation(summary = "Create client by develop")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Getting clients for develop",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class))}
            ),
            @ApiResponse(
                    responseCode = "204",
                    description = "Not content",
                    content = {@Content}
            )
    })
    @PostMapping()
    public ResponseEntity<Client> getAllClients(@RequestBody Client client){
        return new ResponseEntity<>(saveClientAction.saveClient(client), HttpStatus.OK);
    }
}
