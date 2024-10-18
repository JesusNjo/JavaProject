package com.todevelop.todevelop.members.services.member;

import com.todevelop.todevelop.members.services.member.model.MemberModel;
import com.todevelop.todevelop.members.services.member.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberDAO memberDAO;
    @Override
    public Optional<MemberModel> findById(String var1) {
        return memberDAO.findById(var1);
    }

    @Override
    public MemberModel save(MemberModel var1) {
        return memberDAO.save(var1);
    }

    @Override
    public List<MemberModel> saveAll(List<MemberModel> var1) {
        return memberDAO.saveAll(var1);
    }

    @Override
    public void delete(MemberModel var1) {
        memberDAO.delete(var1);
    }
}
