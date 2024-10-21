package com.todevelop.todevelop.products.orchestrators.action;

import com.todevelop.todevelop.products.dto.ClientProduct;
import com.todevelop.todevelop.products.dto.RequestClientProduct;

import java.util.List;

public interface SaveClientProductAction {

    List<ClientProduct> saveClientProduct(RequestClientProduct request);
}
