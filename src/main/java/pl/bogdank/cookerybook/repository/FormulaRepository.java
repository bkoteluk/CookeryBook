package pl.bogdank.cookerybook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bogdank.cookerybook.entity.Formula;

@Repository
public interface FormulaRepository extends JpaRepository<Formula, Long> {

}
