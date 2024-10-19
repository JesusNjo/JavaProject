package com.todevelop.todevelop.products.orchestrators;

import com.todevelop.todevelop.clients.services.client.model.ClientsModel;
import com.todevelop.todevelop.products.dto.ClientProduct;
import com.todevelop.todevelop.products.mapper.ClientProductMapper;
import com.todevelop.todevelop.products.orchestrators.action.GetClientProductAction;
import com.todevelop.todevelop.products.services.client_products.service.ClientProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
class GetClientProductActionImpl implements GetClientProductAction {
    private final ClientProductService clientProductService;
    private final ClientProductMapper clientProductMapper;
    @Override
    public List<ClientProduct> getProductByClient(ClientsModel client) {
        return clientProductService.getClientProductModelByClientId(client)
                .stream().map(clientProductMapper::toDto).toList();
    }
}
