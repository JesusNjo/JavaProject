package com.todevelop.todevelop.products.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RequestClientProductOrder implements Serializable {

    @Serial
    private static final long serialVersionUID = -6742245219779372834L;

    private String clientId;
    private Integer quantity;
    private List<String> products;
}
