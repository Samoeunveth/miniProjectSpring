package com.example.demohomework.repository.categoryRepo;

import com.example.demohomework.repository.articleRepository.model.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryRepo {
    @Select("SELECT * FROM tb_category")
    @Results({
            @Result(property = "id",column ="id"),
            @Result(property = "name",column = "name")
    })
    List<Category> showAll();
    @Select("SELECT MAX(id) from tb_category")
    int getLastId();
    @Insert("INSERT INTO tb_category (name) values(#{name})")
    void add(Category category);
    @Select("SELECT * from tb_category WHERE id=#{id}")
    Category getByID(int id);
    @Delete("DELETE FROM tb_category WHERE id=#{id}")
    void delete(Integer id);
    @Update("UPDATE tb_category SET name = #{name} WHERE id = #{id}")
    void update(Category category);
}
