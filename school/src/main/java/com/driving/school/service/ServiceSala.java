package com.driving.school.service;

import java.util.List;
import com.driving.school.DTO.SalaDTO;

public interface ServiceSala{
	
	List<SalaDTO> list();
    
    Boolean add(SalaDTO sala);

    Boolean edit(String id,SalaDTO sala);

    Boolean delete(String id);

    int buscarID(String id);
    
}
