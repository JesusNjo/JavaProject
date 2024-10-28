package com.todevelop.todevelop.products.orchestrators.action;

import com.todevelop.todevelop.clients.services.client.model.ClientsModel;
import com.todevelop.todevelop.products.dto.ClientProductOrder;
import com.todevelop.todevelop.utils.enums.StatusEnum;

import java.util.List;

public interface GetClientProductOrderAction {

    ClientProductOrder getOrderByClientAndStatus(String clientId, StatusEnum status);
    List<ClientProductOrder> getAllOrders();
}
