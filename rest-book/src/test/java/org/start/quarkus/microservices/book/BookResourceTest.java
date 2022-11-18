package org.start.quarkus.microservices.book;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;

@QuarkusTest
public class BookResourceTest {

    @Test
    public void shouldCreateABook() {
        given()
                .formParam("title", "Understanding Quarkus")
                .formParam("author", "Roberto Zara")
                .formParam("year", 2022)
                .formParam("genre", "Novel")
                .when().post("/api/books")
                .then()
                .statusCode(201)
                .body("isbn_13", startsWith("13-"))
                .body("title", is("Understanding Quarkus"))
                .body("year_of_publication", is(2022))
                .body("genre", is("Novel"))
                .body("creation_date", startsWith("20"));
    }

}