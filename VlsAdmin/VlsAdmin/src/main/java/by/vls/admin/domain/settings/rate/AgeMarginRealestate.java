package by.vls.admin.domain.settings.rate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "agemargin_realestate")
public class AgeMarginRealestate {
	@Id
	private int id;
	@Column(name = "age")
	private int age;
	@Column(name = "margin_realest")
	private float marginRealest;
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
	public float getMarginRealest() {
		return marginRealest;
	}
	public void setMarginRealest(float marginRealest) {
		this.marginRealest = marginRealest;
	}
	@Override
	public String toString() {
		return "AgeMarginRealestate [id=" + id + ", age=" + age + ", marginRealest=" + marginRealest + "]";
	}
	
	
}
