package org.start.quarkus.microservices.book;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;
import java.time.Instant;

@Schema(description = "A book")
public class Book {
    @Schema(required = true)
    @JsonbProperty("isbn_13")
    public String isbn13;
    @Schema(required = true)
    public String title;
    public String author;
    @JsonbProperty("year_of_publication")
    public int yearOfPublicaton;
    public String genre;
    @JsonbDateFormat("yyyy-MM-dd")
    @JsonbProperty("creation_date")
    @Schema(implementation = String.class, format = "date - yyyy-MM-dd")
    public Instant creationDate;


    @Override
    public String toString() {
        return "Book{" +
                "isbn13='" + isbn13 + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", yearOfPublicaton=" + yearOfPublicaton +
                ", genre='" + genre + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
