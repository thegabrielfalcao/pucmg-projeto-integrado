package com.pucmg.adviser.controllers;

import com.pucmg.adviser.models.Transaction;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

public interface TransactionController {

    @Operation(summary = "Get a transaction by its id")
    @ApiResponses(
            @ApiResponse(responseCode = "200", description = "Found the transaction",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Transaction.class)) }
            )
    )
    ResponseEntity find(String clientId, @Parameter(description = "id of transaction to be searched") String transactionId);
}
