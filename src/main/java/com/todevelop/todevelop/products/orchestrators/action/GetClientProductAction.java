package com.todevelop.todevelop.products.orchestrators.action;

import com.todevelop.todevelop.clients.services.client.model.ClientsModel;
import com.todevelop.todevelop.products.dto.ClientProduct;

import java.util.List;

public interface GetClientProductAction {

    List<ClientProduct> getProductByClient(ClientsModel client);
}
