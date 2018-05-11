package com.prestamo.web;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.prestamo.model.Prestamo;
import com.prestamo.repository.PrestamoRepository;

@Controller
public class PrestamoController {
	@Autowired PrestamoRepository prestamoRepository;
	
	@GetMapping("/prestamo/listar")
	public String list(Map<String, Object> model) {
		List<Prestamo> prestamo =prestamoRepository.findAll();
		model.put("prestamo", prestamo);
		return "listaPrestamo";
	}
	
	@GetMapping("/prestamo/nuevo")
	public String initCreationForm(Model model) {
		model.addAttribute("prestamo", new Prestamo());
		return "nuevoPrestamo";
	}
	@PostMapping("/prestamo/nuevo")
	public String submitForm(@Valid Prestamo prestamo, BindingResult bindingResult) {
		if(bindingResult.hasFieldErrors()) {
			return "nuevoPrestamo";
		}
		prestamo.setResultado(1000);
		prestamoRepository.save(prestamo);
		return "resultado";
		//return "nuevoPrestamo";
	}
	
	//Buscar
	//@GetMapping("/prestamo/buscar")
	//public String buscar(@PathVariable("prestamoId") int prestamo, Model model){
		
	//	return "";
	//}
}