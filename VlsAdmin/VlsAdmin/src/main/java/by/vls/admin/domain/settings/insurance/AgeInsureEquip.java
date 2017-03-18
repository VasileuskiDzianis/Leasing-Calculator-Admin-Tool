package by.vls.admin.domain.settings.insurance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ageinsure_equip")
public class AgeInsureEquip {
	@Id
	private int id;
	@Column(name = "age")
	private int age;
	@Column(name = "imargin_equip")
	private float iMarginEquip;
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
	public float getiMarginEquip() {
		return iMarginEquip;
	}
	public void setiMarginEquip(float iMarginEquip) {
		this.iMarginEquip = iMarginEquip;
	}
	@Override
	public String toString() {
		return "AgeInsureEquip [id=" + id + ", age=" + age + ", iMarginEquip=" + iMarginEquip + "]";
	}

}
