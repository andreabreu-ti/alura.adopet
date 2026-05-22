package br.com.alura.adopet.dto;

import jakarta.validation.constraints.NotBlank;

public record CadastroTutorDTO(
		  @NotBlank
	        String nome,

	        @NotBlank
	        String email
		) {

}
