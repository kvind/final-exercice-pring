package com.example.finalexercice.service;

import com.example.finalexercice.entities.AppRole;
import com.example.finalexercice.entities.AppUser;
import com.example.finalexercice.entities.Article;
import com.example.finalexercice.entities.Contenu;

public interface FinalAppService {
    public AppUser saveUser(AppUser user);

    public AppRole saveRole(AppRole role);

    public void addRoleToUser(String username, String roleName);

    public Article saveArticle(Article article);

    public Contenu saveContenu(Contenu contenu);
}
