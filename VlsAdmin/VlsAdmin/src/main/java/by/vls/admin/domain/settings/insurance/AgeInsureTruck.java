package by.vls.admin.domain.settings.insurance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ageinsure_truck")
public class AgeInsureTruck {
	@Id
	private int id;
	@Column(name = "age")
	private int age;
	@Column(name = "imargin_truck")
	private float iMarginTruck;

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

	public float getiMarginTruck() {
		return iMarginTruck;
	}

	public void setiMarginTruck(float iMarginTruck) {
		this.iMarginTruck = iMarginTruck;
	}

	@Override
	public String toString() {
		return "AgeInsureTruck [id=" + id + ", age=" + age + ", iMarginTruck=" + iMarginTruck + "]";
	}
}
