package simple.spring;

import simple.spring.member.Grade;
import simple.spring.member.Member;
import simple.spring.member.MemberService;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member foundMember = memberService.findMember(1L);
        System.out.println("member = " + member.getName());
        System.out.println("foundMember = " + foundMember.getName());
    }
}
