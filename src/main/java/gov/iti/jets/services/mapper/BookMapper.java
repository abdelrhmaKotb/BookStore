package gov.iti.jets.services.mapper;

import gov.iti.jets.models.Author;
import gov.iti.jets.models.Book;
import gov.iti.jets.services.dto.AuthorDto;
import gov.iti.jets.services.dto.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDto toDto(Book e);

    Book toEntity(BookDto d);

    List<BookDto> toDto(List<Book> es);

    List<Book> toEntity(List<BookDto> ds);
}
