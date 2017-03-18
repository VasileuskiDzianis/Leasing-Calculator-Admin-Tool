package by.vls.admin.domain.tools;

import java.util.ArrayList;
import java.util.List;

import by.vls.admin.dao.PersonDao;
import by.vls.admin.domain.Person;

public class ToolReport implements Tool {

	@Override
	public void takeTool() {
		// TODO Auto-generated method stub
		

	}

	@Override
	public void useTool() {
		// TODO Auto-generated method stub
		List<Person> persons = getPersonsWithHigherIncome(500);
		for (Person person : persons) {
			System.out.println(person);
		}
		
	}

	private PersonDao personDao;

	public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	public List<Person> getPersonsWithHigherIncome(int income) {

		List<Person> persons = personDao.getPersonsWithHigherIncome(income);

		return persons;
	}

}
