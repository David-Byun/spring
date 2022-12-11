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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
