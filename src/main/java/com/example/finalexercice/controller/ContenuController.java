package com.example.finalexercice.controller;

import com.example.finalexercice.dao.ArticleRepository;
import com.example.finalexercice.dao.ContenuRepository;
import com.example.finalexercice.entities.Article;
import com.example.finalexercice.entities.Contenu;
import com.example.finalexercice.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contenu")
public class ContenuController {

    @Autowired
    ContenuRepository contenuRepository;
    @Autowired
    ArticleRepository articleRepository;

    @GetMapping
    public List<Contenu> getAllContenu() {
        return contenuRepository.findAll();
    }

    @PostMapping
    public Contenu saveContenu(@RequestBody Contenu contenu, @RequestParam(name = "articleId", required = true) Long articleId) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new ResourceNotFoundException("article", "id", String.valueOf(articleId)));
        contenu.setArticle(article);
        return contenuRepository.save(contenu);
    }

    @GetMapping("id")
    public Contenu getContenu(@PathVariable(value = "id") Long contenuId) {
        return contenuRepository
                .findById(contenuId)
                .orElseThrow(() -> new ResourceNotFoundException("article", "id", String.valueOf(contenuId)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContenu(@PathVariable(value = "id") Long contenuId) {
        Contenu contenu = contenuRepository
                .findById(contenuId)
                .orElseThrow(() -> new ResourceNotFoundException("article", "id", String.valueOf(contenuId)));

        contenuRepository.delete(contenu);

        return ResponseEntity.ok().build();
    }

    @GetMapping("article/{id}")
    public Contenu getContenuByArticleId(@PathVariable(value = "id") Long articleId) {
        Article article = articleRepository.findById(articleId).orElseThrow(() -> new ResourceNotFoundException("article", "id", String.valueOf(articleId)));

        return contenuRepository.findByArticle(article);
    }

}
