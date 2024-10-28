package com.todevelop.todevelop.products.orchestrators;

import com.todevelop.todevelop.clients.i18n.I18nClients;
import com.todevelop.todevelop.clients.services.client.service.ClientsService;
import com.todevelop.todevelop.exceptions.ResourceNotFoundException;
import com.todevelop.todevelop.i18n.I18nService;
import com.todevelop.todevelop.products.dto.ClientProductOrder;
import com.todevelop.todevelop.products.mapper.ClientProductOrderMapper;
import com.todevelop.todevelop.products.orchestrators.action.GetClientProductOrderAction;
import com.todevelop.todevelop.products.services.client_product_order.service.ClientProductOrderService;
import com.todevelop.todevelop.utils.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
@Slf4j
public class GetClientProductOrderActionImpl implements GetClientProductOrderAction {
    private final ClientProductOrderService clientProductOrderService;
    private final ClientProductOrderMapper clientProductOrderMapper;
    private final ClientsService clientsService;
    private final I18nService i18nService;
    @Override
    public List<ClientProductOrder> getAllOrders() {
        return clientProductOrderService.getAllOrders().stream().map(clientProductOrderMapper::toDto).toList();
    }


    @Override
    public ClientProductOrder getOrderByClientAndStatus(String clientId, StatusEnum status) {
        var client = clientsService.findById(clientId).orElseThrow(()->{
            log.error("Client not found {} ", clientId);
            return new ResourceNotFoundException(i18nService.getMessage(I18nClients.CLIENT_NOT_FOUND_MSG_ERROR));
        });

        return clientProductOrderMapper.toDto(clientProductOrderService.findByClientClientAndStatus(client,status));
    }

}
