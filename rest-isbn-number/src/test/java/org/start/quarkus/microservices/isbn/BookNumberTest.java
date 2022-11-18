package org.start.quarkus.microservices.isbn;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class BookNumberTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/api/isbn")
          .then()
             .statusCode(200)
             .body(is("Hello RESTEasy"));
    }

}