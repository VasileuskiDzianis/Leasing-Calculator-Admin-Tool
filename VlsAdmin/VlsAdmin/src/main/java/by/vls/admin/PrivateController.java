package by.vls.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import by.vls.admin.dao.DaoException;
import by.vls.admin.dao.PersonDao;
import by.vls.admin.domain.Person;
import by.vls.admin.view.Menu;

@Controller
public class PrivateController {

	private static final Logger logger = LoggerFactory.getLogger(PrivateController.class);

	@RequestMapping(value = "private", method = RequestMethod.GET)
	public String privatePersonForm(Model model) {
		logger.warn("PrivatePersonForm run");

		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");

		Menu menu = (Menu) ctx.getBean("menu");

		model.addAttribute("menu", menu.getToolBoxes());

		return "private";
	}
	@RequestMapping(value = "private", method = RequestMethod.POST)
	public String privatePersonReport(Model model, @RequestParam("income") int income) {
		logger.warn("PrivatePersonReport run");

		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");

		Menu menu = (Menu) ctx.getBean("menu");

		model.addAttribute("menu", menu.getToolBoxes());
		PersonDao personDao = (PersonDao) ctx.getBean("personDao");
		List<Person> personsList;
		
		try {
			personsList= personDao.getPersonsWithHigherIncome(income);
		} catch (DaoException e) {
			logger.error("Getting person with higher income error", e);
			personsList = new ArrayList();
			Person person = new Person();
			personsList.add(person);
		}
		
		
		model.addAttribute("personsList", personsList);

		return "private";
	}

}
