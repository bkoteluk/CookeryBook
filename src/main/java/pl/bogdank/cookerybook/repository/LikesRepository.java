package pl.bogdank.cookerybook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.bogdank.cookerybook.entity.Like;

import java.util.List;

public interface LikesRepository extends JpaRepository<Like, Long> {

    List<Like> findByFormulaId(Long FormulaId);

    @Query(value="SELECT COUNT(LIKES.ID) as COUNTING, LIKES.FORMULA_ID, FORMULAS.NAME FROM  LIKES JOIN FORMULAS ON LIKES.FORMULA_ID=FORMULAS.ID GROUP BY FORMULA_ID ORDER BY COUNTING DESC ;", nativeQuery = true)
    public List<SelectStat> getLikesStatistic();
}
