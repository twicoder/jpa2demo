package com.chinwe.pojo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BookJPATest {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqljpa");
    private static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
        persistBook(new Book(1L,"H2G2","Best Scifi Book",12.5f,"1234-5678-5678"));

        Book book = findBook(1L);
        System.out.println(book);
    }

    private static void persistBook(Book book) {
        em.persist(book);
    }

    private static Book findBook(Long id) {
        return em.find(Book.class, id);
    }
}
