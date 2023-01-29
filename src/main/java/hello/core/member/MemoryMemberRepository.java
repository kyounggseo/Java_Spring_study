package hello.core.member;

// 메모리 회원 저장소

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component // 각 클래스가 컴포넌트 스캔의 대상이 되도록 에노테이션을 붙여줌
public class MemoryMemberRepository implements  MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
