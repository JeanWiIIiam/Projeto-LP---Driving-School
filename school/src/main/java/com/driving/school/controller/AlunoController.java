package com.driving.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.driving.school.DTO.AlunoDTO;
import com.driving.school.service.ServiceAluno;

@Controller 
public class AlunoController {

	@Autowired 
    private ServiceAluno service;
	@GetMapping("/cadAluno")
	public String aluno(Model model) {
		model.addAttribute("aluno", new AlunoDTO());
		return "cadAluno";
	}
	
	@PostMapping("/alunoAdd")
	public String greetingSubmit(@ModelAttribute AlunoDTO aluno, Model model) {
		service.add(aluno);
		model.addAttribute("aluno", aluno);
		//Faltando o tratamento de erro do firebase
		return "redirect:cadAluno";
	}

	@GetMapping("/verAluno")
	public String verAluno(@RequestParam(value = "id") String id, Model model) {
    	int dP= service.buscarID(id);
    	AlunoDTO aluno = service.list().get(dP);
    	model.addAttribute("aluno", aluno);
        	return "viewAluno";
	}


	@GetMapping(value = "/listarAlunos")
    public String list(Model model){
        model.addAttribute("alunoList", service.list());
        return "listaAluno";
    }

	@GetMapping(value = "/deletarAluno")
    public String delete(@RequestParam(value = "id") String id){
        service.delete(id);
        return "redirect:listarAlunos";
    }
 	
	@GetMapping(value = "/excluirAluno")
    public String delete(@RequestParam(value = "id") String id, Model model){
        int dp = service.buscarID(id); 
        AlunoDTO aluno = service.list().get(dp);
        model.addAttribute("aluno", aluno);
        return "deletarAluno";
    }

	@GetMapping("/alterarAluno")
	public String alterarAluno(@RequestParam(value = "id") String id, Model model) {
    	int dP= service.buscarID(id);
    	AlunoDTO aluno = service.list().get(dP);
    	model.addAttribute("aluno", aluno);
        	return "editAluno";
	}
    
    @PostMapping("/altAluno")
	public String editSubmit(@RequestParam(value = "id") String id, @ModelAttribute AlunoDTO aluno ) {
    	service.edit(id, aluno);
		  return  "redirect:/listarAlunos";
    }
}
