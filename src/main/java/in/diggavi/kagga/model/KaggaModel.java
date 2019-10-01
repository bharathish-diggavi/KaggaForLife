package in.diggavi.kagga.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class KaggaModel {

	private long id;
	private String kagga;
	private String kagga_meaning;
	@JsonIgnore
	transient String kagga_trans;
	
	public KaggaModel(long id, String kagga, String kagga_meaning, String kagga_trans) {
		super();
		this.id = id;
		this.kagga = kagga;
		this.kagga_meaning = kagga_meaning;
		this.kagga_trans = kagga_trans;
	}

	public KaggaModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getKagga() {
		return kagga;
	}
	public void setKagga(String kagga) {
		this.kagga = kagga;
	}
	public String getKagga_meaning() {
		return kagga_meaning;
	}
	public void setKagga_meaning(String kagga_meaning) {
		this.kagga_meaning = kagga_meaning;
	}

	public String getKagga_trans() {
		return kagga_trans;
	}

	public void setKagga_trans(String kagga_trans) {
		this.kagga_trans = kagga_trans;
	}
	

}
