package com.example.springcore.member;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class MemberServiceImplTest {
    MemberService memberService;

    @BeforeEach
    void beforeEach() {
        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                AppConfig.class);
        memberService = applicationContext.getBean("memberService", MemberService.class);
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