package pl.bogdank.cookerybook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.bogdank.cookerybook.repository.LikesRepository;
import pl.bogdank.cookerybook.repository.SelectStat;

import java.util.List;

@Controller
public class LikeController {

    LikesRepository likesRepository;

    public LikeController(LikesRepository likesRepository) {
        this.likesRepository = likesRepository;
    }

    @GetMapping("/przepis/stat/")
    public String showStatistics(Model model) {
        List<SelectStat> statistics = likesRepository.getLikesStatistic();
        model.addAttribute("statistics", statistics);
        return "list_likesstatistics";
    }
}
