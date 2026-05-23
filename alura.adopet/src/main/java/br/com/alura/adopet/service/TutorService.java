package br.com.alura.adopet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.adopet.dto.CadastroTutorDTO;
import br.com.alura.adopet.dto.TutorDTO;
import br.com.alura.adopet.model.Tutor;
import br.com.alura.adopet.repository.TutorRepository;

@Service
public class TutorService {

	 @Autowired
	    private TutorRepository repository;

	    public List<TutorDTO> listarTodos(){
	        return repository.findAll().stream().map(TutorDTO::new).toList();
	    }
	    public void cadastrar(CadastroTutorDTO dados){
	        repository.save(new Tutor(dados));
	    }
}
