package by.vls.admin.domain.settings.insurance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ageinsure_realestate")
public class AgeInsureRealestate {
	@Id
	private int id;
	@Column(name = "age")
	private int age;
	@Column(name = "imargin_realest")
	private float iMarginRealest;
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
	public float getiMarginRealest() {
		return iMarginRealest;
	}
	public void setiMarginRealest(float iMarginRealest) {
		this.iMarginRealest = iMarginRealest;
	}
	@Override
	public String toString() {
		return "AgeInsureRealestate [id=" + id + ", age=" + age + ", iMarginRealest=" + iMarginRealest + "]";
	}

}
