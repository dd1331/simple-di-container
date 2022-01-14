package simple.spring.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        Member member = new Member(1L, "memberA", Grade.VIP);

        memberService.join(member);

        Member foundMember = memberService.findMember(1L);

        Assertions.assertThat(member).isEqualTo(foundMember);
    }
}