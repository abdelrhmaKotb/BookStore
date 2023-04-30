package gov.iti.jets.services;

import gov.iti.jets.models.Author;
import gov.iti.jets.models.Book;
import gov.iti.jets.repositories.AuthorRepository;
import gov.iti.jets.services.dto.AuthorDto;
import gov.iti.jets.services.dto.BookDto;
import gov.iti.jets.services.mapper.AuthorMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    AuthorRepository authorRepository;
    AuthorMapper mapper = AuthorMapper.INSTANCE;

    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public List<AuthorDto> getAll() throws Exception{
        return AuthorMapper.INSTANCE.toDto(authorRepository.findAll());
    }

    public AuthorDto save(AuthorDto authorDto) throws Exception{
        Author author = authorRepository.create(mapper.toEntity(authorDto));
        return mapper.toDto(author);
    }


}
