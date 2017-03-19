package by.vls.admin;

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

import by.vls.admin.dao.HibernateUtil;
import by.vls.admin.dao.PersonDao;
import by.vls.admin.domain.Person;
import by.vls.admin.domain.settings.rate.AgeMarginBuilmach;
import by.vls.admin.view.Menu;

@Controller
public class PrivateController {

	private static final Logger logger = LoggerFactory.getLogger(PrivateController.class);

	@RequestMapping(value = "private", method = RequestMethod.GET)
	public String privatePerson(Locale locale, Model model) {
		logger.info("Welcome to Private! The client locale is {}.", locale);

		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");

		Menu menu = (Menu) ctx.getBean("menu");

		model.addAttribute("menu", menu.getToolBoxes());
		PersonDao personDao = (PersonDao) ctx.getBean("personDao");
		List<Person> personsList = personDao.getPersonsWithHigherIncome(500);
		
		
		model.addAttribute("personsList", personsList);

		return "private";
	}

}
