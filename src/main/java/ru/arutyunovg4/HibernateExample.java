package ru.arutyunovg4;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.arutyunovg4.config.HibernateConfig;
import ru.arutyunovg4.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HibernateExample {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        EntityManagerFactory entityManagerFactory = context.getBean(EntityManagerFactory.class);
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();


           Section section = entityManager.find(Section.class, 14) ;
            System.out.println(section);



            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Exception caught, executing rollback...");
            ;
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }


        context.close();
    }
}
