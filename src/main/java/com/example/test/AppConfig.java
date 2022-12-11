package com.example.test;

import com.example.test.discount.DiscountPolicy;
import com.example.test.discount.FixDiscountPolicy;
import com.example.test.discount.RateDiscountPolicy;
import com.example.test.member.MemberRepository;
import com.example.test.member.MemberService;
import com.example.test.member.MemberServiceImpl;
import com.example.test.member.MemoryMemberRepository;
import com.example.test.order.OrderService;
import com.example.test.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
