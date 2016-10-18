package br.cesed.si.tap.sboot.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.cesed.si.tap.sboot.domain.User;
import br.cesed.si.tap.sboot.repository.UserRepository;

@Service
@Validated
public class UserService {

    @Autowired
    private UserRepository repository;

    public User getById(String id){
    	return repository.findOne(id);
    }
    
	public List<User> listAllUsers(){
		return repository.findAll();
	}
		
	public User deleteById(String id){

        User existing = repository.findOne(id);

        if(existing != null)
        	repository.delete(existing);
        
        return existing;
	}
	
    @Transactional
    public User save(@NotNull User usuario) {
    	
        User existing = repository.findByName(usuario.getName());

        if(existing == null)
        	existing = repository.save(usuario);
        
        return existing;
    }

	public UserRepository getRepository() {
		return repository;
	}
}
