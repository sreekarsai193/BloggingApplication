package com.example.bloggingapplication.guest;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;;

@Controller
@RequestMapping("")
public class GuestController {
    private final ArticleRepository articleRepository;

    public GuestController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;

    }

    @GetMapping("/home")
    public String ShowHomePage(Model model) {
        model.addAttribute("articles",articleRepository.GetAllArticles());
        return "guesthome";
    }

    @GetMapping("/article/{name}")
    public String ShowArticle(@PathVariable String name, Model model) {
        for(Article article : articleRepository.GetAllArticles()){
            if(article.getTitle().equals(name)){
                model.addAttribute("article",article);
                return "article";
            }
        }
        return "error";
    }

}
