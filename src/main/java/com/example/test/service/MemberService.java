package com.example.test.service;

import com.example.test.domain.Member;
import com.example.test.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Service라고 적으면 스프링이 실행될때 service를 찾아서 컨테이너에 등록해줌
// 그래야 컨트롤러의 @autowired annotation이 있는 코드와 매핑시켜줌
//@Service
public class MemberService {

    private final MemberRepository memberRepository;

    // MemberService에는 memberRepository가 필요한 것을 알고 찾아서 memberRepository를 넣어줌
    // @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public Long join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
