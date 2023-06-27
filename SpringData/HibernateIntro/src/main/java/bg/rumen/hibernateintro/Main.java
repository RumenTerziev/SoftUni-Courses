package bg.rumen.hibernateintro;

import bg.rumen.hibernateintro.entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Student found = em.find(Student.class, 2L);
        System.out.println(found.getId());
        System.out.println(found.getName());

        em.getTransaction().commit();
    }
}
