package by.vls.admin.domain.settings.insurance;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "insuretypebaserate")
public class InsureTypeBaseRate {
	@Id
	private int id;
	private String objType;
	private float insureBaseRate;

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
	public float getInsureBaseRate() {
		return insureBaseRate;
	}
	public void setInsureBaseRate(float insureBaseRate) {
		this.insureBaseRate = insureBaseRate;
	}
	@Override
	public String toString() {
		return "InsureTypeBaseRate [id=" + id + ", objType=" + objType + ", insureBaseRate=" + insureBaseRate + "]";
	}

}
