package br.com.alura.adopet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.adopet.dto.AdocaoDTO;
import br.com.alura.adopet.dto.AprovarAdocaoDTO;
import br.com.alura.adopet.dto.ReprovarAdocaoDTO;
import br.com.alura.adopet.dto.SolicitacaoDeAdocaoDTO;
import br.com.alura.adopet.model.Adocao;
import br.com.alura.adopet.model.Pet;
import br.com.alura.adopet.model.StatusAdocao;
import br.com.alura.adopet.model.Tutor;
import br.com.alura.adopet.repository.AdocaoRepository;
import br.com.alura.adopet.repository.PetRepository;
import br.com.alura.adopet.repository.TutorRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class AdocaoService {

	@Autowired
	private PetRepository petRepository;

	@Autowired
	private TutorRepository tutorRepository;

	@Autowired
	private AdocaoRepository adocaoRepository;

	public List<AdocaoDTO> listarTodos() {

		return adocaoRepository.findAll().stream().map(AdocaoDTO::new).toList();
	}

	public AdocaoDTO listar(Long id) {

		return adocaoRepository.findById(id).stream().findFirst().map(AdocaoDTO::new).orElse(null);
	}

	public void solicitar(SolicitacaoDeAdocaoDTO dto) {
		Pet pet = petRepository.getReferenceById(dto.idPet());
		Tutor tutor = tutorRepository.getReferenceById(dto.idTutor());

		//Pet já adotado
		
		if (pet.getAdotado()) {
			
			throw new IllegalStateException("Pet já adotado!");
		}
		
		//Pet com solicitação de adoção em andamento
		Boolean petAdocaoEmAndamento =  adocaoRepository.existsByPetIdAndStatus(dto.idPet(), StatusAdocao.AGUARDANDO_AVALIACAO);
		
		if (petAdocaoEmAndamento) {
			
			throw new UnsupportedOperationException("Pet com adoção em andamento!");
		}
		
		//Tutor com 2 adoções aprovadas
		Integer tutorAdocoes = adocaoRepository.countByTutorIdAndStatus(dto.idTutor(), StatusAdocao.APROVADO);
		
		if (tutorAdocoes == 2) {
			
			throw new IllegalStateException("Tutor com o máximo de adoções!");
		}
		
		
		
		
		adocaoRepository.save(new Adocao(tutor, pet, dto.motivo()));
	}

	public void aprovar(AprovarAdocaoDTO dto) {
		
		Adocao adocao = adocaoRepository.getReferenceById(dto.idAdocao());
		adocao.marcarComoAprovada();
		adocao.getPet().marcarComoAdotado();
	}

	public void reprovar(ReprovarAdocaoDTO dto) {
		Adocao adocao = adocaoRepository.getReferenceById(dto.idAdocao());
		adocao.marcarComoReprovada(dto.justificativa());
	}
}
