package com.todevelop.todevelop.members.services.member;

import com.todevelop.todevelop.members.services.member.model.MemberModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MemberDAOImpl implements MemberDAO{
    private final MemberRepository memberRepository;
    @Override
    public Optional<MemberModel> findById(String var1) {
        return memberRepository.findById(var1);
    }

    @Override
    public MemberModel save(MemberModel var1) {
        return memberRepository.save(var1);
    }

    @Override
    public List<MemberModel> saveAll(List<MemberModel> var1) {
        return memberRepository.saveAll(var1);
    }

    @Override
    public void delete(MemberModel var1) {
        memberRepository.delete(var1);
    }
}
