package com.example.MyBookShopApp.data;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    private JdbcTemplate jdbcTemplate;
    private final Logger logger = Logger.getLogger(AuthorService.class);

    @Autowired
    public AuthorService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Author> getAuthorsData()
    {
        List<Author> authorsList = jdbcTemplate.query("SELECT * FROM authors", (ResultSet rs, int rowNum) -> {
            Author author = new Author();
            author.setFirstName(rs.getString("firstname"));
            author.setSecondName(rs.getString("secondname"));
            return author;
        });
        logger.info("Data loaded from database");
        return new ArrayList<>(authorsList);
    }
}
