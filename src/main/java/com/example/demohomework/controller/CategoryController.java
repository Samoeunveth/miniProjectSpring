package com.example.demohomework.controller;

import com.example.demohomework.repository.articleRepository.model.Category;
import com.example.demohomework.repository.categoryRepo.ICategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class CategoryController {
    @Autowired
    ICategoryRepo categoryRepo;
    @GetMapping("/category")
    public String getCategory(Model model){
        model.addAttribute("categories", categoryRepo.showAll());
        return "cat_home";
    }
    @GetMapping("/category/add")
    public String getAdd(ModelMap modelMap){
        Category cat = new Category();
        cat.setId(categoryRepo.getLastId()+1);
        modelMap.addAttribute("index",cat.getId());
        return "cat_add";
    }
    @PostMapping("/category/addsubmit")
    public String getAddSumit(@ModelAttribute Category category){
        categoryRepo.add(category);
        System.out.println(category.toString());
        return "redirect:/category";
    }
    @GetMapping("/category/veiw/{id}")
    public String viewaCategory(Model model,@PathVariable Integer id){
        Category category = categoryRepo.getByID(id);
        model.addAttribute("category",category);
        return "cat_view";
    }
    @GetMapping("/category/delete/{id}")
    public String delete(@PathVariable Integer id){
        categoryRepo.delete(id);
        System.out.println("delete ok");
        return "redirect:/category";
    }
    @GetMapping("/category/update/{id}")
    public String update(ModelMap modelMap , @PathVariable Integer id ){
        modelMap.addAttribute("category",categoryRepo.getByID(id));
        return "cat_update";
    }
    @PostMapping("/category/update")
    public String addUpdate(@ModelAttribute Category category) {
        categoryRepo.update(category);
        System.out.println(category);
        return "redirect:/category";
    }
}
