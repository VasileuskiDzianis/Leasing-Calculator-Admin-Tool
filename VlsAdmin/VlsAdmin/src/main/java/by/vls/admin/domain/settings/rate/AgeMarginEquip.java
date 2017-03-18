package by.vls.admin.domain.settings.rate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "agemargin_equip")
public class AgeMarginEquip {
	@Id
	private int id;
	@Column(name = "age")
	private int age;
	@Column(name = "margin_equip")
	private float marginEquip;

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

	public float getMarginEquip() {
		return marginEquip;
	}

	public void setMarginEquip(float marginEquip) {
		this.marginEquip = marginEquip;
	}

	@Override
	public String toString() {
		return "AgeMarginEquip [id=" + id + ", age=" + age + ", marginEquip=" + marginEquip + "]";
	}

}
