package com.todevelop.todevelop.clients.orchestrators;

import com.todevelop.todevelop.clients.dto.Client;
import com.todevelop.todevelop.clients.i18n.I18nClients;
import com.todevelop.todevelop.clients.mapper.ClientMapper;
import com.todevelop.todevelop.clients.orchestrators.action.GetClientAction;
import com.todevelop.todevelop.clients.services.client.model.ClientsModel;
import com.todevelop.todevelop.clients.services.client.service.ClientsService;
import com.todevelop.todevelop.exceptions.ResourceNotFoundException;
import com.todevelop.todevelop.i18n.I18nService;
import com.todevelop.todevelop.utils.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
class GetClientsActionImpl implements GetClientAction {
    private final ClientMapper clientMapper;
    private final I18nService i18nService;
    private final ClientsService clientsService;
    @Override
    public Page<Client> getClientsByStatus(Pageable page) {
        return clientsService.findClientsModelByClientIdAndStatus(
                StatusEnum.ACTIVE,page
        ).map(clientMapper::toDto);
    }

    @Override
    public Client findClientsModelByClientIdAndStatus(String clientId, StatusEnum status) {

        var client = clientsService.findById(clientId).orElseThrow(()->{
            log.error("Client not found {}", clientId);
            return new ResourceNotFoundException(i18nService.getMessage(I18nClients.CLIENT_NOT_FOUND_MSG_ERROR,clientId));
        });

        return clientMapper.toDto(clientsService.findClientsModelByClientIdAndStatus(client.getClientId(),status));

        }
}
