package gov.iti.jets.repositories;

import gov.iti.jets.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Repository
public class AuthorRepository implements Repository<Author,Integer>{

    JdbcTemplate jdbcTemplate;
    SimpleJdbcInsert insertAuthor;

    @Autowired
    public AuthorRepository(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
        insertAuthor = new SimpleJdbcInsert(dataSource);

    }
    @Override
    public Author create(Author author) throws Exception {
        insertAuthor.withTableName("author").usingColumns("name").usingGeneratedKeyColumns("id");
        insertAuthor.execute(new BeanPropertySqlParameterSource(author));
        return author;
    }

    @Override
    public Author find(Integer id) {
        String query = "SELECT * FROM author where id = ?";
        Object[] args = new Object[] {id};
        return  jdbcTemplate.queryForObject(query,args,new BeanPropertyRowMapper<>(Author.class));
    }

    @Override
    public List<Author> findAll() throws Exception {
        String query = "SELECT * FROM author";
        List<Author> authors = jdbcTemplate.query(query,new BeanPropertyRowMapper<>(Author.class));
        return authors;
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
