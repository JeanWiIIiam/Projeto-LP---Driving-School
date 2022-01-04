package com.driving.school.service;

import com.driving.school.DTO.AlunoDTO;
import com.driving.school.DTO.TurmaDTO;
import com.driving.school.firebase.FirebaseInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;

@Service
public class ServiceTurmaImpl implements ServiceTurma{
    
    @Autowired
	private	FirebaseInitializer firebase;

    @Override
    public List<TurmaDTO> list() {
        List<TurmaDTO> response = new ArrayList<>();
        TurmaDTO turma;

        ApiFuture<QuerySnapshot> querySnapshotApiFuture = getCollection().get();
        try {
            for (DocumentSnapshot doc : querySnapshotApiFuture.get().getDocuments()) {
                turma = doc.toObject(TurmaDTO.class);
                turma.setId(doc.getId());
                response.add(turma);
            }
            return response;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Boolean add(TurmaDTO turma) {
    	
        Map<String, Object> docData = getDocData(turma);											// Vai criar um mapa para armazenar os dados do paciente
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document().create(docData);  // Vai adicionar um novo documento (de forma assíncrona) na coleção do getCollection com id

        try {
            if(null != writeResultApiFuture.get()){
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    @Override
    public Boolean edit(String id, TurmaDTO turma) {
        Map<String, Object> docData = getDocData(turma);
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document(id).set(docData);
        try {
            if(null != writeResultApiFuture.get()){
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    @Override
    public Boolean delete(String id) {
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document(id).delete();
        try {
            if(null != writeResultApiFuture.get()){
                return Boolean.TRUE;
            }

        return Boolean.FALSE;
            } catch (Exception e) {
                return Boolean.FALSE;
            }
     }

     private CollectionReference getCollection() {
        return firebase.getFirestore().collection("turma"); //nome da coleção
    }

    private Map<String, Object> getDocData(TurmaDTO turma) {
    	Map<String, Object> docData = new HashMap<>();
        docData.put("nome", turma.getNome());
    	docData.put("categoria", turma.getCategoria());
    	docData.put("turno", turma.getTurno());
    	docData.put("horario", turma.getHorario());
    	docData.put("sala", turma.getSala());
    	docData.put("instrutor", turma.getInstrutor());
    	return docData;
    }

    @Override
    public int buscarID(String id) {
    	boolean verificar;
    	int achou=0;
    	if(list().size() != 0) {
	    	for(int i=0; i<list().size(); i++) {
	    		verificar = list().get(i).getId().contains(id);
	    		if(verificar==true) {
	    			achou=i;
	    		}
	    	}
    	}
    	return achou;
    }

}
