//package com.example.demohomework.service;
//
//import com.example.demohomework.repository.articleRepository.IArticleRepository;
//import com.example.demohomework.repository.articleRepository.model.Article;
//import com.example.demohomework.service.articleService.IArticleService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
////@Service
//public class ArticleServiceImp implements IArticleService {
//    @Autowired
//    IArticleRepository articleRepository;
//    @Override
//    public void add(Article article) {
//        articleRepository.add(article);
//    }
//    @Override
//    public void update(Article article) {
//        articleRepository.update(article);
//    }
//
//    @Override
//    public List<Article> showAll() {
//        return articleRepository.showAll();
//    }
//
//    @Override
//    public void delete(int id) {
//        articleRepository.delete(id);
//    }
//
//    @Override
//    public Article getByID(int id) {
//        return articleRepository.getByID(id);
//    }
//
//    @Override
//    public int getLastId() {
//        return articleRepository.getLastId();
//    }
//}
