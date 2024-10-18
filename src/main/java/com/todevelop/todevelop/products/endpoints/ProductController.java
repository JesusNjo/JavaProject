package com.todevelop.todevelop.products.endpoints;

import com.todevelop.todevelop.products.dto.Product;
import com.todevelop.todevelop.products.orchestrators.action.GetProductAction;
import com.todevelop.todevelop.products.services.products.model.TelecomProductType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/v1/products")

public class ProductController {

    private final GetProductAction getProductAction;
    @Operation(summary = "Get all product from dev")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Getting all products by dev",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Product.class))}
            ),
            @ApiResponse(
                    responseCode = "204",
                    description = "Not content",
                    content = {@Content}
            )
    })
    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(getProductAction.getAllProducts(), HttpStatus.OK);
    }
    @Operation(summary = "Get all product by type from dev")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Getting products type by dev",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Product.class))}
            ),
            @ApiResponse(
                    responseCode = "204",
                    description = "Not content",
                    content = {@Content}
            )
    })
    @GetMapping("/type")
    public ResponseEntity<Product> getAllProductsByType(@RequestParam TelecomProductType type){
        return new ResponseEntity<>(getProductAction.findProductModelByProductType(type), HttpStatus.OK);
    }

}
