package br.com.alura.adopet.model;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.adopet.dto.CadastroTutorDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tutores")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
public class Tutor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String nome;

	@NotBlank
	private String email;

	@OneToMany(mappedBy = "tutor")
	private List<Adocao> adocoes = new ArrayList<>();

	public Tutor(CadastroTutorDTO dados) {
		this.nome = dados.nome();
		this.email = dados.email();
	}
	
	public Tutor() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Adocao> getAdocoes() {
		return adocoes;
	}

	public void setAdocoes(List<Adocao> adocoes) {
		this.adocoes = adocoes;
	}

}
