package com.todevelop.todevelop.products.services.client_product_order;

import com.todevelop.todevelop.clients.services.client.model.ClientsModel;
import com.todevelop.todevelop.products.services.client_product_order.model.ClientProductOrderId;
import com.todevelop.todevelop.products.services.client_product_order.model.ClientProductOrderModel;
import com.todevelop.todevelop.utils.enums.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface ClientProductOrderRepository extends JpaRepository<ClientProductOrderModel, ClientProductOrderId> {


    ClientProductOrderModel findByClientProductOrderId_ClientAndStatus(ClientsModel client, StatusEnum status);
    @Query("select cpo from ClientProductOrderModel  cpo")
    List<ClientProductOrderModel> getAllOrders();
}
