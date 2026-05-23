package br.com.alura.adopet.dto;

import br.com.alura.adopet.model.Adocao;
import br.com.alura.adopet.model.StatusAdocao;

public record AdocaoDTO(Long id, Long tutor, Long pet, String motivo, StatusAdocao status, String justificativa) {
	public AdocaoDTO(Adocao adocao) {
		this(adocao.getId(), adocao.getTutor().getId(), adocao.getPet().getId(), adocao.getMotivo(), adocao.getStatus(),
				adocao.getJustificativa());
	}
}
