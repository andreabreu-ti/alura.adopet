package br.com.alura.adopet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.adopet.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Long>{

}
