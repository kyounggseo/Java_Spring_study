package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
외부, 공연기획자라고 생각하기, 의존 관계에 대해서 ***** AppConfig ***** 가 결정해줌.
 */

@Configuration // Spring 사용하려는 설정 정보
public class AppConfig {

    //@Bean memberService -> new MemoryMemberRepository()
    //@Bean orderService -> new MemoryMemberRepository()
    // => 2개의 new MemoryMemberRepository()가 생성되면서 싱글톤이 깨지는 것처럼 보임 -> 스프링 컨테이너로 해결 가능

    //예상, 일단 순차적으로 실행된다고 가정
    //memberService -> call AppConfig.memberService
    //call AppConfig.memberRepository
    //memberRepository -> call AppConfig.memberRepository
    //orderService -> call AppConfig.orderService
    //call AppConfig.memberRepository

    //실제 순서
    //call AppConfig.memberService
    //call AppConfig.memberRepository
    //call AppConfig.orderService

    @Bean // 각 메서드에 Bean 적기 -> 스프링 컨테이너에 등록되어서 스프링으로 사용 가능
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository()); // 생성자 주입
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy(); // 새로운 정책 할인으로 바꾸기
    }
}
