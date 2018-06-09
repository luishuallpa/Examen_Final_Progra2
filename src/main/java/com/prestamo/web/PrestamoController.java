package com.prestamo.web;

import java.util.List;
import java.util.Map;
import java.util.Random;

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
import com.prestamo.clases.Method;
@Controller
public class PrestamoController {
	@Autowired
	PrestamoRepository prestamoRepository;
	/*
	@GetMapping("/prestamo/listar")
	public String list(Map<String, Object> model) {
		List<Prestamo> prestamo = prestamoRepository.findAll();
		model.put("prestamo", prestamo);
		return "listaPrestamo";
	}*/

	@GetMapping("/prestamo/nuevo")
	public String initCreationForm(Model model) {
		model.addAttribute("prestamo", new Prestamo());
		return "nuevoPrestamo";
	}

	@PostMapping("/prestamo/nuevo")
	public String submitForm(@Valid Prestamo prestamo, BindingResult bindingResult) {

		if (bindingResult.hasFieldErrors()) {
			return "nuevoPrestamo";
		}
		Method method = new Method();
		prestamo.setImpRentaPagar(method.impuestoPagar(prestamo.getSueldo(), prestamo.getPlanilla()));
		prestamoRepository.save(prestamo);
		return "resultado";
		// return "nuevoPrestamo";
	}
	@GetMapping("/prestamo/buscar")
	public String buscarInit(Model model) {
		model.addAttribute("prestamo", new Prestamo());
		return "buscarPrestamo";
	}
	@PostMapping("/prestamo/buscar")
	public String resultadoBuscado(Map<String, Object> model, Prestamo prestamo) {
	    String dni = prestamo.getDni();
		prestamo = prestamoRepository.findBydni(dni);
		model.put("prestamo", prestamo);
		return "resultadoBuscado";
	}
	@GetMapping("/prestamo/listar")
	public String generador(Map<String, Object> model) {
		List<Prestamo> prestamo = prestamoRepository.findAll();
		model.put("prestamo", prestamo);
		return "interfazGeneradorPrestamo";
	}
	@PostMapping("/prestamo/listar")
	public String correoGenerado(Map<String, Object> model) {
		Method clases = new Method();
		List<Prestamo> prestamo = prestamoRepository.findAll();
		for(Prestamo i: prestamo) {
			Random r = new Random();
			if(r.nextBoolean()) {
				if(i.getSueldo() <= 3000) {
					String destinatario =  i.getCorreo(); //A quien le quieres escribir.
					String asunto = "Correo de prueba enviado desde Java";
					String cuerpo = "Hola señor@ "+ i.getNombre() + " "+ i.getApellido() +". Ha recibido el prestamo tipo 1";
					clases.mail(destinatario, asunto, cuerpo);
				}
				if(i.getSueldo() >= 3000 && i.getSueldo() <= 5000) {
					String destinatario =  i.getCorreo(); //A quien le quieres escribir.
					String asunto = "Correo de prueba enviado desde Java";
					String cuerpo = "Hola señor@ "+ i.getNombre() + " "+ i.getApellido() +". Ha recibido el prestamo tipo 2";
					clases.mail(destinatario, asunto, cuerpo);
				}
				if(i.getSueldo() > 5000) {
					String destinatario =  i.getCorreo(); //A quien le quieres escribir.
					String asunto = "Correo de prueba enviado desde Java";
					String cuerpo = "Hola señor "+ i.getNombre() + " "+ i.getApellido() +". Ha recibido el prestamo tipo 3";
					clases.mail(destinatario, asunto, cuerpo);
				}
			}
		}
		model.put("prestamo", prestamo);
		return "interfazGeneradorPrestamo";
	}
}
