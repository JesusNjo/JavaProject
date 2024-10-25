package com.todevelop.todevelop.clients.orchestrators.action;

import com.todevelop.todevelop.clients.dto.Client;
import com.todevelop.todevelop.utils.enums.StatusEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GetClientAction {

    Page<Client> getClientsByStatus(Pageable page);
    Client findClientsModelByClientIdAndStatus(String clientId, StatusEnum status);
}
