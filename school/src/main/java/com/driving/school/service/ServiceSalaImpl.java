package com.driving.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.driving.school.DTO.SalaDTO;
import com.driving.school.firebase.FirebaseInitializer;
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
public class ServiceSalaImpl implements ServiceSala{
	@Autowired
	private	FirebaseInitializer firebase;
	
	@Override
    public List<SalaDTO> list() {
        List<SalaDTO> response = new ArrayList<>();
        SalaDTO sala;
        ApiFuture<QuerySnapshot> querySnapshotApiFuture = getCollection().get();
        try {
            for (DocumentSnapshot doc : querySnapshotApiFuture.get().getDocuments()) {
                sala = doc.toObject(SalaDTO.class);
                sala.setId(doc.getId());
                response.add(sala);
            }
            return response;
        } catch (Exception e) {
            return null;
        }
    }
	
	@Override
    public Boolean add(SalaDTO sala) {
    	
        Map<String, Object> docData = getDocData(sala);											
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document().create(docData);  

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
	public Boolean edit(String id, SalaDTO sala) {
		Map<String, Object> docData = getDocData(sala);
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
        return firebase.getFirestore().collection("sala"); //nome da coleção
    }
    
    private Map<String, Object> getDocData(SalaDTO sala) {
    	Map<String, Object> docData = new HashMap<>();
    	docData.put("num", sala.getNum());
    	docData.put("capacidade", sala.getCapacidade());
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