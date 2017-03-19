package by.vls.admin.domain.settings.rate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "agemargin_buildmach")
public class AgeMarginBuildmach {
	@Id
	private int id;
	@Column(name = "age")
	private int age;
	@Column(name = "margin_buildmach")
	private float marginBuildmach;

	public AgeMarginBuildmach() {
	}

	public AgeMarginBuildmach(int age, float marginBuildmach) {
		super();
		this.age = age;
		this.marginBuildmach = marginBuildmach;
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

	public float getMarginBuildmach() {
		return marginBuildmach;
	}

	public void setMarginBuildmach(float marginBuildmach) {
		this.marginBuildmach = marginBuildmach;
	}

	@Override
	public String toString() {
		return "AgeMarginBuildmach [id=" + id + ", age=" + age + ", marginBuildmach=" + marginBuildmach + "]";
	}

}
