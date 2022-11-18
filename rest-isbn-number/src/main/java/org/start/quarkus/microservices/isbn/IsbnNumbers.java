package org.start.quarkus.microservices.isbn;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;
import java.time.Instant;

public class IsbnNumbers {
    @JsonbProperty("isbn_13")
    public String isbn13;
    @JsonbProperty("isbn_10")
    public String isbn10;
    @JsonbTransient
    public Instant generationDate;

    @Override
    public String toString() {
        return "IsbnNumbers{" +
                "isbn13='" + isbn13 + '\'' +
                ", isbn10='" + isbn10 + '\'' +
                ", generationDate=" + generationDate +
                '}';
    }
}
