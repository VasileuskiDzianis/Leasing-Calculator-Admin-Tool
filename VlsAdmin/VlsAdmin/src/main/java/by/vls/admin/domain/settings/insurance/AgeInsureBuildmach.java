package by.vls.admin.domain.settings.insurance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ageinsure_buildmach")
public class AgeInsureBuildmach {
	@Id
	private int id;
	@Column(name = "age")
	private int age;
	@Column(name = "imargin_buildmach")
	private float iMarginBuildmach;
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
	public float getiMarginBuildmach() {
		return iMarginBuildmach;
	}
	public void setiMarginBuildmach(float iMarginBuildmach) {
		this.iMarginBuildmach = iMarginBuildmach;
	}
	@Override
	public String toString() {
		return "AgeInsureBuildmach [id=" + id + ", age=" + age + ", iMarginBuildmach=" + iMarginBuildmach + "]";
	}

}
