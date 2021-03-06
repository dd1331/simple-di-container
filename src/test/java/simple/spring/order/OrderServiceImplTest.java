package simple.spring.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import simple.spring.AppConfig;
import simple.spring.member.Grade;
import simple.spring.member.Member;
import simple.spring.member.MemberService;
import simple.spring.member.MemberServiceImpl;

class OrderServiceImplTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }


    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "test", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "test", 20000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }



}