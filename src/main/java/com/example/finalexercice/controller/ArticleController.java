package com.example.finalexercice.controller;

import com.example.finalexercice.dao.ArticleRepository;
import com.example.finalexercice.dao.ContenuRepository;
import com.example.finalexercice.entities.Article;
import com.example.finalexercice.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    ContenuRepository contenuRepository;

    @GetMapping
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @GetMapping("{id}")
    public Article getArticle(@PathVariable(name = "id") Long articleId) {
        return articleRepository
                .findById(articleId)
                .orElseThrow(() -> new ResourceNotFoundException("article", "id", String.valueOf(articleId)));
    }

    @PostMapping
    public Article saveArticle(@Valid @RequestBody Article article) {
        return articleRepository.save(article);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable(value = "id") Long articleId) {
        Article article = articleRepository
                .findById(articleId)
                .orElseThrow(() -> new ResourceNotFoundException("article", "id", String.valueOf(articleId)));

        articleRepository.delete(article);

        return ResponseEntity.ok().build();
    }
}
