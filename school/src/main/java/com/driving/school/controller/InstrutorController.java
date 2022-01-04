package com.driving.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.driving.school.DTO.InstrutorDTO;
import com.driving.school.service.ServiceInstrutor;
import org.springframework.beans.factory.annotation.Autowired;

@Controller 
public class InstrutorController {
	
	@Autowired
    private ServiceInstrutor service;

	@GetMapping("/cadInstrutor")
	public String instrutor(Model model) {
		 model.addAttribute("instrutor", new InstrutorDTO());
		return "cadInstrutor";
	}
	
	@PostMapping("/instrutorAdd")
	public String greetingSubmit(@ModelAttribute InstrutorDTO instrutor, Model model) {
		service.add(instrutor);
		model.addAttribute("instrutor", instrutor);
		//Faltando o tratamento de erro do firebase
		return "redirect:cadInstrutor";
	}	 
	
	@GetMapping(value = "/listarInstrutores")
    public String list(Model model){
        model.addAttribute("instrutorList", service.list());
        return "listaInstrutor";
    }

	@GetMapping("/verInstrutor")
	public String verInstrutor(@RequestParam(value = "id") String id, Model model) {
    	int dP= service.buscarID(id);
    	InstrutorDTO instrutor = service.list().get(dP);
    	model.addAttribute("instrutor", instrutor);
        	return "viewInstrutor";
	}

	@GetMapping(value = "/deletarInstrutor")
    public String delete(@RequestParam(value = "id") String id){
        service.delete(id);
        return "redirect:listarInstrutores";
    }
 	
	@GetMapping(value = "/excluirInstrutor")
    public String delete(@RequestParam(value = "id") String id, Model model){
        int dp = service.buscarID(id); 
        InstrutorDTO instrutor = service.list().get(dp);
        model.addAttribute("instrutor", instrutor);
        return "deletarInstrutor";
    }

	@GetMapping("/alterarInstrutor")
	public String alterarInstrutor(@RequestParam(value = "id") String id, Model model) {
    	int dP= service.buscarID(id);
    	InstrutorDTO instrutor = service.list().get(dP);
    	model.addAttribute("instrutor", instrutor);
        	return "editInstrutor";
	}
    
    @PostMapping("/altInstrutor")
	public String editSubmit(@RequestParam(value = "id") String id, @ModelAttribute InstrutorDTO instrutor ) {
    	service.edit(id, instrutor);
		  return  "redirect:/listarInstrutores";
    }
}
