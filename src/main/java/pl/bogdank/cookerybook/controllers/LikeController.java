package pl.bogdank.cookerybook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.bogdank.cookerybook.entity.Like;
import pl.bogdank.cookerybook.repository.LikesRepository;

@Controller
public class LikeController {

    LikesRepository likesRepository;

    public LikeController(LikesRepository likesRepository) {
        this.likesRepository = likesRepository;
    }

//    @GetMapping("/opinia/zapisz/{id}")
//    public String likeForm(@PathVariable("id") Long id, Model model) {
//        model.addAttribute("like", new Like());
//        model.addAttribute("id", id);
//        return "";
//    }
//    @PostMapping("/opinia/zapisz")
//    public String addLike(Long id, Like like) {
//        like.setId(id);
//        likesRepository.save(like);
//        return "redirect:/przepis/{id}";
//    }
}
