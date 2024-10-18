package com.todevelop.todevelop.clients.services.client;

import com.todevelop.todevelop.clients.services.client.model.ClientsModel;
import com.todevelop.todevelop.utils.StatusEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


interface ClientsRepository extends JpaRepository<ClientsModel,String> {

    ClientsModel findClientsModelByMember_MemberId(String memberId);

    Page<ClientsModel> findClientsModelByStatus(StatusEnum status, Pageable page);

    @Query("SELECT c FROM ClientsModel c WHERE c.clientId = :clientId AND c.status = :status")
    ClientsModel findClientsModelByClientIdAndStatus(@Param("clientId") String clientId, @Param("status")
    StatusEnum status);

}
