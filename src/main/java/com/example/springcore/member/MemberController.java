package com.example.springcore.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public String join(@RequestBody Member member) {
        memberService.join(member);
        return "Member joined successfully: " + member.getName();
    }

    @GetMapping("/{id}")
    public Member findMember(@PathVariable("id") Long id) {
        return memberService.findMember(id);
    }

//    @GetMapping("/api/hello")
//    public String hello() {
//        return "Hello, Spring Web!";
//    }
}
