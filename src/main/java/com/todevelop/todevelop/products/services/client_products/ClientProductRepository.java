package com.todevelop.todevelop.products.services.client_products;

import com.todevelop.todevelop.clients.services.client.model.ClientsModel;
import com.todevelop.todevelop.products.services.client_products.model.ClientProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

interface ClientProductRepository extends JpaRepository<ClientProductModel,String> {

    @Query("SELECT cp from ClientsModel cp where cp.clientId =:client")
    List<ClientProductModel> getClientProductModelByClientId(@Param("client")ClientsModel client);
}
