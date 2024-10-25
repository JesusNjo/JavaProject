package com.todevelop.todevelop.clients.orchestrators;

import com.todevelop.todevelop.clients.dto.Client;
import com.todevelop.todevelop.clients.mapper.ClientMapper;
import com.todevelop.todevelop.clients.orchestrators.action.SaveClientAction;
import com.todevelop.todevelop.clients.services.client.model.ClientsModel;
import com.todevelop.todevelop.clients.services.client.service.ClientsService;
import com.todevelop.todevelop.members.dto.User;
import com.todevelop.todevelop.members.mapper.UserMapper;
import com.todevelop.todevelop.members.services.member.model.MemberModel;
import com.todevelop.todevelop.members.services.member.service.MemberService;
import com.todevelop.todevelop.members.services.user.model.UserModel;
import com.todevelop.todevelop.members.services.user.service.UserServices;
import com.todevelop.todevelop.utils.enums.ResourceTypeEnum;
import com.todevelop.todevelop.utils.enums.StatusEnum;
import com.todevelop.todevelop.utils.enums.TypesRegister;
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
    private final UserServices userServices;
    private final UserMapper userMapper;
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
        createUser(member);

        return clientMapper.toDto(clientsService.save(ClientsModel.builder()
                .clientId(ResourceTypeEnum.getRandomId(ResourceTypeEnum.CLIENT))
                .member(member)
                .status(StatusEnum.ACTIVE)
                .build()));
    }

    private User createUser(MemberModel member){
        return userMapper.toDto(
                userServices.save(
                        UserModel.builder()
                                .username(member.getMainElectronicAddress())
                                .defaultUser(true)
                                .member(member)
                                .status(StatusEnum.ACTIVE)
                                .typesRegister(TypesRegister.EMAIL)
                                .build()
                )
        );
    }
}
