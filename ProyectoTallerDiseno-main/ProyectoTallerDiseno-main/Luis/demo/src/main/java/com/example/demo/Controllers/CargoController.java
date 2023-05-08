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

import com.example.demo.Models.Entity.Cargo;
import com.example.demo.Models.Repositorio.CargoRepository;

@Controller
public class CargoController {
 
    
    @Autowired
    private CargoRepository RepCar;

    @GetMapping("/CargoListar")
    public String Listar(Model model){
        model.addAttribute("titulo", "Lista de Cargos");
        model.addAttribute("Cargos", RepCar.findAll());
        return "CargoList";
    }

    @GetMapping("/CargoEliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        if (id > 0) {
            RepCar.deleteById(id);
        }
        return "redirect:/CargoListar";
    }

    @GetMapping("/CargoForm/{id}")
    public String editar(@PathVariable(value = "id") Long id, Model model) {
        Cargo cargo = new Cargo();
        if (id > 0) {
            cargo = RepCar.getReferenceById(id);
            // System.out.println("nombre"+ cargo.getNombre_cargo());
        } else {
            return "redirect:/CargoListar";
        }
        model.addAttribute("titulo", "Editar Cargo");
        model.addAttribute("Cargos", cargo);
        model.addAttribute("boton", "editar Cargo");
        return "CargoFor";
    }


    @GetMapping("/CargoForm") // Para crear un nuevo registro de flor
    public String crear(Model model) {
        Cargo cargo = new Cargo();
        model.addAttribute("titulo", "FORMULARIO DE CARGOS");
        model.addAttribute("Cargos", cargo);
        model.addAttribute("boton", "Crear cargo");
        return "CargoFor";
    }

    @PostMapping("/CargoForm")
    public String guardar(@Valid Cargo cargo, BindingResult Resultado, SessionStatus status, Model model) {
        if (Resultado.hasErrors()) {
            model.addAttribute("titulo", "FORMULARIO DE CARGOS");
            model.addAttribute("Cargos", cargo);
            return "CargoFor";
        }
        RepCar.save(cargo);        
        status.setComplete();
        return "redirect:/CargoListar";
    }


}
