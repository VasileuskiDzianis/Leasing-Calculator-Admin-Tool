package by.vls.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

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
import by.vls.admin.dao.settings.rate.*;
import by.vls.admin.domain.settings.rate.*;
import by.vls.admin.view.Menu;

@Controller
public class SettingsController {

	private static final Logger logger = LoggerFactory.getLogger(SettingsController.class);

	@RequestMapping(value = "settings", method = RequestMethod.GET)
	public String showSettings(Model model) {
		logger.warn("Setting form showed");

		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");

		Menu menu = (Menu) ctx.getBean("menu");

		model.addAttribute("menu", menu.getToolBoxes());

		BaseRateDao baseRateDao = (BaseRateDao) ctx.getBean("baseRateDao");

		List<BaseRate> baseRateList;
		
		try {
			baseRateList = baseRateDao.getBaseRate();
		} catch (DaoException e) {
			logger.error("Base rate getting error", e);
			baseRateList = new ArrayList();
			baseRateList.add(new BaseRate("error",0));
			
		}

		model.addAttribute("baseRateList", baseRateList);

		ObjTypeMarginDao objTypeMarginDao = (ObjTypeMarginDao) ctx.getBean("objTypeMarginDao");

		List<ObjTypeMargin> objTypeMarginList;
		try {
			objTypeMarginList = objTypeMarginDao.getObjTypeMargin();
		} catch (DaoException e) {
			logger.error("Object type margin getting error", e);
			objTypeMarginList = new ArrayList();
			objTypeMarginList.add(new ObjTypeMargin("error",0));
			
		}

		model.addAttribute("objTypeMarginList", objTypeMarginList);

		AgeMarginTruckDao ageMarginTruckDao = (AgeMarginTruckDao) ctx.getBean("ageMarginTruckDao");

		List<AgeMarginTruck> ageMarginTruckList;
		
		try {
			ageMarginTruckList = ageMarginTruckDao.getAgeMargin();
		} catch (DaoException e) {
			logger.error("Age margin truck getting error", e);
			ageMarginTruckList = new ArrayList();
			ageMarginTruckList.add(new AgeMarginTruck(0,0));
		}

		model.addAttribute("ageMarginTruckList", ageMarginTruckList);

		AgeMarginCarDao ageMarginCarDao = (AgeMarginCarDao) ctx.getBean("ageMarginCarDao");

		List<AgeMarginCar> ageMarginCarList;
		
		try {
			ageMarginCarList = ageMarginCarDao.getAgeMargin();
		} catch (DaoException e) {
			logger.error("Age margin car getting error", e);
			ageMarginCarList = new ArrayList();
			ageMarginCarList.add(new AgeMarginCar(0,0));
		}

		model.addAttribute("ageMarginCarList", ageMarginCarList);

		AgeMarginLorryDao ageMarginLorryDao = (AgeMarginLorryDao) ctx.getBean("ageMarginLorryDao");

		List<AgeMarginLorry> ageMarginLorryList;
		
		try {
			ageMarginLorryList = ageMarginLorryDao.getAgeMargin();
		} catch (DaoException e) {
			logger.error("Age margin lorry getting error", e);
			ageMarginLorryList = new ArrayList();
			ageMarginLorryList.add(new AgeMarginLorry(0,0));
		}

		model.addAttribute("ageMarginLorryList", ageMarginLorryList);

		AgeMarginFarmmachDao ageMarginFarmmachDao = (AgeMarginFarmmachDao) ctx.getBean("ageMarginFarmmachDao");

		List<AgeMarginFarmmach> ageMarginFarmmachList;
		try {
			ageMarginFarmmachList = ageMarginFarmmachDao.getAgeMargin();
		} catch (DaoException e) {
			logger.error("Age margin farming machinery getting error", e);
			ageMarginFarmmachList = new ArrayList();
			ageMarginFarmmachList.add(new AgeMarginFarmmach(0,0));
		}

		model.addAttribute("ageMarginFarmmachList", ageMarginFarmmachList);

		AgeMarginRealestateDao ageMarginRealestateDao = (AgeMarginRealestateDao) ctx.getBean("ageMarginRealestateDao");

		List<AgeMarginRealestate> ageMarginRealestateList;
		try {
			ageMarginRealestateList = ageMarginRealestateDao.getAgeMargin();
		} catch (DaoException e) {
			logger.error("Age margin realestate getting error", e);
			ageMarginRealestateList = new ArrayList();
			ageMarginRealestateList.add(new AgeMarginRealestate(0,0));
		}

		model.addAttribute("ageMarginRealestateList", ageMarginRealestateList);

		AgeMarginEquipDao ageMarginEquipDao = (AgeMarginEquipDao) ctx.getBean("ageMarginEquipDao");

		List<AgeMarginEquip> ageMarginEquipList;
		try {
			ageMarginEquipList = ageMarginEquipDao.getAgeMargin();
		} catch (DaoException e) {
			logger.error("Age margin equipment getting error", e);
			ageMarginEquipList = new ArrayList();
			ageMarginEquipList.add(new AgeMarginEquip(0,0));
		}

		model.addAttribute("ageMarginEquipList", ageMarginEquipList);

		AgeMarginBuildmachDao ageMarginBuildmachDao = (AgeMarginBuildmachDao) ctx.getBean("ageMarginBuildmachDao");

		List<AgeMarginBuildmach> ageMarginBuildmachList;
		try {
			ageMarginBuildmachList = ageMarginBuildmachDao.getAgeMargin();
		} catch (DaoException e) {
			logger.error("Age margin Building machines getting error", e);
			ageMarginBuildmachList = new ArrayList();
			ageMarginBuildmachList.add(new AgeMarginBuildmach(0,0));
		}

		model.addAttribute("ageMarginBuildmachList", ageMarginBuildmachList);

		return "settings";
	}

