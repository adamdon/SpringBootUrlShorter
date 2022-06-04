package uk.co.adamdon.springbooturlshorter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.co.adamdon.springbooturlshorter.models.Link;

public interface LinkRepository extends JpaRepository<Link, Long>
{


}
