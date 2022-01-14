package simple.spring.discount;

import simple.spring.member.Grade;
import simple.spring.member.Member;

public class FixedDiscountPolicy implements DiscountPolicy{
    private int discountAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountAmount;
        }
        return 0;
    }
}
