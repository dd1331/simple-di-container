package simple.spring;

import simple.spring.discount.DiscountPolicy;
import simple.spring.discount.FixedDiscountPolicy;
import simple.spring.discount.RateDiscountPolicy;
import simple.spring.member.MemberRepository;
import simple.spring.member.MemberService;
import simple.spring.member.MemberServiceImpl;
import simple.spring.member.MemoryMemberRepository;
import simple.spring.order.OrderService;
import simple.spring.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private DiscountPolicy discountPolicy() {
        return new FixedDiscountPolicy();
//        return new RateDiscountPolicy();
    }


}
