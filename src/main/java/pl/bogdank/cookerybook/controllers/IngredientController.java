package pl.bogdank.cookerybook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.bogdank.cookerybook.entity.Formula;
import pl.bogdank.cookerybook.entity.Ingredient;
import pl.bogdank.cookerybook.repository.IngredientsRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class IngredientController {

    IngredientsRepository ingredientsRepository;

    public IngredientController(IngredientsRepository ingredientsRepository) {
        this.ingredientsRepository = ingredientsRepository;
    }

    @GetMapping("/skladnik")
    public String listIgredients(Model model) {
        List<Ingredient> ingredients = ingredientsRepository.findAll();
        model.addAttribute("ingredients",ingredients);
        return "list_ingredients";
    }
    @GetMapping("/skladnik/{id}")
    public String editIngredient(@PathVariable("id") Long ingredientId, Model model) {
        Optional<Ingredient> optionalIngredient = ingredientsRepository.findById(ingredientId);
        if(optionalIngredient.isPresent()) {
            Ingredient ingredient = optionalIngredient.get();
            model.addAttribute("ingredient",ingredient);
            model.addAttribute("id", ingredientId);
            return "edit_ingredient";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/skladnik/{id}/edytuj")
    public String editIngredient(Ingredient ingredient) {
        ingredientsRepository.save(ingredient);
        return "redirect:/skladnik";
    }

    @PostMapping("/skladnik/{id}/usun")
    public String deleteIngredient(Ingredient ingredient) {
        if (ingredient.getFormulas().size() < 1) {
            ingredientsRepository.delete(ingredient);
            return "redirect:/skladnik";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/skladnik/nowy")
    public String newIngredient( Model model) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName("składnik");
        model.addAttribute("ingredient",ingredient);
        return "new_ingredient";
    }

    @PostMapping("/skladnik/nowy")
    public String addIngredient(Ingredient ingredient) {
        ingredientsRepository.save(ingredient);
        return "redirect:/skladnik";
    }
}
