package br.com.devmedia.dto;

public class ClienteDTO {

	private int id;
	private String nome;
	private String email;
	private String cep;
	private String cpf;

	public ClienteDTO() {

	}

	public ClienteDTO(int id, String nome, String email, String cep, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cep = cep;
		this.cpf = cpf;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		String new_cep = "";
		new_cep = cep.substring(0,5) + "-" + cep.substring(5, 8);
		this.cep = new_cep;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
