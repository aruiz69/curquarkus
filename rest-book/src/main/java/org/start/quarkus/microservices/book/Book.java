package org.start.quarkus.microservices.book;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;
import java.time.Instant;

public class Book {
    @JsonbProperty("isbn_13")
    public String isbn13;
    public String title;
    public String author;
    @JsonbProperty("year_of_publication")
    public int yearOfPublicaton;
    public String genre;
    @JsonbDateFormat("yyyy-MM-dd")
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
