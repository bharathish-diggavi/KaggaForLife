package in.diggavi.kagga.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "KAGGA_TABLE")
public class Kagga {

	@Id
	private long kagga_id;
	@Column(length = 99999)
	private String kagga_kn;
	@Column(length = 99999)
	private String kagga_latn;
	@Column(length = 99999)
	private String kagga_eng;

	public long getKagga_id() {
		return kagga_id;
	}

	public void setKagga_id(long kagga_id) {
		this.kagga_id = kagga_id;
	}

	public String getKagga_kn() {
		return kagga_kn;
	}

	public void setKagga_kn(String kagga_kn) {
		this.kagga_kn = kagga_kn;
	}

	public String getKagga_latn() {
		return kagga_latn;
	}

	public void setKagga_latn(String kagga_latn) {
		this.kagga_latn = kagga_latn;
	}

	public String getKagga_eng() {
		return kagga_eng;
	}

	public void setKagga_eng(String kagga_eng) {
		this.kagga_eng = kagga_eng;
	}

}
