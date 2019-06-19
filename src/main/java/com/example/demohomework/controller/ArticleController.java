package com.example.demohomework.controller;

import com.example.demohomework.repository.articleRepository.IArticleRepository;
import com.example.demohomework.repository.articleRepository.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;


@Controller
public class ArticleController {

    @Autowired
    private IArticleRepository articleRepository;

    @GetMapping("/")
    public String getArticle(Model model,
                             @RequestParam(defaultValue = "1") Integer page,
                             @RequestParam(defaultValue = "10") Integer limit) {
            model.addAttribute("currentPage", page);
            int lastPage = (articleRepository.countArticle() / limit) + (articleRepository.countArticle() % limit == 0 ? 0 : 1);
            model.addAttribute("lastPage", lastPage);

            if (page < 1 || page > lastPage)
                page = 1;
            if(limit != 10)
                limit = 10;

            model.addAttribute("articles", articleRepository.paginate(page, limit));
        return "home";
    }

    @GetMapping("/add")
    public String getAdd(ModelMap modelMap) {
        Article article = new Article();
        article.setId(articleRepository.getLastId() + 1);
        modelMap.addAttribute("index", article.getId());
        return "add";
    }

    @PostMapping("/addsubmit")
    public String getAddSumit(@ModelAttribute Article article, @RequestParam("thumbnailImg") MultipartFile file) {
        if (file != null && !Objects.requireNonNull(file.getOriginalFilename()).isEmpty()) {
            try {
                String fileName = UUID.randomUUID() + "." + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
                Files.copy(file.getInputStream(), Paths.get("src/main/java/com/example/demohomework/image/", fileName));;
                article.setThumbnail(fileName);
                System.out.println(fileName);
                System.out.println("work ");
            } catch (IOException e) {
                System.out.println("not work");
            }
        } else {
            article.setThumbnail("default.jpg");

        }

        System.out.println(article.toString());
        articleRepository.add(article);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        articleRepository.delete(id);
        System.out.println("delete ok");
        return "redirect:/";
    }

    @GetMapping("/veiw/{id}")
    public String viewaArticle(Model model, @PathVariable Integer id) {
        Article article = articleRepository.getByID(id);
        model.addAttribute("article", article);
        return "view";
    }

    @GetMapping("/update/{id}")
    public String update(ModelMap modelMap, @PathVariable Integer id) {
        Article article = articleRepository.getByID(id);
        System.out.println(article);
        modelMap.addAttribute("article", article);
        return "update";
    }

    @PostMapping("/update")
    public String addUpdate(@ModelAttribute Article article, @RequestParam("thumbnailUpdate") MultipartFile file) {
        String currentImage = null;
        if (file != null && !Objects.requireNonNull(file.getOriginalFilename()).isEmpty()) {
            try {
                String fileName = UUID.randomUUID() + "." + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
                Files.copy(file.getInputStream(), Paths.get("src/main/java/com/example/demohomework/image/", fileName));
                article.setThumbnail(fileName);
                System.out.println(fileName);
                System.out.println("work ");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("not work");
            }
        } else {
            currentImage = articleRepository.getByID(article.getId()).getThumbnail();
            article.setThumbnail(currentImage);

        }
        articleRepository.update(article);

        System.out.println(article);
        return "redirect:/";
    }
}
