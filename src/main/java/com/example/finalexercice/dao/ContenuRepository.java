package com.example.finalexercice.dao;

import com.example.finalexercice.entities.Article;
import com.example.finalexercice.entities.Contenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContenuRepository extends JpaRepository<Contenu, Long> {
    public Contenu findByArticle(Article article);
}
