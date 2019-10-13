package pl.bogdank.cookerybook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.bogdank.cookerybook.entity.Formula;
import pl.bogdank.cookerybook.entity.FormulaCategory;
import pl.bogdank.cookerybook.repository.FormulaCategoryRepository;
import pl.bogdank.cookerybook.repository.FormulaRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class FormulaCategoryController {

    FormulaRepository formulaRepository;
    FormulaCategoryRepository formulaCategoryRepository;

    public FormulaCategoryController(FormulaCategoryRepository formulaCategoryRepository, FormulaRepository formulaRepository) {
        this.formulaCategoryRepository = formulaCategoryRepository;
        this.formulaRepository = formulaRepository;
    }

    @GetMapping("/kategoria")
    public String categoryList(Model model) {
        List<FormulaCategory> formulaCategories = formulaCategoryRepository.findAll();
        model.addAttribute("categories", formulaCategories);
        return("list_category");
    }

    @GetMapping("/kategoria/{id}")
    public String editCategory(@PathVariable("id") Long categoryId, Model model) {
        Optional<FormulaCategory> optionalFormulaCategory = formulaCategoryRepository.findById(categoryId);
        if(optionalFormulaCategory.isPresent()) {
            FormulaCategory formulaCategory = optionalFormulaCategory.get();
            model.addAttribute("category",formulaCategory);
            model.addAttribute("id", categoryId);
            return "edit_category";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/kategoria/{id}/edytuj")
    public String editCategory(FormulaCategory formulaCategory) {
        formulaCategoryRepository.save(formulaCategory);
        return "redirect:/kategoria";
    }

    @PostMapping("/kategoria/{id}/usun")
    public String deleteCategory(FormulaCategory formulaCategory) {
        if (formulaCategory.getFormulas().size() < 1) {
            formulaCategoryRepository.delete(formulaCategory);
            return "redirect:/kategoria";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/kategoria/nowa")
    public String newCategory(Model model) {
        FormulaCategory formulaCategory = new FormulaCategory();
        model.addAttribute("category", formulaCategory);
        return("new_category");
    }


    @PostMapping("/kategoria/nowa")
    public String addCategory(FormulaCategory formulaCategory) {
        formulaCategoryRepository.save(formulaCategory);
        return "redirect:/";
    }

    @GetMapping("/kategoria/lista1/")
    public String listFormulasOrderByCategory(Model model) {
        List<Formula> formulas = formulaRepository.findAll();
        List<FormulaCategory> formulaCategories = formulaCategoryRepository.findAll();
        model.addAttribute("categories", formulaCategories);
        model.addAttribute("formulas", formulas);
        return "list_formulas_categoryorder";
    }
}
