package or.os.spring_data.repository;

import jakarta.persistence.NamedQuery;
import jakarta.transaction.Transactional;
import or.os.spring_data.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    //   Update list of column value with this query
    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age")
    void updateAllAuthorsAge(int age);

    List<Author> findAllByNamedQueries(@Param("age") int age);
    List<Author> findAllByFirstName(String firstName);
    List<Author> findAllByFirstNameIgnoreCase(String str);
    List<Author> findAllByFirstNameContainingIgnoreCase(String str);
    List<Author> findAllByFirstNameStartingWithIgnoreCase(String str);
    List<Author> findAllByFirstNameEndingWithIgnoreCase(String str);

}
