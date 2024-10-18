package com.todevelop.todevelop.clients.services.client;

import com.todevelop.todevelop.clients.services.client.model.ClientsModel;
import com.todevelop.todevelop.utils.GenericJPA;
import com.todevelop.todevelop.utils.StatusEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


interface ClientsDAO extends GenericJPA<ClientsModel,String> {

    ClientsModel findClientByMemberId(String memberId);
    Page<ClientsModel> findClientsModelByClientIdAndStatus(StatusEnum status, Pageable page);
    ClientsModel findClientsModelByClientIdAndStatus(String clientId, StatusEnum status);
}
