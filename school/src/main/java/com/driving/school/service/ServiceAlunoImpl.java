package com.driving.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.driving.school.DTO.AlunoDTO;
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
public class ServiceAlunoImpl implements ServiceAluno{
	@Autowired
	private	FirebaseInitializer firebase;
	
	@Override
    public List<AlunoDTO> list() {
        List<AlunoDTO> response = new ArrayList<>();
        AlunoDTO aluno;
        ApiFuture<QuerySnapshot> querySnapshotApiFuture = getCollection().get();
        try {
            for (DocumentSnapshot doc : querySnapshotApiFuture.get().getDocuments()) {
                aluno = doc.toObject(AlunoDTO.class);
                aluno.setId(doc.getId());
                response.add(aluno);
            }
            return response;
        } catch (Exception e) {
            return null;
        }
    }
	
	@Override
    public Boolean add(AlunoDTO aluno) {
    	
        Map<String, Object> docData = getDocData(aluno);											
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
	public Boolean edit(String id, AlunoDTO aluno) {
		Map<String, Object> docData = getDocData(aluno);
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
        return firebase.getFirestore().collection("aluno"); //nome da coleção
    }
    
    private Map<String, Object> getDocData(AlunoDTO aluno) {
    	Map<String, Object> docData = new HashMap<>();
    	docData.put("nome", aluno.getNome());
    	docData.put("cpf", aluno.getCpf());
    	docData.put("email", aluno.getEmail());
    	docData.put("rg", aluno.getRg());
    	docData.put("telefone", aluno.getTelefone());
    	docData.put("endereco", aluno.getEndereco());
    	docData.put("num", aluno.getNum());
    	docData.put("bairro", aluno.getBairro());
    	docData.put("dataNascimento", aluno.getDataNascimento());
    	docData.put("cnh", aluno.getCnh());
    	docData.put("senha", aluno.getCpf());
        docData.put("turma", aluno.getTurma());
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
	