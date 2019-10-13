package pl.bogdank.cookerybook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.bogdank.cookerybook.entity.FormulaCategory;

import java.util.List;

@Repository
public interface FormulaCategoryRepository extends JpaRepository<FormulaCategory, Long> {

    @Query("SELECT f.formulaCategories FROM Formula f WHERE f.id = :id")
    List<FormulaCategory> getAllByFormulaId(@Param("id") Long formulaId);

}
