package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("your_persistence_unit");
        EntityManager entityManager = emf.createEntityManager();
        PersonRepository repository = new PersonRepository(entityManager);

        Person person = new Person("Ivan", 30);
        repository.addPerson(person);

        person.setAge(31);
        repository.updatePerson(person);

        repository.deletePerson(person.getId());

        entityManager.close();
        emf.close();
    }
}