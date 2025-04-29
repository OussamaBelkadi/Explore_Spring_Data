package or.os.spring_data;

import com.github.javafaker.Faker;
import or.os.spring_data.models.Author;
import or.os.spring_data.models.Video;
import or.os.spring_data.repository.AuthorRepository;
import or.os.spring_data.repository.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataExploreApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataExploreApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AuthorRepository repository) {
        return args -> {
            for (int i = 1; i <= 10; i++) {
                Faker faker = new Faker();
                Author author = Author.builder()
                        .firstName(faker.name().firstName())
                        .lastName(faker.name().lastName())
                        .age(faker.number().numberBetween(20, 60))
                        .email(faker.internet().emailAddress())
                        .build();
                repository.save(author);
            }
            repository.updateAllAuthorsAge(26);
            System.out.println("Spring Data JPA Application");
            // You can add your logic here to test the application
        };
    }
}
