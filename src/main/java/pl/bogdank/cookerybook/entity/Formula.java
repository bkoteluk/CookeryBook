package pl.bogdank.cookerybook.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "formulas")
public class Formula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private String image;
    private String name;
    @Column(length = 1000)
    private String method;
    @OneToMany(mappedBy = "formula")
    private List<Like> likes;
    @ManyToMany(mappedBy = "formulas")
    private List<Ingredient> ingredients;
    @ManyToMany(mappedBy = "formulas")
    @Column(name = "formulacategories")
    private List<FormulaCategory> formulaCategories;

    public Formula() {
    }

    public Formula(String name, String image, String method, List<Like> likes, List<Ingredient> ingredients, List<FormulaCategory> formulaCategories) {
        this.name = name;
        this.image = image;
        this.method = method;
        this.likes = likes;
        this.ingredients = ingredients;
        this.formulaCategories = formulaCategories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<FormulaCategory> getFormulaCategories() {
        return formulaCategories;
    }

    public void setFormulaCategories(List<FormulaCategory> recipeCategories) {
        this.formulaCategories = recipeCategories;
    }
}
