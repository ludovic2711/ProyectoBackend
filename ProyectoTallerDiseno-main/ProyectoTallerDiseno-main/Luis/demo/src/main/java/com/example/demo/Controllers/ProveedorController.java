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

import com.example.demo.Models.Entity.Proveedor;
import com.example.demo.Models.Repositorio.ProveedorRepository;

@Controller
public class ProveedorController {

    @Autowired
    ProveedorRepository RepPro;

    @GetMapping("/ProveedorListar")
    public String Listar(Model model){
        model.addAttribute("titulo", "Lista de Proveedores");
        model.addAttribute("Proveedores", RepPro.findAll());
        return "ProveedorList";
    }    

    @GetMapping("/ProveedorEliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        if (id > 0) {
            RepPro.deleteById(id);
        }
        return "redirect:/ProveedorListar";
    }

    @GetMapping("/ProveedorForm") // Para crear un nuevo registro de flor
    public String crear(Model model) {
        Proveedor Prov = new Proveedor();
        model.addAttribute("titulo", "FORMULARIO DE Proveedores");
        model.addAttribute("Proveedores", Prov);
        // model.addAttribute("boton", "Crear Proveedor");
        return "ProveedorFor";
    }

    @PostMapping("/ProveedorForm")
    public String guardar(@Valid Proveedor Prov, BindingResult Resultado, SessionStatus status, Model model) {
        if (Resultado.hasErrors()) {
            model.addAttribute("titulo", "FORMULARIO DE Proveedores");
            model.addAttribute("Proveedores", Prov);
            return "ProveedorFor";
        }
        RepPro.save(Prov);        
        status.setComplete();
        return "redirect:/ProveedorListar";
    }


    @GetMapping("/ProveedorForm/{id}")
    public String editar(@PathVariable(value = "id") Long id, Model model) {
        Proveedor Prov = new Proveedor();
        if (id > 0) {
            Prov = RepPro.findById(id).get();
            // System.out.println("nombre"+ cargo.getNombre_cargo());
        } else {
            return "redirect:/ProveedorListar";
        }
        model.addAttribute("titulo", "Editar Proveedor");
        model.addAttribute("Proveedores", Prov);
        return "ProveedorFor";
    }
}
