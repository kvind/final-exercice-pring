package com.example.finalexercice;

import com.example.finalexercice.constants.Roles;
import com.example.finalexercice.entities.AppRole;
import com.example.finalexercice.entities.AppUser;
import com.example.finalexercice.entities.Article;
import com.example.finalexercice.entities.Contenu;
import com.example.finalexercice.service.FinalAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class FinalexerciceApplication implements CommandLineRunner {
    
    @Autowired
    private FinalAppService finalAppService;

    public static void main(String[] args) {
        SpringApplication.run(FinalexerciceApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder getBCPE() {
        return new BCryptPasswordEncoder();
    }
    
    @Override
    public void run(String... args) throws Exception {
        finalAppService.saveUser(new AppUser("admin", "1234", 1, null));
        finalAppService.saveUser(new AppUser("user", "1234", 1, null));
        finalAppService.saveRole(new AppRole(Roles.ADMIN.toString()));
        finalAppService.saveRole(new AppRole(Roles.EDITEUR.toString()));
        finalAppService.addRoleToUser("admin", Roles.ADMIN.toString());
        finalAppService.addRoleToUser("user", Roles.EDITEUR.toString());

        Article article = finalAppService.saveArticle(new Article("titre de l'article", "l'url de l'article"));
        finalAppService.saveContenu(new Contenu("titre du contenu de l'article", "date du contenu", "texte du contenu de l'article", "auteur du contenu", "url du contenu", article));

        Article article2 = finalAppService.saveArticle(new Article("Titre de l'article 2", "l'url de l'article 2"));
        finalAppService.saveContenu(new Contenu("titre du contenu de l'article 2", "date du contenu 2", "texte du contenu de l'article 2", "auteur du contenu 2", "url du contenu 2", article2));
    }
}
