package com.driving.school.DTO;
import lombok.Data;

@Data
public class AlunoDTO {

	private String turma;
	private String nome;
	private String cpf;
	private String email;
	private String rg;
	private String telefone;
	private String endereco;
	private String num;
	private String bairro;
	private String dataNascimento;
	private String cnh;
	private String senha;
	private String id;
	
	public AlunoDTO() {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.rg = rg;
		this.telefone = telefone;
		this.endereco = endereco;
		this.num = num;
		this.bairro = bairro;
		this.dataNascimento = dataNascimento;
		this.cnh = cnh;
		this.senha = cpf;
		this.id = id;
		this.turma = turma;
	}

	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getCnh() {
		return cnh;
	}
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
