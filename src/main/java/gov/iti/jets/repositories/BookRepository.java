package gov.iti.jets.repositories;

import gov.iti.jets.models.Book;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Repository
public class BookRepository implements Repository<Book,Integer>{

    DBConnectionManager dbConnectionManager;

    @Autowired
    public BookRepository(DBConnectionManager dbConnectionManager){
        this.dbConnectionManager = dbConnectionManager;
    }

    @Override
    public Book create(Book book) throws Exception {
        return dbConnectionManager.execute(entityManager -> {
            entityManager.persist(book);
            return book;
        });
    }

    @Override
    public Book find(Integer id) throws Exception {
        return dbConnectionManager.execute(entityManager -> {
            return entityManager.find(Book.class,id);
        });
    }

    @Override
    public List<Book> findAll() throws Exception {
        return dbConnectionManager.execute(entityManager -> {
            return entityManager.createQuery("SELECT b from Book b").getResultList();
        });
    }

    @Override
    public Book update(Book book) throws Exception {
        return dbConnectionManager.execute(entityManager -> {
            entityManager.merge(book);
            return book;
        });
    }

    @Override
    public boolean remove(Book book) throws Exception{
        return dbConnectionManager.execute(entityManager -> {

            entityManager.remove(entityManager.find(Book.class,book.getId()));
            return true;
        });
    }
}
