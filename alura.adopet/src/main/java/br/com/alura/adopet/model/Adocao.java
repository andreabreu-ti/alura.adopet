package br.com.alura.adopet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "adocoes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Adocao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	private Tutor tutor;

	@OneToOne(fetch = FetchType.LAZY)
	private Pet pet;

	private String motivo;

	@Enumerated(EnumType.STRING)
	private StatusAdocao status;

	private String justificativa;

	public Adocao(Tutor tutor, Pet pet, String motivo) {
		this.tutor = tutor;
		this.pet = pet;
		this.motivo = motivo;
		this.status = StatusAdocao.AGUARDANDO_AVALIACAO;
	}
	
	public Adocao() {
		
	}

	public void marcarComoAprovada() {

		this.status = StatusAdocao.APROVADO;
	}

	public void marcarComoReprovada(String justificativa) {
		this.status = StatusAdocao.REPROVADO;
		this.justificativa = justificativa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public StatusAdocao getStatus() {
		return status;
	}

	public void setStatus(StatusAdocao status) {
		this.status = status;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

}
