package br.com.alura.adopet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.adopet.model.Adocao;

public interface AdocaoRepository extends JpaRepository<Adocao,Long>{

}
