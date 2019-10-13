package pl.bogdank.cookerybook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bogdank.cookerybook.entity.Like;

import java.util.List;

public interface LikesRepository extends JpaRepository<Like, Long> {

    List<Like> findByFormulaId(Long FormulaId);
}
