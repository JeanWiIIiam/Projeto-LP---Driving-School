package com.driving.school.DTO;
import lombok.Data;

@Data
public class TurmaDTO{
	private String nome;
	private String categoria;
	private String turno;
	private String horario;
	private String sala;
	private String instrutor;
	private String id;

	public TurmaDTO() {
		super();
		this.nome = nome;
		this.categoria = categoria;
		this.turno = turno;
		this.horario = horario;
		this.sala = sala;
		this.instrutor = instrutor;
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getSala() {
		return sala;
	}
	public void setSala(String sala) {
		this.sala = sala;
	}
	public String getInstrutor() {
		return instrutor;
	}
	public void setInstrutor(String instrutor) {
		this.instrutor = instrutor;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}