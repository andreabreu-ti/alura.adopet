package br.com.alura.adopet.dto;

import br.com.alura.adopet.model.Pet;
import br.com.alura.adopet.model.TipoPet;

public record PetDTO(Long id, String nome, Integer idade, TipoPet tipo, Boolean adotado, String imagem) {

	public PetDTO(Pet pet) {

		this(pet.getId(), pet.getNome(), pet.getIdade(), pet.getTipo(), pet.getAdotado(), pet.getImagem());
	}
}
