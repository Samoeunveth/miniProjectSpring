//package com.example.demohomework.repository;
//
//import com.example.demohomework.repository.articleRepository.IArticleRepository;
//import com.example.demohomework.repository.articleRepository.model.Article;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
////@Repository
//public class ArticleRepositoryImp{
//    List<Article> articlesList=new ArrayList<>();
//    ArticleRepositoryImp(){
//        for(int i =1;i<=75;i++){
//            articlesList.add(new Article(i, "title","dec",1,"author", "default.jpg"));
//        }
//    }
////    @Override
////    public void add(Article article) {
////        articlesList.add(article);
////    }
////
////    @Override
////    public int getLastId() {
////        int lastid;
////        int size =articlesList.size();
////        if(size>0){
////            lastid = articlesList.get(articlesList.size()-1).getId() +1;
////        }else {
////            lastid = 1;
////        }
////        return lastid;
////    }
////    @Override
////    public void update(Article article) {
////        for (int i = 0; i < articlesList.size(); i++) {
////            if (articlesList.get(i).getId() == article.getId()) {
////                articlesList.set(i, article);
////            }
////        }
////    }
//    public List<Article> showAll() {
//        return articlesList;
//    }
//
////    @Override
////    public void delete(int id) {
////        for (int i = 0; i < articlesList.size(); i++) {
////            if (articlesList.get(i).getId() == id) {
////                articlesList.remove(i);
////            }
////        }
////    }
////    @Override
////    public Article getByID(int id) {
////        for (int i = 0; i < articlesList.size(); i++) {
////            if (articlesList.get(i).getId() == id) {
////                return articlesList.get(i);
////            }
////        }
////        return null;
////    }
//}
