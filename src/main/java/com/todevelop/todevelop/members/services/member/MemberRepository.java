package com.todevelop.todevelop.members.services.member;

import com.todevelop.todevelop.members.services.member.model.MemberModel;
import org.springframework.data.jpa.repository.JpaRepository;

interface MemberRepository extends JpaRepository<MemberModel,String> {
}
