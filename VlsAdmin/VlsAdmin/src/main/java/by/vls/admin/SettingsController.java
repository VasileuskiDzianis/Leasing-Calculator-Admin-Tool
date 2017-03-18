package by.vls.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import by.vls.admin.dao.settings.rate.*;
import by.vls.admin.domain.settings.rate.*;
import by.vls.admin.view.Menu;

@Controller
public class SettingsController {

	private static final Logger logger = LoggerFactory.getLogger(SettingsController.class);

	@RequestMapping(value = "settings", method = RequestMethod.GET)
	public String showSettings(Locale locale, Model model) {
		logger.info("Welcome to Settings! The client locale is {}.", locale);

		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");

		Menu menu = (Menu) ctx.getBean("menu");

		model.addAttribute("menu", menu.getToolBoxes());

		BaseRateDao baseRateDao = (BaseRateDao) ctx.getBean("baseRateDao");

		List<BaseRate> baseRateList = baseRateDao.getBaseRate();

		model.addAttribute("baseRateList", baseRateList);

		ObjTypeMarginDao objTypeMarginDao = (ObjTypeMarginDao) ctx.getBean("objTypeMarginDao");

		List<ObjTypeMargin> objTypeMarginList = objTypeMarginDao.getObjTypeMargin();

		model.addAttribute("objTypeMarginList", objTypeMarginList);

		AgeMarginTruckDao ageMarginTruckDao = (AgeMarginTruckDao) ctx.getBean("ageMarginTruckDao");

		List<AgeMarginTruck> ageMarginTruckList = ageMarginTruckDao.getAgeMargin();

		model.addAttribute("ageMarginTruckList", ageMarginTruckList);

		AgeMarginCarDao ageMarginCarDao = (AgeMarginCarDao) ctx.getBean("ageMarginCarDao");

		List<AgeMarginCar> ageMarginCarList = ageMarginCarDao.getAgeMargin();

		model.addAttribute("ageMarginCarList", ageMarginCarList);

		AgeMarginLorryDao ageMarginLorryDao = (AgeMarginLorryDao) ctx.getBean("ageMarginLorryDao");

		List<AgeMarginLorry> ageMarginLorryList = ageMarginLorryDao.getAgeMargin();

		model.addAttribute("ageMarginLorryList", ageMarginLorryList);

		AgeMarginFarmmachDao ageMarginFarmmachDao = (AgeMarginFarmmachDao) ctx.getBean("ageMarginFarmmachDao");

		List<AgeMarginFarmmach> ageMarginFarmmachList = ageMarginFarmmachDao.getAgeMargin();

		model.addAttribute("ageMarginFarmmachList", ageMarginFarmmachList);

		AgeMarginRealestateDao ageMarginRealestateDao = (AgeMarginRealestateDao) ctx.getBean("ageMarginRealestateDao");

		List<AgeMarginRealestate> ageMarginRealestateList = ageMarginRealestateDao.getAgeMargin();

		model.addAttribute("ageMarginRealestateList", ageMarginRealestateList);

		AgeMarginEquipDao ageMarginEquipDao = (AgeMarginEquipDao) ctx.getBean("ageMarginEquipDao");

		List<AgeMarginEquip> ageMarginEquipList = ageMarginEquipDao.getAgeMargin();

		model.addAttribute("ageMarginEquipList", ageMarginEquipList);

		AgeMarginBuildmachDao ageMarginBuildmachDao = (AgeMarginBuildmachDao) ctx.getBean("ageMarginBuildmachDao");

		List<AgeMarginBuildmach> ageMarginBuildmachList = ageMarginBuildmachDao.getAgeMargin();

		model.addAttribute("ageMarginBuildmachList", ageMarginBuildmachList);

		return "settings";
	}

	@RequestMapping(value = "settings/savebaserate", method = RequestMethod.POST)
	public String saveBaseRate (Locale locale, 
			@RequestParam("usd") float usd, 
			@RequestParam("eur") float eur, 
			@RequestParam("byn") float byn, 
			@RequestParam("rub") float rub, 
			Model model)
	{
		logger.info("saveBaseRate");
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
		baseRateDao.updateBaseRate(baseRateList);

		return "redirect:../settings";

	}
	@RequestMapping(value = "settings/saveobjtypemargin", method = RequestMethod.POST)
	public String saveObjTypeMargin (Locale locale, 
			@RequestParam("buildingmachines") float buildingmachines, 
			@RequestParam("car") float car, 
			@RequestParam("equipment") float equipment, 
			@RequestParam("farmingmachinery") float farmingmachinery, 
			@RequestParam("lorry") float lorry, 
			@RequestParam("realestate") float realestate, 
			@RequestParam("truck") float truck, 
			
			Model model)
	{
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
		objTypeMarginDao.updateObjTypeMargin(ObjTypeMarginList);
		
		return "redirect:../settings";
		
	}
}
