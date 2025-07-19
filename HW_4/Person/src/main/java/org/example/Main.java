package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("your_persistence_unit");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        Person person1 = new Person("Ivan", 30);
        Person person2 = new Person("Anna", 25);
        Person person3 = new Person("John", 40);

        entityManager.persist(person1);
        entityManager.persist(person2);
        entityManager.persist(person3);

        entityManager.getTransaction().commit();

        System.out.println("Объекты Person сохранены в базу данных.");

        entityManager.close();
        emf.close();
    }
}