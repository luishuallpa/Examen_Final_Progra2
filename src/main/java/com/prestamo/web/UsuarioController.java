package com.prestamo.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.prestamo.model.Usuario;
import com.prestamo.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@GetMapping("/prestamo/LogIn")
	public String userLogIn(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "LogIn";
	}
	@PostMapping("/prestamo/LogIn")
	public String generadorInterface(Map<String, Object> model,Usuario usuario){
		String username = usuario.getUsername();
		String password = usuario.getPassword();
		usuario = usuarioRepository.findByUsername(username);
		if(usuario != null) {
			usuario = usuarioRepository.findByPassword(password);
			if(usuario != null) {
				return "redirect:/prestamo/listar";
			}
		}
		return "LogIn";
	}
}
