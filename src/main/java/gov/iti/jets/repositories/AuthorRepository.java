package gov.iti.jets.repositories;

import gov.iti.jets.models.Author;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Repository
public class AuthorRepository implements Repository<Author,Integer>{

    DBConnectionManager dbConnectionManager;

    @Autowired
    public AuthorRepository(DBConnectionManager dbConnectionManager){
        this.dbConnectionManager = dbConnectionManager;
    }
    @Override
    public Author create(Author author) throws Exception {
        return null;
    }

    @Override
    public Author find(Integer id) {
        return null;
    }

    @Override
    public List<Author> findAll() throws Exception {
        return  dbConnectionManager.<List<Author>>execute(entityManager -> {
           return entityManager.createQuery("SELECT a FROM Author a").getResultList();
        });
    }

    @Override
    public Author update(Author author) {
        return null;
    }

    @Override
    public boolean remove(Author author) {
        return false;
    }
}
