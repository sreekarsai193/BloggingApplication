package com.example.bloggingapplication.guest;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequestMapping("")
@Controller
public class AdminController {
    private final ArticleRepository articleRepository;

    public AdminController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;

    }

    @GetMapping("/admin")
    public String ShowHomePage(Model model) {
        model.addAttribute("articles",articleRepository.GetAllArticles());
        return "dashboard";
    }
    @GetMapping("/new")
    public String ShowNewArticlePage(Model model) {
        model.addAttribute("article", new Article());
        return "newArticle";
    }

    @PostMapping("/delete/{title}")
    public String DeleteArticle(@PathVariable String title) throws IOException {
       // System.out.println(title);
        articleRepository.DeleteArticle(title);
        //articleRepository.LoadArticles();
        return "redirect:/admin";
    }

    @PostMapping("/submitarticle")
    public String AddArticle(@ModelAttribute("article") Article article) throws IOException {
        articleRepository.AddArticle(article);
        return "redirect:/admin";
    }

    @PostMapping("/article/edit")
    public String   EditArticle(@ModelAttribute("article") Article article) throws IOException {
        articleRepository.UpdateArticle(article);
        return "redirect:/admin";
    }

    @GetMapping("/edit/{title}")
    public String EditArticle(@PathVariable String title, Model model) throws IOException {
        Article article=articleRepository.GetArticleByTitle(title);
        model.addAttribute("article",article);
        return "editArticle";
    }
}
