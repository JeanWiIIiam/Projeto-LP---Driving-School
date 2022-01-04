package com.driving.school.service;

import java.util.List;

import com.driving.school.DTO.AlunoDTO;
import com.driving.school.DTO.TurmaDTO;

public interface ServiceTurma {
    List<TurmaDTO > list();
    
    Boolean add(TurmaDTO turma);

    Boolean edit(String id,TurmaDTO turma);

    Boolean delete(String id);

    int buscarID(String id);

}
