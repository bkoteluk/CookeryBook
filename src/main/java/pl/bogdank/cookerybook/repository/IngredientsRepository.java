package pl.bogdank.cookerybook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.bogdank.cookerybook.entity.Ingredient;

import java.util.List;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredient, Long> {

    @Query("SELECT f.ingredients FROM Formula f WHERE f.id = :id")
    List<Ingredient> getAllByFormulaId(@Param("id") Long formulaId);

}
