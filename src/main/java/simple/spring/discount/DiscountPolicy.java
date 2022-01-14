package simple.spring.discount;

import simple.spring.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);


}
