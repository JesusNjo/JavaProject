package com.todevelop.todevelop.products.services.client_products;

import com.todevelop.todevelop.clients.services.client.model.ClientsModel;
import com.todevelop.todevelop.products.services.client_products.model.ClientProductModel;
import com.todevelop.todevelop.products.services.products.model.ProductModel;
import com.todevelop.todevelop.utils.GenericJPA;
import com.todevelop.todevelop.utils.StatusEnum;

import java.util.List;
import java.util.Optional;

interface ClientProductDAO extends GenericJPA<ClientProductModel,String> {

    List<ClientProductModel> getClientProductModelByClientId(ClientsModel client);
    Optional<ClientProductModel> findByClientAndProductAndStatus(ClientsModel client, ProductModel product,
                                                                 StatusEnum status);
}
