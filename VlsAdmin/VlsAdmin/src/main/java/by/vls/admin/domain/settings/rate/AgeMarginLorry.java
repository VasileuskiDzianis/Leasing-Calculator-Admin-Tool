package by.vls.admin.domain.settings.rate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "agemargin_lorry")
public class AgeMarginLorry {
	@Id
	private int id;
	@Column(name = "age")
	private int age;
	@Column(name = "margin_lorry")
	private float marginLorry;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getMarginLorry() {
		return marginLorry;
	}
	public void setMarginLorry(float marginLorry) {
		this.marginLorry = marginLorry;
	}
	@Override
	public String toString() {
		return "AgeMarginLorry [id=" + id + ", age=" + age + ", marginLorry=" + marginLorry + "]";
	}
	
	
	
}
