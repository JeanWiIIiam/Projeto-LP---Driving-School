package com.driving.school.service;

import java.util.List;
import com.driving.school.DTO.InstrutorDTO;

public interface ServiceInstrutor {
    List<InstrutorDTO > list();
    
    Boolean add(InstrutorDTO instrutor);

    Boolean edit(String id,InstrutorDTO instrutor);

    Boolean delete(String id);

    int buscarID(String id);
}
