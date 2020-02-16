package com.example.superbookstore;

import com.example.superbookstore.domain.Book;
import com.example.superbookstore.domain.BookRepository;
import com.example.superbookstore.domain.Category;
import com.example.superbookstore.domain.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class SuperbookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuperbookstoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			//adding some categories
			crepository.save(new Category("Sci-Fi"));
			crepository.save(new Category("IT"));
			crepository.save(new Category("BIT"));
			crepository.save(new Category("Thriller"));
			crepository.save(new Category("Biography"));

			Book s1= new Book("Spring", "Johnson", 1994, "dfsdfsdfds", 10, crepository.findByName("IT").get(0));
			Book s2= new Book("John2", "Johnson2", 1997, "dfsfsdfsd", 11, crepository.findByName("Thriller").get(0));
			Book s3= new Book("John3", "Johnson3", 2000, "sfsadfsd", 12, crepository.findByName("Biography").get(0));

			repository.save(s1);
			repository.save(s2);
			repository.save(s3);

		};
	}
}
