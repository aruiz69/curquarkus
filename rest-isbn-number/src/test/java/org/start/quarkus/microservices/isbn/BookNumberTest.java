package org.start.quarkus.microservices.isbn;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

@QuarkusTest
public class BookNumberTest {

    @Test
    public void shouldGenerateIsNumbersISBN() {
        given()
                .when().get("/api/isbn")
                .then()
                .statusCode(200)
                .body("isbn_13", startsWith("13-"))
                .body("isbn_10", startsWith("10-"))
                .body(not(hasItem("generationDate")));
    }

}