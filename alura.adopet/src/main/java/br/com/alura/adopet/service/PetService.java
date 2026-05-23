package br.com.alura.adopet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.alura.adopet.dto.CadastroPetDTO;
import br.com.alura.adopet.dto.PetDTO;
import br.com.alura.adopet.model.Pet;
import br.com.alura.adopet.repository.PetRepository;

@Service
public class PetService {

	@Autowired
	private PetRepository repository;

	@Autowired
	private ImageStorageService imagemService;

	public List<PetDTO> listarTodos() {
		return repository.findAll().stream().map(PetDTO::new).toList();
	}

	public void cadastrar(CadastroPetDTO dto, MultipartFile imagem) {

		String nomeImagem = imagemService.upload(imagem);

		repository.save(new Pet(dto, nomeImagem));
	}
}
