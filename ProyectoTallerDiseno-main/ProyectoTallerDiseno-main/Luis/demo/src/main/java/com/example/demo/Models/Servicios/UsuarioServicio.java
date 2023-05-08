package com.example.demo.Models.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.example.demo.Models.Entity.Usuario;
import com.example.demo.Models.Repositorio.UserRepository;

public class UsuarioServicio implements UserDetailsService
{
    @Autowired
    private UserRepository Aux;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
    {
        Usuario usuario = Aux.findByEmail(email);

        if(usuario == null)
        {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        return new DetalleUsuario(usuario);
    }
    
}
