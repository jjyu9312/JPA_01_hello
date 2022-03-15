package com.springwook.jpa_01_hello.jpa01;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("happy");

        EntityManager em = emf.createEntityManager();

        // 트랜잭션 안에서 작업해야 하기 때문에 트랜잭션을 시작해줘야함.
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 단방향 관계
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            //member.setTeamId(team.getTeamId());
            member.setTeam(team); // 알아서 JPA가 team을 찾아옴
            em.persist(member);

            em.flush();
            em.clear();

            // 조회
            Member findM = em.find(Member.class, member.getId());
            Team findTeam = findM.getTeam();
            System.out.println("findTeamName : " + findTeam.getName());

            tx.commit();
            /* 생성
            Member member = new Member();

            member.setId(1L);
            member.setName("kkw");

            em.persist(member);
            */

            /* 조회
            Member findMember = em.find(Member.class, 1L);
            System.out.format("findMember : %s", findMember.getId());
            System.out.format("findMember : %s", findMember.getName());
            */

            /* 수정
            Member findMember = em.find(Member.class, 1L);
            findMember.setName("kim");
            */

            /* 삭제
            Member findMember = em.find(Member.class, 1L);
            em.remove(findMember);
            */

            /*
            // Member 객체를 대상으로 조회
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(1)
                    .setMaxResults(5)
                    .getResultList();

            for (Member member : result) {
                System.out.println("member.name = " + member.getName());
            }
             */

            /*
            // 현재 비영속 상태
            Member member = new Member();
            member.setId(5L);
            member.setName("3k");

            // 영속 상태
            System.out.println("==========BEFORE==========");
            em.persist(member);
            System.out.println("==========AFTER==========");
             */

            /*
            Member findMember1 = em.find(Member.class, 4L);
            Member findMember2 = em.find(Member.class, 4L);

            System.out.println("findMember1.id = " + findMember1.getId());
            System.out.println("findMember1.name = " + findMember1.getName());
            System.out.println("======================================");
            System.out.println("findMember1.id = " + findMember1.getId());
            System.out.println("findMember1.name = " + findMember1.getName());
             */

            /*
            // 영속
            Member member1 = new Member(150L, "A");
            Member member2 = new Member(200L, "B");

             em.persist(member1);
             em.persist(member2);

            System.out.println("=====================================");
             */

            /*
            Member findMember = em.find(Member.class, 150L);
            findMember.setName("Z");

            // em.persist(findMember); 해당 코드는 필요없음. 왜냐하면 Collections과 같다고 생각하면 됨
             */


            /*
            // flush 예시
            Member member = new Member(300L, "mmm");
            em.persist(member);

            em.flush();

            System.out.println("===============================");

             */

            /*
            Member findMember1 = em.find(Member.class, 4L);
            findMember1.setName("gong");

            // 준영속 상태 -> 쿼리 안 날아감
            em.detach(findMember1);
            System.out.println("===============================");
            */

        } catch (Exception e) {
            tx.rollback();

        } finally {
            em.close();
        }

        emf.close();
    }
}
