package org.start.quarkus.microservices.book;

import io.quarkus.test.Mock;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Mock
@RestClient
public class MockNumberProxy implements BookNumberProxy{
    @Override
    public IsbnNumbersThirteen generateIsbNumbers() {
        IsbnNumbersThirteen isbnNumbersThirteen = new IsbnNumbersThirteen();
        isbnNumbersThirteen.isbn13 = "13-Mock ISBN";
        return isbnNumbersThirteen;
    }
}
