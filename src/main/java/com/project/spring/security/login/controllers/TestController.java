package com.project.spring.security.login.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {
    
    @GetMapping("/all")
    public String allAccess(){
        return "Conteúdo público - Sem autenticação";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public String userAccess(){
        return "Página de acesso ao usuário";
    }

    @GetMapping("/mod")
    @PreAuthorize("hasRole(ROLE_MODERATOR) or hasRole('ROLE_ADMIN')")
    public String moderatorAccess(){
        return "Página de acesso de moderador";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole(ROLE_ADMIN)")
    public String adminAcesso(){
        return "Conteúdo de acesso de administrador";
    }

}
