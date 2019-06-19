package com.example.demohomework.repository.articleRepository;

import com.example.demohomework.provider.ArticleProvider;
import com.example.demohomework.repository.articleRepository.model.Article;
import com.example.demohomework.repository.articleRepository.model.Category;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.List;
@Repository
public interface IArticleRepository {
    @Insert("INSERT INTO tb_article (c_id,title,auther,description,thumbnail) values(#{category.id},#{title},#{auther}, #{description}, #{thumbnail})")
//    @Insert("INSERT INTO tb_article(c_id,title, auther, description, thumbnail) values (#{c_id}, #{title}, #{auther}, #{description}, #{thumbnail})")
    void add(Article article);
    @Update("UPDATE tb_article SET c_id=#{category.id},title=#{title},auther=#{auther},description=#{description},thumbnail=#{thumbnail} where id=#{id}")
    void update(Article article);
    @Select("SELECT atr.id,cat.name,atr.title,atr.auther,atr.description,atr.thumbnail FROM tb_article atr  INNER JOIN tb_category cat on atr.c_id=cat.id")
    @Results({
//            @Result(property = "category.id",column = "c_id"),
            @Result(property = "category.name",column = "name")
    })
    List<Article> showAll();
    @Delete("DELETE FROM tb_article WHERE id=#{id}")
    void delete(int id);
    @Select("SELECT atr.id,atr.c_id,cat.name,atr.title,atr.auther,atr.description,atr.thumbnail FROM tb_article atr  INNER JOIN tb_category cat on atr.c_id=cat.id where atr.id = #{id}")
    @Results({
            @Result(property = "category.id",column = "c_id"),
            @Result(property = "category.name",column = "name")
    })
    Article getByID(int id);
    @Select("SELECT MAX(id) FROM tb_article")
    int getLastId();
    @Select("SELECT atr.id,cat.name,atr.title,atr.auther,atr.description,atr.thumbnail FROM tb_article atr  INNER JOIN tb_category cat on atr.c_id=cat.id where atr.title ilike '%' || #{title} || '%'")
    @Results({
            @Result(property = "category.id",column = "c_id"),
            @Result(property = "category.name",column = "name")
    })
    List<Article> findAllSearch();
    @Select("SELECT name from tb_category")
    List<Category> getfillter();
    @Select("SELECT atr.id,cat.name,atr.title,atr.auther,atr.description,atr.thumbnail FROM tb_article atr  INNER JOIN tb_category cat on atr.c_id=cat.id where cat.name=#{filter}")
    @Results({
            @Result(property = "category.id",column = "c_id"),
            @Result(property = "category.name",column = "name")
    })
    List<Article> fillter();

    @SelectProvider(method = "paginate", type = ArticleProvider.class)
    @Results({
            @Result(property = "category.name", column = "name"),
            @Result(property = "category.id", column = "category_id")
    })
    List<Article> paginate(@Param("page") int page,@Param("limit") int limit);

    @Select("SELECT COUNT(*) FROM tb_article")
    Integer countArticle();
}
