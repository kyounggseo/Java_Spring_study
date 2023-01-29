package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// 회원, main 내에서 테스트

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        /**
         * 스프링 컨테이너 생성되는 과정
         */
        // 스프링 생성은 'ApplicationContext' 으로 시작, @Bean 이라고 한 모든 객체 관리해줌
        // 스프링 컨테이너, 인터페이스인 "applicationContext" 는 @Configuration 이 붙은 @Bean 메서드를 호출해서 등록
        // "AnnotationConfigApplicationContext" 는 인터페이스의 구현체

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); // "AppConfig.class" 을 구성 정보로 저장

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
