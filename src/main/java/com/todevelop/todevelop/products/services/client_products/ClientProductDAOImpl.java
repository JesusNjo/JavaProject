package com.todevelop.todevelop.products.services.client_products;

import com.todevelop.todevelop.clients.services.client.model.ClientsModel;
import com.todevelop.todevelop.products.services.client_products.model.ClientProductModel;
import com.todevelop.todevelop.products.services.products.model.ProductModel;
import com.todevelop.todevelop.utils.StatusEnum;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class ClientProductDAOImpl implements ClientProductDAO{
    private final ClientProductRepository clientProductRepository;
    @Override
    public List<ClientProductModel> getClientProductModelByClientId(ClientsModel client) {
        return clientProductRepository.getClientProductModelByClientId(client);
    }

    @Override
    public Optional<ClientProductModel> findByClientAndProductAndStatus(ClientsModel client, ProductModel product, StatusEnum status) {
        return clientProductRepository.findByClientAndProductAndStatus(client,product,status);
    }

    @Override
    public Optional<ClientProductModel> findById(String var1) {
        return clientProductRepository.findById(var1);
    }

    @Override
    public ClientProductModel save(ClientProductModel var1) {
        return clientProductRepository.save(var1);
    }

    @Override
    public List<ClientProductModel> saveAll(List<ClientProductModel> var1) {
        return clientProductRepository.saveAll(var1);
    }

    @Override
    public void delete(ClientProductModel var1) {
        clientProductRepository.delete(var1);

    }
}
