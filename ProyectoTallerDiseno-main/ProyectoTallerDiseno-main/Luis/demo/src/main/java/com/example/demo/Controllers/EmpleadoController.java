package com.example.demo.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

// import com.example.demo.Models.Entity.Empleado;
import com.example.demo.Models.Entity.Usuario;
import com.example.demo.Models.Repositorio.CargoRepository;
// import com.example.demo.Models.Repositorio.EmpleadoRepository;
import com.example.demo.Models.Repositorio.UserRepository;

@Controller
public class EmpleadoController {

    @Autowired
    private UserRepository RepEmp;
    @Autowired
    private CargoRepository RepCargo;
    // @Autowired
    // private UserRepository Aux; 
    

    //LISTAR
    @GetMapping("/EmpleListar")
    public String Listar(Model model){
        model.addAttribute("titulo", "Lista de Empleados");
        model.addAttribute("Empleado", RepEmp.findAll());
        return "EmpleList";
    }

    //ELIMINAR
    @GetMapping("/EmpleEliminar/{id}")
public String eliminar(@PathVariable Long id) {
    if (id > 0) {
        RepEmp.deleteById(id);
    }
    return "redirect:/EmpleListar";
}

//EDITAR
@GetMapping("/EmpleForm/{id}")
public String editar(@PathVariable(value = "id") Long id, Model model) {
    Usuario emp = new Usuario();
    if (id > 0) {
        emp = RepEmp.findById(id).get();
        // System.out.println("nombre"+ cate.getNombre_categoria());
    } else {
        return "redirect:/EmpleListar";
    }
    model.addAttribute("titulo", "Editar Empleado");
    model.addAttribute("Empleado", emp);
    model.addAttribute("boton", "editar Categoria");
    model.addAttribute("Cargos", RepCargo.findAll());
    return "EmpleFor";
}
    

//FORMULARIO
@GetMapping("/EmpleForm") 
public String crear(Model model) {
    Usuario emp = new Usuario();
    model.addAttribute("titulo", "FORMULARIO DE EMPLEADOS");
    model.addAttribute("Empleado", emp);
    model.addAttribute("Cargos", RepCargo.findAll()); //AÑADIMOS LO CARGOS QUE SE TIENEN GUARDADOS EN LA BD 
    model.addAttribute("boton", "Añadir Empleado");
    return "EmpleFor";
}


@PostMapping("/EmpleForm")
public String guardar(@Valid Usuario emp, BindingResult Resultado, SessionStatus status, Model model) {
    // System.out.println("/n Buenas noches ");
    if (Resultado.hasErrors()) {
        model.addAttribute("titulo", "FORMULARIO DE EMPLEADOS");
        model.addAttribute("Empleado", emp);
        model.addAttribute("Cargos", RepCargo.findAll());
        return "EmpleFor";
    }
    RepEmp.save(emp);        
    status.setComplete();
    return "redirect:/EmpleListar";
}

@GetMapping("/formRegistro")
    
public String Registro(Model model)
{
    Usuario emp = new Usuario();
    model.addAttribute("titulo", "FORMULARIO DE REGISTRO");
    model.addAttribute("usuario", emp);
    model.addAttribute("Cargos", RepCargo.findAll());

    return "formRegistro";
}

@PostMapping("/proceso_registro")
    
public String Proceso_Registro(Usuario usuario,Model model)
{
    model.addAttribute("titulo", "REGISTRO EXITOSO");

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    String encodedPassword = encoder.encode(usuario.getPassword());
    usuario.setPassword(encodedPassword);

    RepEmp.save(usuario);

    return "Registro_Exitoso";
}

}
