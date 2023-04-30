package gov.iti.jets.repositories;

import java.util.List;

public interface Repository<T,PK> {
    T create (T t) throws Exception;
    T find(PK id) throws Exception;
    List<T> findAll() throws Exception;
    T update(T t) throws Exception;
    boolean remove(T t) throws Exception;
}
