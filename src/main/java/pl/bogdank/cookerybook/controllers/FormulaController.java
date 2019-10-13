package pl.bogdank.cookerybook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.bogdank.cookerybook.entity.FormulaCategory;
import pl.bogdank.cookerybook.entity.Ingredient;
import pl.bogdank.cookerybook.entity.Like;
import pl.bogdank.cookerybook.entity.Formula;
import pl.bogdank.cookerybook.repository.FormulaCategoryRepository;
import pl.bogdank.cookerybook.repository.IngredientsRepository;
import pl.bogdank.cookerybook.repository.LikesRepository;
import pl.bogdank.cookerybook.repository.FormulaRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class FormulaController {

    FormulaRepository formulaRepository;
    LikesRepository likesRepository;
    IngredientsRepository ingredientsRepository;
    FormulaCategoryRepository formulaCategoryRepository;

    public FormulaController(FormulaRepository formulaRepository, LikesRepository likesRepository, IngredientsRepository ingredientsRepository, FormulaCategoryRepository formulaCategoryRepository) {
        this.formulaRepository = formulaRepository;
        this.likesRepository = likesRepository;
        this.ingredientsRepository = ingredientsRepository;
        this.formulaCategoryRepository = formulaCategoryRepository;
    }

    @GetMapping("/przepis/{id}")
    public String formulaInfo(@PathVariable("id") Long id, Model model) {
        Optional<Formula> formulaOptional = formulaRepository.findById(id);
        List<Like> likes = likesRepository.findByFormulaId(id);
        List<Ingredient> ingredients = ingredientsRepository.getAllByFormulaId(id);
        List<FormulaCategory> formulaCategories = formulaCategoryRepository.getAllByFormulaId(id);
        Like newlike = new Like();
        if (formulaOptional.isPresent()) {
            Formula formula = formulaOptional.get();
            newlike.setFormula(formula);
            model.addAttribute("formula", formula);
            model.addAttribute("likes", likes);
            model.addAttribute("newlike", newlike);
            model.addAttribute("ingredients", ingredients);
            model.addAttribute("categories", formulaCategories);
            model.addAttribute("id", id);
            return "info_formula";
        } else
            return "redirect:/";

    }

    @GetMapping("/przepis/{id}/opinia/edytuj/{likeid}")
    public String editLike(@PathVariable("id") Long id, @PathVariable("likeid") Long likeid, Model model) {
        Optional<Like> likeOptional = likesRepository.findById(likeid);
        if (likeOptional.isPresent()) {
            Like like = likeOptional.get();
            model.addAttribute("like", like);
            model.addAttribute("likeid", likeid);
            model.addAttribute("id", id);
            return "edit_like";
        } else
            return "redirect:/przepis/{id}";
    }

    @PostMapping("/przepis/{id}/opinia/edytuj/{likeid}")
    public String changeLike(Long id, Long likeid, Like like ) {
        likesRepository.save(like);
        return "redirect:/przepis/{id}";
    }

    @PostMapping("/przepis/{id}/opinia/usun/{likeid}")
    public String deleteLike(Long id, Long likeid, Like like ) {
        likesRepository.delete(like);
        return "redirect:/przepis/{id}";
    }

    @GetMapping("/przepis/nowy")
    public String newFormula(Model model) {
        Formula formula = new Formula();
        List<FormulaCategory> formulaCategories = formulaCategoryRepository.findAll();
        List<Ingredient> ingredients = ingredientsRepository.findAll();
        model.addAttribute("formula", formula);
        model.addAttribute("categories", formulaCategories);
        model.addAttribute("ingredients", ingredients);
        return "new_formula";
    }

    @PostMapping("/przepis/nowy")
    public String saveFormula(Formula formula, List<FormulaCategory> categories, List<Ingredient> ingredients) {
//        for (FormulaCategory category : categories) {
//            formula.getFormulaCategories().add(category);
//        }
//        for (Ingredient ingredient : ingredients) {
//            formula.getIngredients().add(ingredient);
//        }
        formulaRepository.save(formula);
        return "reditect:/";
    }

    @PostMapping("/przepis/{id}/opinia/zapisz")
    public String addLike(Long id, Like like) {

        likesRepository.save(like);
        return "redirect:/przepis/{id}";
    }
}
