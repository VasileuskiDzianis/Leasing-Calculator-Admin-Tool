package by.vls.admin.domain.settings.rate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "baserate")
public class BaseRate {
	@Id
	private int id;
	private String currency;
	private float rate;

	public BaseRate() {

	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "BaseRate [id=" + id + ", currency=" + currency + ", rate=" + rate + "]";
	}

}