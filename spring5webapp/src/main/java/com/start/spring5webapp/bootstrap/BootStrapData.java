package com.start.spring5webapp.bootstrap;

import com.start.spring5webapp.domain.Author;
import com.start.spring5webapp.domain.Book;
import com.start.spring5webapp.domain.Publisher;
import com.start.spring5webapp.repositories.AuthorRepository;
import com.start.spring5webapp.repositories.BookRepository;
import com.start.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;

    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Stated brootstap....");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("Fl");
        publisherRepository.save(publisher);

        System.out.println("Publisher count: " + publisherRepository.count());

        publisher.setCity("London");

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Drive Design", "12345678");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);


        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEjb = new Book("JEE2 Java Development with EJB", "987654321");
        rod.getBooks().add(noEjb);
        noEjb.getAuthors().add(rod);

        noEjb.setPublisher(publisher);
        publisher.getBooks().add(noEjb);

        authorRepository.save(rod);
        bookRepository.save(noEjb);
        publisherRepository.save(publisher);

        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Publisher Number of books: " + publisher.getBooks().size());


    }
}
