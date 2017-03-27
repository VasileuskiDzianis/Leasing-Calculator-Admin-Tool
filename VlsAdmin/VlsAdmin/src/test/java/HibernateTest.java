import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import by.vls.admin.dao.HibernateUtil;
import by.vls.admin.domain.Person;
import by.vls.admin.domain.settings.rate.*;
import by.vls.admin.domain.settings.insurance.*;

public class HibernateTest {

	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + MySQL");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Person person = new Person();
		person.setId(42);
		session.load(person, person.getId());
		person.setMonthlyIncome(4000);
		person.getAddress().setBuilding("48-2");

		session.update(person);

		Query query = session.createQuery("from Person where monthlyIncome >= '500' ");
		List<Person> list = query.getResultList();

		List<BaseRate> baseRateList = session.createQuery("from BaseRate").getResultList();

		List<ObjTypeMargin> objTypeMargin = session.createQuery("from ObjTypeMargin").getResultList();

		List<AgeMarginTruck> ageMarginTruck = session.createQuery("from AgeMarginTruck").getResultList();
		List<AgeMarginRealestate> ageMarginRealestate = session.createQuery("from AgeMarginRealestate").getResultList();
		List<AgeMarginLorry> ageMarginLorry = session.createQuery("from AgeMarginLorry").getResultList();
		List<AgeMarginCar> ageMarginCar = session.createQuery("from AgeMarginCar").getResultList();
		List<AgeMarginFarmmach> ageMarginFarmmach = session.createQuery("from AgeMarginFarmmach").getResultList();
		List<AgeMarginEquip> ageMarginEquip = session.createQuery("from AgeMarginEquip").getResultList();
		List<AgeMarginBuildmach> ageMarginBuildmach = session.createQuery("from AgeMarginBuildmach").getResultList();

		List<InsureTypeBaseRate> insureTypeBaseRate = session.createQuery("from InsureTypeBaseRate").getResultList();
		List<AgeInsureTruck> ageInsureTruck = session.createQuery("from AgeInsureTruck").getResultList();
		List<AgeInsureCar> ageInsureCar = session.createQuery("from AgeInsureCar").getResultList();
		List<AgeInsureLorry> ageInsureLorry = session.createQuery("from AgeInsureLorry").getResultList();
		List<AgeInsureEquip> ageInsureEquip = session.createQuery("from AgeInsureEquip").getResultList();
		List<AgeInsureRealestate> ageInsureRealestate = session.createQuery("from AgeInsureRealestate").getResultList();
		List<AgeInsureBuildmach> ageInsureBuildmach = session.createQuery("from AgeInsureBuildmach").getResultList();
		List<AgeInsureFarmmach> ageInsureFarmmach = session.createQuery("from AgeInsureFarmmach").getResultList();
		
		

		session.getTransaction().commit();

		System.out.println("Person was readed: ");
		System.out.println(person);

		System.out.println("Persons from query: ");
		for (Person person2 : list) {
			System.out.println(person2);
		}
		System.out.println("Base rate: ");
		for (BaseRate baseRate : baseRateList) {
			System.out.println(baseRate);
		}

		System.out.println("Object Type Margin: ");
		for (ObjTypeMargin objTypeMargin2 : objTypeMargin) {
			System.out.println(objTypeMargin2);
		}
		System.out.println("Age Margin Truck settings: ");
		for (AgeMarginTruck ageMarginTruck2 : ageMarginTruck) {
			System.out.println(ageMarginTruck2);
		}
		System.out.println("Age Margin Realestate settings: ");
		for (AgeMarginRealestate ageMarginRealestate2 : ageMarginRealestate) {
			System.out.println(ageMarginRealestate2);
		}
		System.out.println("Age Margin Lorry settings: ");
		for (AgeMarginLorry ageMarginLorry2 : ageMarginLorry) {
			System.out.println(ageMarginLorry2);
		}
		System.out.println("Age Margin Car settings: ");
		for (AgeMarginCar ageMarginCar2 : ageMarginCar) {
			System.out.println(ageMarginCar2);
		}
		System.out.println("Age Margin Farmmach settings: ");
		for (AgeMarginFarmmach ageMarginFarmmach2 : ageMarginFarmmach) {
			System.out.println(ageMarginFarmmach2);
		}
		System.out.println("Age Margin Equip settings: ");
		for (AgeMarginEquip ageMarginEquip2 : ageMarginEquip) {
			System.out.println(ageMarginEquip2);
		}
		System.out.println("Age Margin Buildmach settings: ");
		for (AgeMarginBuildmach ageMarginBuildmach2 : ageMarginBuildmach) {
			System.out.println(ageMarginBuildmach2);
		}
		System.out.println("+++Insurance settings: ");
		System.out.println("InsureTypeBaseRate settings: ");
		for (InsureTypeBaseRate insureTypeBaseRate2 : insureTypeBaseRate) {
			System.out.println(insureTypeBaseRate2);
		}
		System.out.println("Truck age insurance margin: ");
		for (AgeInsureTruck ageInsureTruck2 : ageInsureTruck) {
			System.out.println(ageInsureTruck2);
		}
		System.out.println("Lorry age insurance margin: ");
		for (AgeInsureLorry ageInsureLorry2 : ageInsureLorry) {
			System.out.println(ageInsureLorry2);
		}
		System.out.println("Equip age insurance margin: ");
		for (AgeInsureEquip ageInsureEquip2 : ageInsureEquip) {
			System.out.println(ageInsureEquip2);
		}
		System.out.println("Car age insurance margin: ");
		for (AgeInsureCar ageInsureCar2 : ageInsureCar) {
			System.out.println(ageInsureCar2);
		}
		System.out.println("Realestate age insurance margin: ");
		for (AgeInsureRealestate ageInsureRealestate2 : ageInsureRealestate) {
			System.out.println(ageInsureRealestate2);
		}
		System.out.println("Farmmach age insurance margin: ");
		for (AgeInsureFarmmach ageInsureFarmmach2 : ageInsureFarmmach) {
			System.out.println(ageInsureFarmmach2);
		}
		System.out.println("Buildmach age insurance margin: ");
		for (AgeInsureBuildmach ageInsureBuildmach2 : ageInsureBuildmach) {
			System.out.println(ageInsureBuildmach2);
		}

	}

}
