package jpa.basico.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String sigla;
	
	@OneToMany(
			mappedBy = "estado",
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<Aluno> alunos = new ArrayList<>();

	/***********************************************/

	public Estado() {
	}

	public Estado(String nome, String sigla) {
		this.nome = nome;
		this.sigla = sigla;
	}

	public Estado(int id, String nome, String sigla) {
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
