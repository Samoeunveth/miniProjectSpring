package com.example.demohomework.provider;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class ArticleProvider {

    public String paginate(@Param("page") int page, @Param("limit") int limit) {
        int offset = limit * (page - 1);
        System.out.println("Page : " + page + " , Limit : " + limit);
        System.out.println("Offset : " + offset);
        return new SQL() {{
            SELECT("tba.*,tbc.name");
            FROM("TB_ARTICLE AS tba");
            INNER_JOIN("TB_CATEGORY AS tbc ON tba.c_id = tbc.id LIMIT #{limit} OFFSET " + offset);
        }}.toString();
    }
}
