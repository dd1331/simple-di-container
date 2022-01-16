package simple.spring.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import simple.spring.AppConfig;

public class MemberServiceTest {


    MemberService memberService;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        Member member = new Member(1L, "memberA", Grade.VIP);

        memberService.join(member);

        Member foundMember = memberService.findMember(1L);

        Assertions.assertThat(member).isEqualTo(foundMember);
    }
}
