package com.todevelop.todevelop.products.services.client_products;

import com.todevelop.todevelop.clients.services.client.model.ClientsModel;
import com.todevelop.todevelop.products.services.client_products.model.ClientProductModel;
import com.todevelop.todevelop.products.services.client_products.service.ClientProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
class ClientProductServiceImpl implements ClientProductService {
    private final ClientProductDAO clientProductDAO;
    @Override
    public List<ClientProductModel> getClientProductModelByClientId(ClientsModel client) {
        return clientProductDAO.getClientProductModelByClientId(client);
    }

    @Override
    public Optional<ClientProductModel> findById(String var1) {
        return clientProductDAO.findById(var1);
    }

    @Override
    public ClientProductModel save(ClientProductModel var1) {
        return clientProductDAO.save(var1);
    }

    @Override
    public List<ClientProductModel> saveAll(List<ClientProductModel> var1) {
        return clientProductDAO.saveAll(var1);
    }

    @Override
    public void delete(ClientProductModel var1) {
        clientProductDAO.delete(var1);
    }
}
