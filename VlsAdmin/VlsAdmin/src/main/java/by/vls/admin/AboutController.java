package by.vls.admin;

import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.vls.admin.view.Menu;

@Controller
public class AboutController {

	private static final Logger logger = LoggerFactory.getLogger(AboutController.class);

	@RequestMapping(value = "about", method = RequestMethod.GET)
	public String about(Locale locale, Model model) {
		logger.info("Welcome to About! The client locale is {}.", locale);

		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");

		Menu menu = (Menu) ctx.getBean("menu");

		model.addAttribute("menu", menu.getToolBoxes());

		return "about";
	}

}
