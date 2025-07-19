package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonRepository {
    private EntityManager entityManager;

    public PersonRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void addPerson(Person person) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(person);
        transaction.commit();
    }

    public void updatePerson(Person person) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(person);
        transaction.commit();
    }

    public void deletePerson(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Person person = entityManager.find(Person.class, id);
        if (person != null) {
            entityManager.remove(person);
        }
        transaction.commit();
    }
}