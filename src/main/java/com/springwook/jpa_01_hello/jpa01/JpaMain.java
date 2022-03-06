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

            // Member 객체를 대상으로 조회
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(1)
                    .setMaxResults(5)
                    .getResultList();

            for (Member member : result) {
                System.out.println("member.name = " + member.getName());
            }

            tx.commit();

        } catch (Exception e) {
            tx.rollback();

        } finally {
            em.close();
        }

        emf.close();
    }
}
