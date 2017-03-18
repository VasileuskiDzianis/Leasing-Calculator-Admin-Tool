package by.vls.admin.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.CascadeType;


import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name="persons")
public class Person implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String gender;
	private String firstName;
	private String lastName;
	private String patronymicName;
	private LocalDate birthDate;
	private String phoneNumber;
	private String employer;
	private String position;
	private int monthlyIncome;
	private int segment;
	private Address address;

	public Person() {

	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Column(name = "gender")
	public String getGender() {
		return gender;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Column(name = "firstname")
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Column(name = "lastname")
	public String getLastName() {
		return lastName;
	}

	public void setPatronymicName(String patronymicName) {
		this.patronymicName = patronymicName;
	}
	@Column(name = "patronymicname")
	public String getPatronymicName() {
		return patronymicName;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	@Column(name = "birthdate")
	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}
	@Column(name = "employer")
	public String getEmployer() {
		return employer;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	@Column(name = "position")
	public String getPosition() {
		return position;
	}

	public void setMonthlyIncome(int monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}
	@Column(name = "monthlyincome")
	public int getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Column(name = "phonenumber")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setSegment(int segment) {
		this.segment = segment;
	}
	@Column(name = "segment")
	public int getSegment() {
		return segment;
	}

	@OneToOne(cascade = CascadeType.ALL) 
	@JoinColumn(name="address_id")
	   	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", gender=" + gender + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", patronymicName=" + patronymicName + ", birthDate=" + birthDate + ", phoneNumber=" + phoneNumber
				+ ", employer=" + employer + ", position=" + position + ", monthlyIncome=" + monthlyIncome
				+ ", segment=" + segment + ", address=" + address + "]";
	}
	
	
}
