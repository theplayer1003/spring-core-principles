package com.example.springcore.member;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberServiceImplTest {
    MemberService memberService;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
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