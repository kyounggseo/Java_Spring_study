package hello.core.member;

// 회원서비스 역할

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
