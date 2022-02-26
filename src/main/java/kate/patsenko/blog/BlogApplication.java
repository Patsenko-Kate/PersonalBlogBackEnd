package kate.patsenko.blog;

import kate.patsenko.blog.dao.DAO;
import kate.patsenko.blog.model.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogApplication {

    private static DAO<Person> Dao;

    public BlogApplication(DAO<Person> dao) {
        this.Dao = dao;
    }

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }
}
