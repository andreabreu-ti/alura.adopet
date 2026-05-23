package br.com.alura.adopet.dto;

import br.com.alura.adopet.model.Tutor;

public record TutorDTO(Long id, String nome, String email) {

    public TutorDTO(Tutor tutor){
        this(tutor.getId(), tutor.getNome(), tutor.getEmail());
    }
}

