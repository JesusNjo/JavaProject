package com.todevelop.todevelop.clients.orchestrators.action;

import com.todevelop.todevelop.clients.dto.Client;
import com.todevelop.todevelop.clients.services.client.model.ClientsModel;

public interface SaveClientAction {

    Client saveClient(Client clientsModel);
}
