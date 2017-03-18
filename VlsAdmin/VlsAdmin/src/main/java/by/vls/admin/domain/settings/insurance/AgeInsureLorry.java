package by.vls.admin.domain.settings.insurance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ageinsure_lorry")
public class AgeInsureLorry {
	@Id
	private int id;
	@Column(name = "age")
	private int age;
	@Column(name = "imargin_lorry")
	private float iMarginLorry;
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
	public float getiMarginLorry() {
		return iMarginLorry;
	}
	public void setiMarginLorry(float iMarginLorry) {
		this.iMarginLorry = iMarginLorry;
	}
	@Override
	public String toString() {
		return "AgeInsureLorry [id=" + id + ", age=" + age + ", iMarginLorry=" + iMarginLorry + "]";
	}
	

}
