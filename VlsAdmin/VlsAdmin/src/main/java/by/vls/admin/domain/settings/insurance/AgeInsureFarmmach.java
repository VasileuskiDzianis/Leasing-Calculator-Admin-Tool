package by.vls.admin.domain.settings.insurance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ageinsure_farmmach")
public class AgeInsureFarmmach {
	@Id
	private int id;
	@Column(name = "age")
	private int age;
	@Column(name = "imargin_farm")
	private float iMarginFarm;
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
	public float getiMarginFarm() {
		return iMarginFarm;
	}
	public void setiMarginFarm(float iMarginFarm) {
		this.iMarginFarm = iMarginFarm;
	}
	@Override
	public String toString() {
		return "AgeInsureFarmmach [id=" + id + ", age=" + age + ", iMarginFarm=" + iMarginFarm + "]";
	}

}
