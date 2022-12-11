package com.example.test;

import com.example.test.member.MemberService;
import com.example.test.member.MemberServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	public static class MemberApp {

		public static void main(String[] args) {
			MemberService memberService = new MemberServiceImpl();
		}
	}
}
