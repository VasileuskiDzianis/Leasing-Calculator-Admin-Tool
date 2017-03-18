package by.vls.admin.domain.settings.rate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "objtypemargin")
public class ObjTypeMargin {

	@Id
	private int id;
	private String objType;
	private float objTypeMargin;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getObjType() {
		return objType;
	}

	public void setObjType(String objType) {
		this.objType = objType;
	}

	public float getObjTypeMargin() {
		return objTypeMargin;
	}

	public void setObjTypeMargin(float objTypeMargin) {
		this.objTypeMargin = objTypeMargin;
	}

	@Override
	public String toString() {
		return "ObjTypeMargin [id=" + id + ", objType=" + objType + ", objTypeMargin=" + objTypeMargin + "]";
	}

}
