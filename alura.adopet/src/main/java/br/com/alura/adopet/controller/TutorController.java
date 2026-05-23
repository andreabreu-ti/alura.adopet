package br.com.alura.adopet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.adopet.dto.CadastroTutorDTO;
import br.com.alura.adopet.dto.TutorDTO;
import br.com.alura.adopet.service.TutorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tutor")
public class TutorController {

	 @Autowired
	    private TutorService service;

	    @GetMapping
	    public ResponseEntity<List<TutorDTO>> buscarTodos(){
	        List<TutorDTO> tutores = service.listarTodos();
	        return ResponseEntity.ok(tutores);
	    }

	    @PostMapping
	    @Transactional
	    public void cadastrar(@RequestBody @Valid CadastroTutorDTO dados){

	        this.service.cadastrar(dados);
	    }
}
