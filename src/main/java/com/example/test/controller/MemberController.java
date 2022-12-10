package com.example.test.controller;

import com.example.test.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

// spring controller 객체 생성해서 넣어줌(컨테이너 스프링빈 관리)
@Controller
public class MemberController {
    private final MemberService memberService;

    // memberService와 컨트롤러를 연결시켜줌
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

}
