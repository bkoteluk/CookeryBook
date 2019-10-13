package pl.bogdank.cookerybook.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="formulacategories")
public class FormulaCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String icon;
    @ManyToMany(mappedBy = "formulaCategories")
    List<Formula> formulas;

    public FormulaCategory() {
    }

    public FormulaCategory(String name, String icon, List<Formula> formulas) {
        this.name = name;
        this.icon = icon;
        this.formulas = formulas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<Formula> getFormulas() {
        return formulas;
    }

    public void setFormulas(List<Formula> formulas) {
        this.formulas = formulas;
    }
}
