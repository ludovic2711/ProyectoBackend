package com.example.demo.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.example.demo.Models.Entity.Categoria;
import com.example.demo.Models.Repositorio.CategoriaRepository;

@Controller
public class CategoriaController {
    
@Autowired
private CategoriaRepository RepCat;

@GetMapping("/CateListar")
public String Listar(Model model){
    model.addAttribute("titulo", "Lista de Categorias");
    model.addAttribute("Categoria", RepCat.findAll());
    return "CateList";
}

@GetMapping("/CateEliminar/{id}")
public String eliminar(@PathVariable Long id) {
    if (id > 0) {
        RepCat.deleteById(id);
    }
    return "redirect:/CateListar";
}

@GetMapping("/CateForm/{id}")
public String editar(@PathVariable(value = "id") Long id, Model model) {
    Categoria cate = new Categoria();
    if (id > 0) {
        cate = RepCat.findById(id).get();
        // System.out.println("nombre"+ cate.getNombre_categoria());
    } else {
        return "redirect:/CateListar";
    }
    model.addAttribute("titulo", "Editar Categoria");
    model.addAttribute("Categoria", cate);
    model.addAttribute("boton", "editar Categoria");
    return "CateFor";
}


@GetMapping("/CateForm") // Para crear un nuevo registro de flor
public String crear(Model model) {
    Categoria cate = new Categoria();
    model.addAttribute("titulo", "FORMULARIO DE CATEGORIAS");
    model.addAttribute("Categoria", cate);
    model.addAttribute("boton", "Crear categoria");
    return "CateFor";
}

@PostMapping("/CateForm")
public String guardar(@Valid Categoria cate, BindingResult Resultado, SessionStatus status, Model model) {
    if (Resultado.hasErrors()) {
        model.addAttribute("titulo", "FORMULARIO DE CATEGORIAS");
        model.addAttribute("Categoria", cate);
        return "CateFor";
    }
    RepCat.save(cate);        
    status.setComplete();
    return "redirect:/CateListar";
}



}
