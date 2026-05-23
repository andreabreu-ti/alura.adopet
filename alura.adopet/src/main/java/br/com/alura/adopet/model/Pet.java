package br.com.alura.adopet.model;

import br.com.alura.adopet.dto.CadastroPetDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "pets")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Integer idade;

	@Enumerated(EnumType.STRING)
	private TipoPet tipo;

	private Boolean adotado;

	private String imagem;

	@OneToOne(mappedBy = "pet", fetch = FetchType.LAZY)
	private Adocao adocao;

	public Pet(CadastroPetDTO dados, String nomeDaImagem) {
		this.nome = dados.nome();
		this.idade = dados.idade();
		this.tipo = dados.tipo();
		this.imagem = nomeDaImagem;
		this.adotado = false;
	}
	
	public Pet() {
		
	}

	public void marcarComoAdotado() {
		this.adotado = true;
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

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public TipoPet getTipo() {
		return tipo;
	}

	public void setTipo(TipoPet tipo) {
		this.tipo = tipo;
	}

	public Boolean getAdotado() {
		return adotado;
	}

	public void setAdotado(Boolean adotado) {
		this.adotado = adotado;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Adocao getAdocao() {
		return adocao;
	}

	public void setAdocao(Adocao adocao) {
		this.adocao = adocao;
	}

}
