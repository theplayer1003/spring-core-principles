package com.example.springcore;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.springcore.member.Grade;
import com.example.springcore.member.Member;
import com.example.springcore.member.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class MemberServiceImplTest {
    MemberService memberService;

    @BeforeEach
    void beforeEach() {
        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                AutoAppConfig.class);
        memberService = applicationContext.getBean(MemberService.class);
    }

    @Test
    void join() {
        long id = 1;
        Member memberA = new Member(id, "memberA", Grade.VIP);

        memberService.join(memberA);
        Member findMember = memberService.findMember(id);

        assertThat(memberA.getId()).isEqualTo(findMember.getId());
    }
}