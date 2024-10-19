package com.todevelop.todevelop.products.services.client_products;

import com.todevelop.todevelop.clients.services.client.model.ClientsModel;
import com.todevelop.todevelop.products.services.client_products.model.ClientProductModel;
import com.todevelop.todevelop.utils.GenericJPA;

import java.util.List;

interface ClientProductDAO extends GenericJPA<ClientProductModel,String> {

    List<ClientProductModel> getClientProductModelByClientId(ClientsModel client);
}
