package com.todevelop.todevelop.clients.services.client;

import com.todevelop.todevelop.clients.services.client.model.ClientsModel;
import com.todevelop.todevelop.utils.StatusEnum;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
class ClientsDAOImpl implements ClientsDAO{

    private final ClientsRepository clientsRepository;
    @Override
    public ClientsModel findClientByMemberId(String memberId) {
        return clientsRepository.findClientsModelByMember_MemberId(memberId);
    }

    @Override
    public Page<ClientsModel> findClientsModelByClientIdAndStatus(StatusEnum status, Pageable page) {
        return clientsRepository.findClientsModelByStatus(status,page);
    }

    @Override
    public ClientsModel findClientsModelByClientIdAndStatus(String clientId, StatusEnum status) {
        return clientsRepository.findClientsModelByClientIdAndStatus(clientId,status);
    }

    @Override
    public Optional<ClientsModel> findById(String var1) {
        return clientsRepository.findById(var1);
    }

    @Override
    public ClientsModel save(ClientsModel var1) {
        return clientsRepository.save(var1);
    }

    @Override
    public List<ClientsModel> saveAll(List<ClientsModel> var1) {
        return clientsRepository.saveAll(var1);
    }

    @Override
    public void delete(ClientsModel var1) {
        clientsRepository.delete(var1);
    }
}
