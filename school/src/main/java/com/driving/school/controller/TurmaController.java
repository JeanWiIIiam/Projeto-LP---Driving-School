package com.driving.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

import com.driving.school.DTO.AlunoDTO;
import com.driving.school.DTO.TurmaDTO;
import com.driving.school.service.ListAluno;
import com.driving.school.service.ServiceAluno;
import com.driving.school.service.ServiceInstrutor;
import com.driving.school.service.ServiceSala;
import com.driving.school.service.ServiceTurma;
import org.springframework.beans.factory.annotation.Autowired;

@Controller 
public class TurmaController {
	
	@Autowired
    private ServiceTurma service;

	@Autowired
    private ServiceSala serviceSala;

	@Autowired
    private ServiceInstrutor serviceInstrutor;

	@Autowired
    private ServiceAluno serviceAluno;

	@GetMapping("/cadTurma")
	public String Turma(Model model){
		model.addAttribute("salaList", serviceSala.list());
		model.addAttribute("instrutorList", serviceInstrutor.list());
		model.addAttribute("turma", new TurmaDTO());
		return "cadTurma";
	}
	
	@PostMapping("/turmaAdd")
	public String greetingSubmit(@ModelAttribute TurmaDTO turma, Model model) {
		service.add(turma);
		model.addAttribute("turma", turma);
		//Faltando o tratamento de erro do firebase
		return "redirect:cadTurma";
	}	 

	@GetMapping(value = "/listarTurmas")
    public String list(Model model){
        model.addAttribute("turmaList", service.list());
        return "listaTurma";
    }




	@GetMapping(value = "/deletarTurma")
    public String delete(@RequestParam(value = "id") String id){
        service.delete(id);
        return "redirect:listarTurmas";
    }
 	
	@GetMapping(value = "/excluirTurma")
    public String delete(@RequestParam(value = "id") String id, Model model){
        int dp = service.buscarID(id); 
        TurmaDTO turma = service.list().get(dp);
        model.addAttribute("turma", turma);
        return "deletarTurma";
    }

	@GetMapping("/alterarTurma")
	public String alterarPaciente(@RequestParam(value = "id") String id, Model model) {
    	int dP= service.buscarID(id);
    	TurmaDTO turma = service.list().get(dP);
		model.addAttribute("salaList", serviceSala.list());
		model.addAttribute("instrutorList", serviceInstrutor.list());
    	model.addAttribute("turma", turma);
        	return "editTurma";
	}
    
    @PostMapping("/altTurma")
	public String editSubmit(@RequestParam(value = "id") String id, @ModelAttribute TurmaDTO turma ) {
    	service.edit(id, turma);
		  return  "redirect:/listarTurmas";
    }

	@GetMapping("/verTurma")
    public String verTurma(@RequestParam(value = "id") String id, Model model){
        model.addAttribute("verTurma", listAlunoT(id));
		model.addAttribute("Turma", id);
        return "viewAlunoTurma";
    }

	@GetMapping("/adicionarAluno")
    public String adicionarAluno(@RequestParam(value = "id") String id, Model model){
		int verif = service.buscarID(id);
		String turmaCnh = service.list().get(verif).getCategoria();
		model.addAttribute("verAlunosLivres", listAluno(turmaCnh));
        return "adicionarAlunoTurma";
    }


	@GetMapping("/adicionarAlunoTurma")
    public String adicionarAlunoTurma(@RequestParam(value = "id") String id, Model model){
		int aluno;
		aluno = serviceAluno.buscarID("WeoxeVOPBSv47EzbGxc7");
		serviceAluno.list().get(aluno).setTurma("cxDN4ypIVTSY3ZqDdDsb");
		addAluno("turma", aluno);

        return "redirect:listarTurmas";
    }


	public void addAluno(String turma, int aluno){
		serviceAluno.list().get(aluno).setTurma("cxDN4ypIVTSY3ZqDdDsb");
	}


    public List<AlunoDTO> listAluno(String turmaCnh){
        List<AlunoDTO> turma = new ArrayList<>();

		int i;
		String verificacao;
		for(i = 0; i < serviceAluno.list().size(); i++){

			verificacao = serviceAluno.list().get(i).getTurma();

			if(verificacao == null){
				if(serviceAluno.list().get(i).getCnh().contains(turmaCnh)){
					turma.add(serviceAluno.list().get(i));
				}
			
			}
		}
		return turma;
    }



	public List<AlunoDTO> listAlunoT(String turmaId){
        List<AlunoDTO> turma = new ArrayList<>();

		int i;
		String verificacao;
		for(i = 0; i < serviceAluno.list().size(); i++){

			verificacao = serviceAluno.list().get(i).getTurma();

			if(verificacao != null){
				if(serviceAluno.list().get(i).getTurma().contains(turmaId)){
					turma.add(serviceAluno.list().get(i));
				}
			
			}
		}
		return turma;
    }
}

