package by.vls.admin.domain.settings.rate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "agemargin_farmmach")
public class AgeMarginFarmmach {
	@Id
	private int id;
	@Column(name = "age")
	private int age;
	@Column(name = "margin_farm")
	private float marginFarmmach;

	public AgeMarginFarmmach() {
	}

	public AgeMarginFarmmach(int age, float marginFarmmach) {
		super();
		this.age = age;
		this.marginFarmmach = marginFarmmach;
	}

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

	public float getMarginFarmmach() {
		return marginFarmmach;
	}

	public void setMarginfarmmach(float marginFarmmach) {
		this.marginFarmmach = marginFarmmach;
	}

	@Override
	public String toString() {
		return "AgeMarginfarmmach [id=" + id + ", age=" + age + ", marginFarmmach=" + marginFarmmach + "]";
	}

}
