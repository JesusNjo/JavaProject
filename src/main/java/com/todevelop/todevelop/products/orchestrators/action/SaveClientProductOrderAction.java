package com.todevelop.todevelop.products.orchestrators.action;

import com.todevelop.todevelop.products.dto.ClientProductOrder;
import com.todevelop.todevelop.products.dto.RequestClientProductOrder;

import java.util.List;

public interface SaveClientProductOrderAction {

    List<ClientProductOrder> saveClientProductOrder(RequestClientProductOrder request);
}
