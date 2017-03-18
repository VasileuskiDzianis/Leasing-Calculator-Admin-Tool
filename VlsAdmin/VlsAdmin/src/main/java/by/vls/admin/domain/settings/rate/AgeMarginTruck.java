package by.vls.admin.domain.settings.rate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "agemargin_truck")
public class AgeMarginTruck {
	@Id
	private int id;
	@Column(name = "age")
	private int age;
	@Column(name = "margin_truck")
	private float marginTruck;
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
	public float getMarginTruck() {
		return marginTruck;
	}
	public void setMarginTruck(float marginTruck) {
		this.marginTruck = marginTruck;
	}
	@Override
	public String toString() {
		return "AgeMarginTruck [id=" + id + ", age=" + age + ", marginTruck=" + marginTruck + "]";
	}
	
	

	
}
