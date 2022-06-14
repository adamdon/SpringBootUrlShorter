package uk.co.adamdon.springbooturlshorter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.co.adamdon.springbooturlshorter.models.Link;

import java.util.List;

public interface LinkRepository extends JpaRepository<Link, Long>
{
    List<Link> findByCodeOrderById(String code);

}
