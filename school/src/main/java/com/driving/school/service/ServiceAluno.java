package com.driving.school.service;

import java.util.List;
import com.driving.school.DTO.AlunoDTO;

public interface ServiceAluno{
	
	List<AlunoDTO> list();
    
    Boolean add(AlunoDTO aluno);

    Boolean edit(String id,AlunoDTO aluno);

    Boolean delete(String id);

    int buscarID(String id);
        
}