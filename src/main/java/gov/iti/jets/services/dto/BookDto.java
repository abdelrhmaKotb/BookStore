package gov.iti.jets.services.dto;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.NumberFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the {@link gov.iti.jets.models.Book} entity
 */
public class BookDto implements Serializable {
    private  Integer id;
    @NotEmpty(message = "title must have value")
    @NotBlank(message = "title must have value")
    @Size(min = 3,max = 20,message = "minimun 3 letters and max 20")
    private  String title;
    private  Double price;
    @NotNull(message = "book must have an author")
    private  AuthorDto author;

    public BookDto() {
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }

    public AuthorDto getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDto entity = (BookDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.title, entity.title) &&
                Objects.equals(this.price, entity.price) &&
                Objects.equals(this.author, entity.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price, author);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "title = " + title + ", " +
                "price = " + price + ", " +
                "author = " + author + ")";
    }
}