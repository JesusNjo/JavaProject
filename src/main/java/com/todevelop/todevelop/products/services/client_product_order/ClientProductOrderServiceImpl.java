package com.todevelop.todevelop.products.services.client_product_order;

import com.todevelop.todevelop.clients.services.client.model.ClientsModel;
import com.todevelop.todevelop.products.services.client_product_order.model.ClientProductOrderId;
import com.todevelop.todevelop.products.services.client_product_order.model.ClientProductOrderModel;
import com.todevelop.todevelop.products.services.client_product_order.service.ClientProductOrderService;
import com.todevelop.todevelop.utils.enums.StatusEnum;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
class ClientProductOrderServiceImpl implements ClientProductOrderService {
    private final ClientProductOrderDAO clientProductOrderDAO;
    @Override
    public Optional<ClientProductOrderModel> findById(ClientProductOrderId var1) {
        return clientProductOrderDAO.findById(var1);
    }

    @Override
    public ClientProductOrderModel save(ClientProductOrderModel var1) {
        return clientProductOrderDAO.save(var1);
    }

    @Override
    public List<ClientProductOrderModel> saveAll(List<ClientProductOrderModel> var1) {
        return clientProductOrderDAO.saveAll(var1);
    }

    @Override
    public void delete(ClientProductOrderModel var1) {
        clientProductOrderDAO.delete(var1);
    }

    @Override
    public ClientProductOrderModel findByClientClientAndStatus(ClientsModel client, StatusEnum status) {
        return clientProductOrderDAO.findByClientProductOrderId_ClientAndStatus(client,status);
    }

    @Override
    public List<ClientProductOrderModel> getAllOrders() {
        return clientProductOrderDAO.getAllOrders();
    }
}
