package com.todevelop.todevelop.products.services.client_product_order;

import com.todevelop.todevelop.clients.services.client.model.ClientsModel;
import com.todevelop.todevelop.products.services.client_product_order.model.ClientProductOrderId;
import com.todevelop.todevelop.products.services.client_product_order.model.ClientProductOrderModel;
import com.todevelop.todevelop.utils.enums.StatusEnum;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
class ClientProductOrderDAOImpl implements ClientProductOrderDAO {
    private final ClientProductOrderRepository clientProductOrderRepository;
    @Override
    public Optional<ClientProductOrderModel> findById(ClientProductOrderId var1) {
        return clientProductOrderRepository.findById(var1);
    }

    @Override
    public ClientProductOrderModel save(ClientProductOrderModel var1) {
        return clientProductOrderRepository.save(var1);
    }

    @Override
    public List<ClientProductOrderModel> saveAll(List<ClientProductOrderModel> var1) {
        return clientProductOrderRepository.saveAll(var1);
    }

    @Override
    public void delete(ClientProductOrderModel var1) {
        clientProductOrderRepository.delete(var1);
    }

    @Override
    public ClientProductOrderModel findByClientProductOrderId_ClientAndStatus(ClientsModel client, StatusEnum status) {
        return clientProductOrderRepository.findByClientProductOrderId_ClientAndStatus(client,status);
    }

    @Override
    public List<ClientProductOrderModel> getAllOrders() {
        return clientProductOrderRepository.getAllOrders();
    }
}
