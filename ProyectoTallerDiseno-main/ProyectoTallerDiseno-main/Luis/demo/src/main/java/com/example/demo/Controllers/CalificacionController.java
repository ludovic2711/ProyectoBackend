package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Models.Entity.Calificacion;
import com.example.demo.Models.Entity.Usuario;
import com.example.demo.Models.Repositorio.CalificacionRepository;
import com.example.demo.Models.Repositorio.CategoriaRepository;
import com.example.demo.Models.Repositorio.UserRepository;

@Controller
public class CalificacionController {

    @Autowired
    private CalificacionRepository RepCali;
    // @Autowired
    // private UserRepository RepUser;

    @Autowired
    private UserRepository Aux;
    @Autowired
    private UserRepository Aux2;

    // VARIABLES GLOBALES
    String correoGlo = "";
    Usuario UserGlo = new Usuario();

    // FORMULARIO
    @PostMapping("/calificacion")

    public String userConf(Usuario user, Model model) {
        // System.out.println("BUENAS");
        // System.out.println(user.getEmail());

        String correo = user.getEmail();
        correoGlo = correo;
        Usuario User = Aux.findByEmail(correo);
        UserGlo = User;

boolean  validacion = BCrypt.checkpw(user.getPassword(), UserGlo.getPassword());

System.out.println(validacion);

        if (UserGlo != null) {

            if (UserGlo.getEmail().equals(correoGlo) && validacion == true) {

                Calificacion Calificacion = new Calificacion();
                model.addAttribute("Calificador", UserGlo);
                model.addAttribute("persona", Aux2.findAll());
                model.addAttribute("califi", Calificacion);
                return "califiFor";
            }
        }

        // model.addAttribute("titulo", "CONFIRMACION DE USUARIO");
        // model.addAttribute("user", user);
        return "redirect:/proceso";
    }

    @PostMapping("/procesoCalificacion")

    public String procesoCali(Calificacion cal, Model model) {
        System.out.println(cal.getUsuario_quecali());
        if (cal.getUsuario_quecali().getId_user() == cal.getId_empleado_acali().longValue()) {
            Calificacion Calificacion = new Calificacion();
            model.addAttribute("Calificador", UserGlo);
            model.addAttribute("persona", Aux2.findAll());
            model.addAttribute("califi", Calificacion);
            model.addAttribute("error", "No es posible calificarse a uno mismo!");
            return "califiFor";
        }

        RepCali.save(cal);

        return "/Index";
    }


    @GetMapping("/misCalificaciones")

    public String misCali(Model model){
        return "hola";
    }
}
