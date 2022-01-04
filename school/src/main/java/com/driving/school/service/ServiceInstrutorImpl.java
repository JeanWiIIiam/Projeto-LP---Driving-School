package com.driving.school.service;

import com.driving.school.DTO.InstrutorDTO;
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
public class ServiceInstrutorImpl implements ServiceInstrutor{
    
    @Autowired
	private	FirebaseInitializer firebase;
    
    @Override
    public List<InstrutorDTO> list() {
        List<InstrutorDTO> response = new ArrayList<>();
        InstrutorDTO instrutor;

        ApiFuture<QuerySnapshot> querySnapshotApiFuture = getCollection().get();
        try {
            for (DocumentSnapshot doc : querySnapshotApiFuture.get().getDocuments()) {
                instrutor = doc.toObject(InstrutorDTO.class);
                instrutor.setId(doc.getId());
                response.add(instrutor);
            }
            return response;
        } catch (Exception e) {
    return null;
        }
    }

    @Override
    public Boolean add(InstrutorDTO instrutor) {
    	
        Map<String, Object> docData = getDocData(instrutor);											// Vai criar um mapa para armazenar os dados do paciente
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
    public Boolean edit(String id, InstrutorDTO instrutor) {
        Map<String, Object> docData = getDocData(instrutor);
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
        return firebase.getFirestore().collection("instrutor"); //nome da coleção
    }

    private Map<String, Object> getDocData(InstrutorDTO instrutor) {
    	Map<String, Object> docData = new HashMap<>();
    	docData.put("nome", instrutor.getNome());
    	docData.put("cpf", instrutor.getCpf());
    	docData.put("email", instrutor.getEmail());
    	docData.put("rg", instrutor.getRg());
    	docData.put("telefone", instrutor.getTelefone());
    	docData.put("endereco", instrutor.getEndereco());
    	docData.put("num", instrutor.getNum());
    	docData.put("bairro", instrutor.getBairro());
    	docData.put("dataNascimento", instrutor.getDataNascimento());
    	docData.put("primeiraHabilitacao", instrutor.getPrimeiraHabilitacao());
        docData.put("numCNH", instrutor.getNumCNH());
        docData.put("catCNH", instrutor.getCatCNH());
        docData.put("dataEmissaoCNH", instrutor.getDataEmissaoCNH());
        docData.put("valCNH", instrutor.getValCNH());
        docData.put("senha", instrutor.getCpf());
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
