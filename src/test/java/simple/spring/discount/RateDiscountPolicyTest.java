package simple.spring.discount;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import simple.spring.member.Grade;
import simple.spring.member.Member;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야한다")
    void vip_o() {
        Long memberId = 1L;
        Member member = new Member(memberId, "test", Grade.VIP);

        int price = 30000;

        int discount = rateDiscountPolicy.discount(member, price);

        assertThat(discount).isEqualTo(3000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 없다")
    void vip_x() {
        Long memberId = 1L;
        Member member = new Member(memberId, "test", Grade.BASIC);

        int price = 30000;

        int discount = rateDiscountPolicy.discount(member, price);

        assertThat(discount).isEqualTo(0);
    }
}