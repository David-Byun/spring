package com.example.test;

import com.example.test.member.Grade;
import com.example.test.member.Member;
import com.example.test.member.MemberService;
import com.example.test.member.MemberServiceImpl;
import com.example.test.order.Order;
import com.example.test.order.OrderService;
import com.example.test.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
        System.out.println("order = " + order.calculatePrice());

    }
}
