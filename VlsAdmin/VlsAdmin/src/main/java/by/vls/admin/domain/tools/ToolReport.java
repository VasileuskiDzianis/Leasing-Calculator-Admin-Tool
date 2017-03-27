package by.vls.admin.domain.tools;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import by.vls.admin.dao.DaoException;
import by.vls.admin.dao.PersonDao;
import by.vls.admin.domain.Person;

public class ToolReport implements Tool {
	final static Logger logger = Logger.getLogger(ToolReport.class);
	@Override
	public void takeTool() {
		// TODO Auto-generated method stub
		

	}

	@Override
	public void useTool() {
				
	}

	private PersonDao personDao;

	public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	public List<Person> getPersonsWithHigherIncome(int income) throws DaoException{

		List<Person> persons;
		
		try {
			persons = personDao.getPersonsWithHigherIncome(income);
		} catch (DaoException e) {
			throw new DaoException("Getting person from DB error", e);
		}

		return persons;
	}

}
