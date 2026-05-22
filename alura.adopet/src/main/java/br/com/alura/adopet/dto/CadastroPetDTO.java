package br.com.alura.adopet.dto;

import br.com.alura.adopet.model.TipoPet;
import br.com.alura.adopet.model.TipoPorte;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastroPetDTO(@NotBlank String nome, @NotNull Integer idade, @NotNull TipoPet tipo,
		@NotNull TipoPorte porte) {

}
