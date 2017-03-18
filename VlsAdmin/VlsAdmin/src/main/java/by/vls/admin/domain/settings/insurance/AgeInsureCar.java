package by.vls.admin.domain.settings.insurance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ageinsure_car")
public class AgeInsureCar {
	@Id
	private int id;
	@Column(name = "age")
	private int age;
	@Column(name = "imargin_car")
	private float iMarginCar;
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
	public float getiMarginCar() {
		return iMarginCar;
	}
	public void setiMarginCar(float iMarginCar) {
		this.iMarginCar = iMarginCar;
	}
	@Override
	public String toString() {
		return "AgeInsureCar [id=" + id + ", age=" + age + ", iMarginCar=" + iMarginCar + "]";
	}

}
