package com.driving.school.DTO;
import lombok.Data;

@Data
public class SalaDTO{
	
	private String num;
	private String capacidade;
	private String id;

	public SalaDTO() {
		super();
		this.num = num;
		this.capacidade = capacidade;
		this.id = id;
	}

	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(String capacidade) {
		this.capacidade = capacidade;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}