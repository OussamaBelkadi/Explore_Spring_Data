package or.os.spring_data;

import or.os.spring_data.models.Video;
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
    public CommandLineRunner commandLineRunner(VideoRepository repository) {
        return args -> {
            Video video = Video.builder()
                    .title("Os")
                    .length(12)
                    .build();
            repository.save(video);
            System.out.println("Spring Data JPA Application");
            // You can add your logic here to test the application
        };
    }
}
