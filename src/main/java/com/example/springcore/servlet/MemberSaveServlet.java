package com.example.springcore.servlet;

import com.example.springcore.member.Member;
import com.example.springcore.member.MemberService;
import com.example.springcore.member.MemberServiceImpl;
import com.example.springcore.member.MemoryMemberRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.springframework.util.StreamUtils;

@WebServlet(name = "memberSaveServlet", urlPatterns = "/api/members")
public class MemberSaveServlet extends HttpServlet {

    private MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());

    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if ("POST".equals(request.getMethod())) {
            ServletInputStream inputStream = request.getInputStream();
            String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

            ObjectMapper objectMapper = new ObjectMapper();
            Member member = objectMapper.readValue(messageBody, Member.class);

            memberService.join(member);

            response.setContentType("text/plain");
            response.setCharacterEncoding("utf-8");
            response.getWriter().write("Member joined successfully: " + member.getName());

        }
    }
}
