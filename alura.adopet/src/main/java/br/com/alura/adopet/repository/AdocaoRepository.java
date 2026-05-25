package br.com.alura.adopet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.adopet.model.Adocao;
import br.com.alura.adopet.model.StatusAdocao;
import jakarta.validation.constraints.NotNull;

public interface AdocaoRepository extends JpaRepository<Adocao,Long>{
	
	Integer countByTutorId(Long idTutor);

	Integer countByTutorIdAndStatus(@NotNull Long idTutor, StatusAdocao aprovado);

	Boolean existsByPetIdAndStatus(@NotNull Long idPet, StatusAdocao aguardandoAvaliacao);

}
