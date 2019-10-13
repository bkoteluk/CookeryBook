package pl.bogdank.cookerybook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.bogdank.cookerybook.entity.Formula;
import pl.bogdank.cookerybook.repository.FormulaRepository;

import java.util.List;

@Controller
public class HomeController {

    FormulaRepository formulaRepository;

    public HomeController(FormulaRepository formulaRepository) {
        this.formulaRepository = formulaRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Formula> allFormulas = formulaRepository.findAll();
        model.addAttribute("formulas", allFormulas);
        return "list_formulas";
    }
}
