package com.todevelop.todevelop.clients.orchestrators;

import com.todevelop.todevelop.clients.dto.Client;
import com.todevelop.todevelop.clients.mapper.ClientMapper;
import com.todevelop.todevelop.clients.orchestrators.action.SaveClientAction;
import com.todevelop.todevelop.clients.services.client.model.ClientsModel;
import com.todevelop.todevelop.clients.services.client.service.ClientsService;
import com.todevelop.todevelop.members.services.member.model.MemberModel;
import com.todevelop.todevelop.members.services.member.service.MemberService;
import com.todevelop.todevelop.utils.ResourceTypeEnum;
import com.todevelop.todevelop.utils.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
class SaveClientActionImpl implements SaveClientAction {
    private final ClientsService clientsService;
    private final MemberService memberService;
    private final ClientMapper clientMapper;

    @Override
    @Transactional
    public Client saveClient(Client client) {

        var member = memberService.save(
                MemberModel.builder()
                        .memberId(ResourceTypeEnum.getRandomId(ResourceTypeEnum.MEMBER))
                        .firstName(client.getFirstName())
                        .lastName(client.getLastName())
                        .middleInitial(client.getMiddleInitial())
                        .dob(client.getDob())
                        .avatar(client.getAvatar())
                        .externalId(client.getExternalId())
                        .mainElectronicAddress(client.getMainElectronicAddress())
                        .status(StatusEnum.ACTIVE)
                        .build()
        );

        return clientMapper.toDto(clientsService.save(ClientsModel.builder()
                .clientId(ResourceTypeEnum.getRandomId(ResourceTypeEnum.CLIENT))
                .member(member)
                .status(StatusEnum.ACTIVE)
                .build()));
    }
}
