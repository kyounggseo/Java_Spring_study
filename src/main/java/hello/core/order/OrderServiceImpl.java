package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// orderService 구현체 Impl

@Component // 각 클래스가 컴포넌트 스캔의 대상이 되도록 에노테이션을 붙여줌
//@RequiredArgsConstructor // => final이 붙은 필드에 대한 생성자를 자동 만들어 준다. >>> lombok 설치 필수 = @Autowired 사용할 필요xx
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository; //인터페이스에만 의존
    private final DiscountPolicy discountPolicy; // 인터페이스에만 의존
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); // 구현체에 의존, DIP 위반
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Autowired // 생성자(OrderServiceImpl) 에서 여러 의존관계도 한번에 주입 가능 // @MainDiscountPolicy 생성자 자동 주입
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    /**
     * 주문 생성
     */
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
