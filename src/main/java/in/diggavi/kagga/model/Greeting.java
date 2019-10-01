package in.diggavi.kagga.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GREETING")
public class Greeting {
	@Id
	@Column(length = 99999)
	private String name;

	public Greeting(String name) {
		super();
		this.name = name;
	}

	public Greeting() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
