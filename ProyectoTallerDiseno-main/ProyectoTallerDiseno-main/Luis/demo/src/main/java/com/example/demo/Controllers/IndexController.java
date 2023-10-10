package com.example.demo.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.Models.Entity.Usuario;
import com.example.demo.Models.Repositorio.UserRepository;

@Controller

public class IndexController {
    @Autowired
    private UserRepository Aux;
    @Autowired
    private UserRepository Aux2;

    @GetMapping("/login")

    public String login(Model model) {
        model.addAttribute("titulo", "INICIAR SESIÓN");

        return "login";
    }

    @GetMapping("/logout")

    public String logout() {
        return "login";
    }

    @GetMapping("/Index")

    public String Home(Model model) {
        model.addAttribute("titulo", "BIENVENIDO");

        return "Index";
    }

    @GetMapping("/list_users")

    public String Lista_Usuarios(Model model) {
        model.addAttribute("titulo", "LISTA DE USUARIOS");

        List<Usuario> listaUsurios = Aux.findAll();

        model.addAttribute("listUsers", listaUsurios);

        return "Usuarios";

    }

    @GetMapping("/proceso")

    public String procesoCon(Model model) {
        Usuario user = new Usuario();
        model.addAttribute("titulo", "CONFIRMACION DE USUARIO");
        model.addAttribute("user", user);
        return "proceso";
    }


  

}