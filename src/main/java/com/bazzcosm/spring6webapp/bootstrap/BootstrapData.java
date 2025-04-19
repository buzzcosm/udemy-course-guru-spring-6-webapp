package com.bazzcosm.spring6webapp.bootstrap;

import com.bazzcosm.spring6webapp.domain.Author;
import com.bazzcosm.spring6webapp.domain.Book;
import com.bazzcosm.spring6webapp.domain.Publisher;
import com.bazzcosm.spring6webapp.repositories.AuthorRepository;
import com.bazzcosm.spring6webapp.repositories.BookRepository;
import com.bazzcosm.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(
            AuthorRepository authorRepository,
            BookRepository bookRepository,
            PublisherRepository publisherRepository
    ) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("9787115542946");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("9780764558313");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());

        Publisher publisher = new Publisher();
        publisher.setPublisherName("SFG Publishing");
        publisher.setAddress("600 N 6th Street");
        publisher.setCity("Minneapolis");
        publisher.setState("MN");
        publisher.setZipCode("55403");
        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}