	@RequestMapping(value = "settings/savebaserate", method = RequestMethod.POST)
	public String saveBaseRate(@RequestParam("usd") float usd, @RequestParam("eur") float eur,
			@RequestParam("byn") float byn, @RequestParam("rub") float rub, Model model) {
		logger.warn("saveBaseRate");
		List<BaseRate> baseRateList = new ArrayList<BaseRate>();
		BaseRate baseRateUsd = new BaseRate();
		baseRateUsd.setCurrency("usd");
		baseRateUsd.setRate(usd);
		baseRateList.add(baseRateUsd);

		BaseRate baseRateEur = new BaseRate();
		baseRateEur.setCurrency("eur");
		baseRateEur.setRate(eur);
		baseRateList.add(baseRateEur);

		BaseRate baseRateByn = new BaseRate();
		baseRateByn.setCurrency("byn");
		baseRateByn.setRate(byn);
		baseRateList.add(baseRateByn);

		BaseRate baseRateRub = new BaseRate();
		baseRateRub.setCurrency("rub");
		baseRateRub.setRate(rub);
		baseRateList.add(baseRateRub);

		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
		BaseRateDao baseRateDao = (BaseRateDao) ctx.getBean("baseRateDao");
		try {
			baseRateDao.updateBaseRate(baseRateList);
		} catch (DaoException e) {
			logger.error("Update base rate error", e);
		}

		return "redirect:../settings";

	}

	@RequestMapping(value = "settings/saveobjtypemargin", method = RequestMethod.POST)
	public String saveObjTypeMargin(Locale locale, @RequestParam("buildingmachines") float buildingmachines,
			@RequestParam("car") float car, @RequestParam("equipment") float equipment,
			@RequestParam("farmingmachinery") float farmingmachinery, @RequestParam("lorry") float lorry,
			@RequestParam("realestate") float realestate, @RequestParam("truck") float truck,

			Model model) {
		logger.info("saveObjTypeMargin");
		List<ObjTypeMargin> ObjTypeMarginList = new ArrayList<ObjTypeMargin>();

		ObjTypeMargin objTypeMarginBuildingmachines = new ObjTypeMargin();
		objTypeMarginBuildingmachines.setObjType("buildingmachines");
		objTypeMarginBuildingmachines.setObjTypeMargin(buildingmachines);
		ObjTypeMarginList.add(objTypeMarginBuildingmachines);

		ObjTypeMargin objTypeMarginCar = new ObjTypeMargin();
		objTypeMarginCar.setObjType("car");
		objTypeMarginCar.setObjTypeMargin(car);
		ObjTypeMarginList.add(objTypeMarginCar);

		ObjTypeMargin objTypeMarginEquipment = new ObjTypeMargin();
		objTypeMarginEquipment.setObjType("equipment");
		objTypeMarginEquipment.setObjTypeMargin(equipment);
		ObjTypeMarginList.add(objTypeMarginEquipment);

		ObjTypeMargin objTypeMarginFarmingmachinery = new ObjTypeMargin();
		objTypeMarginFarmingmachinery.setObjType("farmingmachinery");
		objTypeMarginFarmingmachinery.setObjTypeMargin(farmingmachinery);
		ObjTypeMarginList.add(objTypeMarginFarmingmachinery);

		ObjTypeMargin objTypeMarginLorry = new ObjTypeMargin();
		objTypeMarginLorry.setObjType("lorry");
		objTypeMarginLorry.setObjTypeMargin(lorry);
		ObjTypeMarginList.add(objTypeMarginLorry);

		ObjTypeMargin objTypeMarginRealestate = new ObjTypeMargin();
		objTypeMarginRealestate.setObjType("realestate");
		objTypeMarginRealestate.setObjTypeMargin(realestate);
		ObjTypeMarginList.add(objTypeMarginRealestate);

		ObjTypeMargin objTypeMarginTruck = new ObjTypeMargin();
		objTypeMarginTruck.setObjType("truck");
		objTypeMarginTruck.setObjTypeMargin(truck);
		ObjTypeMarginList.add(objTypeMarginTruck);

		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
		ObjTypeMarginDao objTypeMarginDao = (ObjTypeMarginDao) ctx.getBean("objTypeMarginDao");
		try {
			objTypeMarginDao.updateObjTypeMargin(ObjTypeMarginList);
		} catch (DaoException e) {
			logger.error("Update object type margin error", e);
		}

		return "redirect:../settings";

	}

