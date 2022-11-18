package org.start.quarkus.microservices.book;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import org.jboss.logging.annotations.Param;

import javax.inject.Inject;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.PrintWriter;
import java.time.Instant;

@Path("/api/books")
public class BookResource {
    @RestClient
    BookNumberProxy bookNumberProxy;
    @Inject
    Logger logger;
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Retry( maxRetries = 2 , delay = 2000)
    @Fallback(fallbackMethod = "fallingBackOnCreateABook")
    public Response createABook(
            @FormParam("title") String title,
            @FormParam("author") String author,
            @FormParam("year") int yearOfPublication,
            @FormParam("genre") String genre ){

        Book book = new Book();
        book.isbn13 = bookNumberProxy.generateIsbNumbers().isbn13;
        book.title = title;
        book.author = author;
        book.yearOfPublicaton = yearOfPublication;
        book.genre = genre;
        book.creationDate = Instant.now();
        logger.info("Book created :" + book);
        return Response.status(201).entity(book).build();


    }

    public Response fallingBackOnCreateABook(
            String title,
            String author,
            int yearOfPublication,
            String genre ){

        Book book = new Book();
        book.isbn13 = "13-Was not create the ISBN Number, try later";
        book.title = title;
        book.author = author;
        book.yearOfPublicaton = yearOfPublication;
        book.genre = genre;
        book.creationDate = Instant.now();
        saveBookSaveOnDist(book);
        logger.warn("Book save on disk:" + book);
        return Response.status(206).entity(book).build();


    }

    private void saveBookSaveOnDist(Book book) {
        String bookinJson = JsonbBuilder.create().toJson(book);
        try(PrintWriter out = new PrintWriter("book-"+Instant.now().toEpochMilli()+".json")){
            out.println(bookinJson);
        }catch (Exception exp){
            logger.error("Error to save fallback call");
        }
    }

}