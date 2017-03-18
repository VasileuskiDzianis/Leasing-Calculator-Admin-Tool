package by.vls.admin.domain.settings.rate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "agemargin_car")
public class AgeMarginCar {
	@Id
	private int id;
	@Column(name = "age")
	private int age;
	@Column(name = "margin_car")
	private float marginCar;
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
	public float getMarginCar() {
		return marginCar;
	}
	public void setMarginCar(float marginCar) {
		this.marginCar = marginCar;
	}
	@Override
	public String toString() {
		return "AgeMarginCar [id=" + id + ", age=" + age + ", marginCar=" + marginCar + "]";
	}
	
	
	
}
