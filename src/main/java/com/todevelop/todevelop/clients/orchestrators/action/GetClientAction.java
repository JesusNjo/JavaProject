package com.todevelop.todevelop.clients.orchestrators.action;

import com.todevelop.todevelop.clients.dto.Client;
import com.todevelop.todevelop.clients.services.client.model.ClientsModel;
import com.todevelop.todevelop.utils.StatusEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GetClientAction {

    Page<Client> getClientsByStatus(Pageable page);
    Client findClientsModelByClientIdAndStatus(String clientId, StatusEnum status);
}
