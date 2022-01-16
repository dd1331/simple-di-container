package simple.spring.discount;

import simple.spring.member.Grade;
import simple.spring.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercentage = 50;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercentage / 100;
        }
        return 0;
    }
}
