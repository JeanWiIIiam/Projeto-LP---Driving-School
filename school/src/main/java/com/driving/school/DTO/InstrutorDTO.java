package com.driving.school.DTO;
import lombok.Data;

@Data
public class InstrutorDTO{

	private String nome;
	private String cpf;
	private String rg;
	private String email;
	private String telefone;
	private String endereco;
	private String num;
	private String bairro;
	private String dataNascimento;
	private String primeiraHabilitacao;
	private String numCNH;
	private String catCNH;
	private String dataEmissaoCNH;
	private String valCNH;
	private String id;
	
	public InstrutorDTO() {
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
		this.primeiraHabilitacao = primeiraHabilitacao;
		this.numCNH = numCNH;
		this.catCNH = catCNH;
		this.dataEmissaoCNH = dataEmissaoCNH;
		this.valCNH = valCNH;
		this.id = id;
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
	public String getPrimeiraHabilitacao(){
		return primeiraHabilitacao;
	}
	public void setPrimeiraHabilitacao(String primeiraHabilitacao){
		this.primeiraHabilitacao = primeiraHabilitacao;
	}
	public String getNumCNH(){
		return numCNH;
	}
	public void setNumCNH(String numCNH){
		this.numCNH = numCNH;
	}
	public String getCatCNH(){
		return catCNH;
	}
	public void setCatCNH(String catCNH){
		this.catCNH = catCNH;
	}
	public String getDataEmissaoCNH(){
		return dataEmissaoCNH;
	}
	public void setDataEmissaoCNH(String dataEmissaoCNH){
		this.dataEmissaoCNH = dataEmissaoCNH;
	}
	public String getValCNH(){
		return valCNH;
	}
	public void setValCNH(String valCNH){
		this.valCNH = valCNH;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}