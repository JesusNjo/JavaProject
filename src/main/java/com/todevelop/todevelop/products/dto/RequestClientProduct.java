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
public class RequestClientProduct implements Serializable {

    @Serial
    private static final long serialVersionUID = 2764310375829891736L;

    private String clientId;
    private List<String> products;

}
