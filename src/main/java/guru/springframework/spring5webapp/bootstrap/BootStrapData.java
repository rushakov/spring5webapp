package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author1 = new Author("Mark", "Twain");
        Book book1 = new Book("Tom Sauer","123456");
        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);
        authorRepository.save(author1);
        bookRepository.save(book1);

        Author author2 = new Author("Jack", "Black");
        Book book2 = new Book("Metal", "645987");
        author2.getBooks().add(book2);
        book2.getAuthors().add(author2);
        authorRepository.save(author2);
        bookRepository.save(book2);

        System.out.println("Beginning of output***************************************************************");
        bookRepository.findAll().forEach(System.out::println);
        System.out.println("books count = " + bookRepository.count());
    }
}
