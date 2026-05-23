package br.com.alura.adopet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.adopet.model.Tutor;

public interface TutorRepository extends JpaRepository<Tutor, Long> {

}
