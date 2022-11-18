package org.start.quarkus.microservices.isbn;

import org.eclipse.microprofile.openapi.annotations.ExternalDocumentation;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")

@OpenAPIDefinition(info = @Info(title = "Number ISBN Microservice",
        description = "This Ms generated several numbers for books",
        version = "1.0",
        contact=@Contact(name = "name1", url = "www.somespace.com" ,email = "somena@company.com")),
        externalDocs = @ExternalDocumentation(url = ""),
        tags = {@Tag(name = "api", description = "some desc"),
                @Tag(name = "api-axample", description = "some desc2")
        }

)

public class NumberMicroservice extends Application {

}
