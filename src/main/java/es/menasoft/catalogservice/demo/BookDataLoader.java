package es.menasoft.catalogservice.demo;

import es.menasoft.catalogservice.domain.Book;
import es.menasoft.catalogservice.domain.BookRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("testdata")
public class BookDataLoader {
    private final BookRepository bookRepository;

    public BookDataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData() {
        bookRepository.deleteAll();
        var book1 = Book.of("1234567890", "Harry Potter", "J. K. Rowling", 7.90);
        var book2 = Book.of("1234567891", "Habitos Atómicos", "James Clear", 9.90);
        bookRepository.saveAll(List.of(book1, book2));
    }
}
