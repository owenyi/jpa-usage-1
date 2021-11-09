package jpabook.jpashop.scheduler;

import jpabook.jpashop.Member;
import jpabook.jpashop.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class Scheduler {

    @Autowired MemberRepository memberRepository;

    @Scheduled(cron = "*/10 * * * * *")
    @Transactional
    public void cronJobSch() {
        // given
        Member member = new Member();
        member.setUsername("memberA");

        // when
        Long savedId = memberRepository.save(member);
        Member findMember = memberRepository.find(savedId);

        // then
        System.out.println(findMember.getId().equals(member.getId()));
        System.out.println(findMember.getUsername().equals(member.getUsername()));
    }

}
