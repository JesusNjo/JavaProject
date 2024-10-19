package com.todevelop.todevelop.products.services.client_products.service;

import com.todevelop.todevelop.clients.services.client.model.ClientsModel;
import com.todevelop.todevelop.products.services.client_products.model.ClientProductModel;
import com.todevelop.todevelop.utils.GenericJPA;

import java.util.List;

public interface ClientProductService extends GenericJPA<ClientProductModel,String> {

    List<ClientProductModel> getClientProductModelByClientId(ClientsModel client);
}
