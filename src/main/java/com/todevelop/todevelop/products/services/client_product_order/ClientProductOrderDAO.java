package com.todevelop.todevelop.products.services.client_product_order;

import com.todevelop.todevelop.clients.services.client.model.ClientsModel;
import com.todevelop.todevelop.products.services.client_product_order.model.ClientProductOrderId;
import com.todevelop.todevelop.products.services.client_product_order.model.ClientProductOrderModel;
import com.todevelop.todevelop.utils.GenericJPA;
import com.todevelop.todevelop.utils.enums.StatusEnum;

import java.util.List;

interface ClientProductOrderDAO extends GenericJPA<ClientProductOrderModel, ClientProductOrderId> {

    ClientProductOrderModel findByClientProductOrderId_ClientAndStatus(ClientsModel client, StatusEnum status);
    List<ClientProductOrderModel> getAllOrders();
}
