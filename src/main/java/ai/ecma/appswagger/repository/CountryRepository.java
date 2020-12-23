package ai.ecma.appswagger.repository;

import ai.ecma.appswagger.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Integer> {
}
