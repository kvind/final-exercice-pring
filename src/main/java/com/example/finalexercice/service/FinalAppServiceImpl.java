package com.example.finalexercice.service;

import com.example.finalexercice.dao.AppRoleRepository;
import com.example.finalexercice.dao.AppUserRepository;
import com.example.finalexercice.dao.ArticleRepository;
import com.example.finalexercice.dao.ContenuRepository;
import com.example.finalexercice.entities.AppRole;
import com.example.finalexercice.entities.AppUser;
import com.example.finalexercice.entities.Article;
import com.example.finalexercice.entities.Contenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class FinalAppServiceImpl implements FinalAppService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private AppRoleRepository appRoleRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ContenuRepository contenuRepository;


    @Override
    public AppUser saveUser(AppUser user) {
        String hashPW = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hashPW);
        return appUserRepository.save(user);
    }

    @Override
    public AppRole saveRole(AppRole role) {
        return appRoleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppRole role = appRoleRepository.findByRoleName(roleName);
        AppUser user = appUserRepository.findByUsername(username);
        user.getRoles().add(role);
    }

    @Override
    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Contenu saveContenu(Contenu contenu) {
        return contenuRepository.save(contenu);
    }
}
