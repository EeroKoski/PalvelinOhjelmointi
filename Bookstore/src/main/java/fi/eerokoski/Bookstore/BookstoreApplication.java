package fi.eerokoski.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.eerokoski.Bookstore.domain.Book;
import fi.eerokoski.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookStore(BookRepository repository) {
		return (args) -> {
			log.info("save a couple of books");
					repository.save(new Book("Sipulinkasvatusopas", "Seppo Sepilainen", 1976, "978-3-16-148410-0", 19.90));
					repository.save(new Book("Porkkana", "Simo Salo", 1875, "978-3-16-148410-1", 17.95));
					
					log.info("fetch all books");
					for (Book book : repository.findAll()) {
							log.info(book.toString());
					}
					
		};
	}
}
