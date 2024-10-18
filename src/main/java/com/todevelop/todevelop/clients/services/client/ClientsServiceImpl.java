package com.todevelop.todevelop.clients.services.client;

import com.todevelop.todevelop.clients.services.client.model.ClientsModel;
import com.todevelop.todevelop.clients.services.client.service.ClientsService;
import com.todevelop.todevelop.utils.StatusEnum;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
class ClientsServiceImpl implements ClientsService {
    private final ClientsDAO clientsDAO;
    @Override
    public ClientsModel findClientByMemberId(String memberId) {
        return clientsDAO.findClientByMemberId(memberId);
    }

    @Override
    public Page<ClientsModel> findClientsModelByClientIdAndStatus(StatusEnum status, Pageable page) {
        return clientsDAO.findClientsModelByClientIdAndStatus(status,page);
    }

    @Override
    public ClientsModel findClientsModelByClientIdAndStatus(String clientId, StatusEnum status) {
        return clientsDAO.findClientsModelByClientIdAndStatus(clientId,status);
    }

    @Override
    public Optional<ClientsModel> findById(String var1) {
        return clientsDAO.findById(var1);
    }

    @Override
    public ClientsModel save(ClientsModel var1) {
        return clientsDAO.save(var1);
    }

    @Override
    public List<ClientsModel> saveAll(List<ClientsModel> var1) {
        return clientsDAO.saveAll(var1);
    }

    @Override
    public void delete(ClientsModel var1) {
        clientsDAO.delete(var1);
    }
}
