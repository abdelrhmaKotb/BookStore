package gov.iti.jets.services;

import gov.iti.jets.repositories.AuthorRepository;
import gov.iti.jets.services.dto.AuthorDto;
import gov.iti.jets.services.mapper.AuthorMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public List<AuthorDto> getAll() throws Exception{
        return AuthorMapper.INSTANCE.toDto(authorRepository.findAll());
    }


}
