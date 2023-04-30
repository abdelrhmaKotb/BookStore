package gov.iti.jets.services.mapper;

import gov.iti.jets.models.Author;
import gov.iti.jets.services.dto.AuthorDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    AuthorDto toDto(Author e);

    Author toEntity(AuthorDto d);

    List<AuthorDto> toDto(List<Author> es);

    List<Author> toEntity(List<AuthorDto> ds);

}
