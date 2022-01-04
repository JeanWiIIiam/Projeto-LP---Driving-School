package com.driving.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.driving.school.DTO.SalaDTO;
import com.driving.school.service.ServiceSala;
import org.springframework.beans.factory.annotation.Autowired;

@Controller 
public class SalaController {
	
	@Autowired
    private ServiceSala service;

	@GetMapping("/cadSala")
	public String Sala(Model model) {
		 model.addAttribute("sala", new SalaDTO());
		return "cadSala";
	}
	
	@PostMapping("/salaAdd")
	public String greetingSubmit(@ModelAttribute SalaDTO sala, Model model) {
		service.add(sala);
		model.addAttribute("sala", sala);
		//Faltando o tratamento de erro do firebase
		return "redirect:cadSala";
	}	 

	@GetMapping(value = "/listarSalas")
    public String list(Model model){
        model.addAttribute("salaList", service.list());
        return "listaSala";
    }

	@GetMapping(value = "/deletarSala")
    public String delete(@RequestParam(value = "id") String id){
        service.delete(id);
        return "redirect:listarSalas";
    }
 	
	@GetMapping(value = "/excluirSala")
    public String delete(@RequestParam(value = "id") String id, Model model){
        int dp = service.buscarID(id); 
        SalaDTO sala = service.list().get(dp);
        model.addAttribute("sala", sala);
        return "deletarSala";
    }

	@GetMapping("/alterarSala")
	public String alterarPaciente(@RequestParam(value = "id") String id, Model model) {
    	int dP= service.buscarID(id);
    	SalaDTO sala = service.list().get(dP);
    	model.addAttribute("sala", sala);
        	return "editSala";
	}
    
    @PostMapping("/altSala")
	public String editSubmit(@RequestParam(value = "id") String id, @ModelAttribute SalaDTO sala ) {
    	service.edit(id, sala);
		  return  "redirect:/listarSalas";
    }
}
