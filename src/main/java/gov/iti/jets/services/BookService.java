package gov.iti.jets.services;

import gov.iti.jets.models.Book;
import gov.iti.jets.repositories.BookRepository;
import gov.iti.jets.services.dto.AuthorDto;
import gov.iti.jets.services.dto.BookDto;
import gov.iti.jets.services.mapper.AuthorMapper;
import gov.iti.jets.services.mapper.BookMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    BookRepository bookRepository;
    BookMapper mapper = BookMapper.INSTANCE;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<BookDto> getAll() throws Exception{
        return mapper.toDto(bookRepository.findAll());
    }

    public BookDto save(BookDto bookDto) throws Exception{
        Book book = bookRepository.create(mapper.toEntity(bookDto));
        return mapper.toDto(book);
    }

    public boolean remove(BookDto bookDto) throws Exception{
       return bookRepository.remove(mapper.toEntity(bookDto));
    }

    public BookDto get(int id) throws Exception{
        return mapper.toDto(bookRepository.find(id));
    }

    public BookDto update(BookDto bookDto) throws Exception{
        bookRepository.update(mapper.toEntity(bookDto));
        return bookDto;
    }
}