	@RequestMapping(value = "settings/saveagemargin", method = RequestMethod.POST)
	public String saveAgeMargin(Locale locale, Model model, HttpServletRequest request) {
		logger.info("saveAgeMargin");

		List<AgeMarginCar> ageMarginCarList = new ArrayList<AgeMarginCar>();
		for (int i = 0; i <= 10; i++) {
			if (request.getParameter("carage_" + i) != null) {
				ageMarginCarList.add(new AgeMarginCar(i, Float.parseFloat(request.getParameter("carage_" + i))));
			}
		}

		List<AgeMarginBuildmach> ageMarginBuildmachList = new ArrayList<AgeMarginBuildmach>();
		for (int i = 0; i <= 10; i++) {
			if (request.getParameter("buildmachage_" + i) != null) {
				ageMarginBuildmachList
						.add(new AgeMarginBuildmach(i, Float.parseFloat(request.getParameter("buildmachage_" + i))));
			}
		}

		List<AgeMarginEquip> ageMarginEquipList = new ArrayList<AgeMarginEquip>();
		for (int i = 0; i <= 10; i++) {
			if (request.getParameter("equipage_" + i) != null) {
				ageMarginEquipList.add(new AgeMarginEquip(i, Float.parseFloat(request.getParameter("equipage_" + i))));
			}
		}

		List<AgeMarginFarmmach> ageMarginFarmmachList = new ArrayList<AgeMarginFarmmach>();
		for (int i = 0; i <= 10; i++) {
			if (request.getParameter("farmmachage_" + i) != null) {
				ageMarginFarmmachList
						.add(new AgeMarginFarmmach(i, Float.parseFloat(request.getParameter("farmmachage_" + i))));
			}
		}

		List<AgeMarginLorry> ageMarginLorryList = new ArrayList<AgeMarginLorry>();
		for (int i = 0; i <= 10; i++) {
			if (request.getParameter("lorryage_" + i) != null) {
				ageMarginLorryList.add(new AgeMarginLorry(i, Float.parseFloat(request.getParameter("lorryage_" + i))));
			}
		}

		List<AgeMarginRealestate> ageMarginRealestateList = new ArrayList<AgeMarginRealestate>();
		for (int i = 0; i <= 10; i++) {
			if (request.getParameter("realestateage_" + i) != null) {
				ageMarginRealestateList
						.add(new AgeMarginRealestate(i, Float.parseFloat(request.getParameter("realestateage_" + i))));
			}
		}

		List<AgeMarginTruck> ageMarginTruckList = new ArrayList<AgeMarginTruck>();
		for (int i = 0; i <= 10; i++) {
			if (request.getParameter("truckage_" + i) != null) {
				ageMarginTruckList.add(new AgeMarginTruck(i, Float.parseFloat(request.getParameter("truckage_" + i))));
			}
		}

		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
		
		AgeMarginBuildmachDao ageMarginBuildmachDao = (AgeMarginBuildmachDao) ctx.getBean("ageMarginBuildmachDao");
		AgeMarginCarDao ageMarginCarDao = (AgeMarginCarDao) ctx.getBean("ageMarginCarDao");
		AgeMarginEquipDao ageMarginEquipDao = (AgeMarginEquipDao) ctx.getBean("ageMarginEquipDao");
		AgeMarginFarmmachDao ageMarginFarmmachDao = (AgeMarginFarmmachDao) ctx.getBean("ageMarginFarmmachDao");
		AgeMarginLorryDao ageMarginLorryDao = (AgeMarginLorryDao) ctx.getBean("ageMarginLorryDao");
		AgeMarginRealestateDao ageMarginRealestateDao = (AgeMarginRealestateDao) ctx.getBean("ageMarginRealestateDao");
		AgeMarginTruckDao ageMarginTruckDao = (AgeMarginTruckDao) ctx.getBean("ageMarginTruckDao");
		
		try {
			ageMarginBuildmachDao.updateAgeMargin(ageMarginBuildmachList);
			ageMarginCarDao.updateAgeMargin(ageMarginCarList);
			ageMarginEquipDao.updateAgeMargin(ageMarginEquipList);
			ageMarginFarmmachDao.updateAgeMargin(ageMarginFarmmachList);
			ageMarginLorryDao.updateAgeMargin(ageMarginLorryList);
			ageMarginRealestateDao.updateAgeMargin(ageMarginRealestateList);
			ageMarginTruckDao.updateAgeMargin(ageMarginTruckList);
		} catch (DaoException e) {
			logger.error("Error updating Age margin for objects", e);
		}
		
		
		

		return "redirect:../settings";

	}
}
