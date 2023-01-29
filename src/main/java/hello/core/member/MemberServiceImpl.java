package hello.core.member;

// 회원 서비스 구현체

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // 각 클래스가 컴포넌트 스캔의 대상이 되도록 에노테이션을 붙여줌
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Autowired // 생성자에서 여러 의존관계도 한번에 주입 가능
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    } //생성자

    /**
     * 회원가입
     */
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    /**
     * 회원조회
     */
    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
