package hello.core;

import hello.model.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * @author Svetlana Chapskaya
 *         Created on 21.07.2016.
 */
@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
    List<Person> findByLastName(@Param("name") String name);
    List<Person> findByFirstName(@Param("name") String name);
}
