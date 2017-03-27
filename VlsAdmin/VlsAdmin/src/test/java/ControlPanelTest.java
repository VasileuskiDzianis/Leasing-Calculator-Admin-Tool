
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.vls.admin.domain.Person;
import by.vls.admin.domain.tools.Tool;
import by.vls.admin.domain.tools.ToolReport;
import by.vls.admin.view.Menu;
import by.vls.admin.view.ToolBox;

public class ControlPanelTest {

	public static void main(String[] args) {
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
		
		/*Menu menu = (Menu)ctx.getBean("controlPanel");
		
		Set<String> toolBoxes;
		toolBoxes = menu.showToolBoxes();
		for(String toolBox: toolBoxes){
			System.out.println(toolBox);
		}
		
		ToolBox toolBox = menu.selectToolBox("privateTools");
		Set<String> tools = toolBox.showTools();
		for (String string : tools) {
			System.out.println(string);
		}
		
		ToolReport toolReport = (ToolReport)toolBox.selectTool("report");
		List<Person> list = toolReport.getPersonsWithHigherIncome(0);
		
		for (Person person : list) {
			System.out.println(person);
		}*/
		
		StringBuilder stringBuilder = new StringBuilder(" Hello den   :)   ");
		
		stringBuilder.delete(5, 9);
		System.out.println(stringBuilder);
		stringBuilder.reverse();
		System.out.println(stringBuilder);
		System.out.println(stringBuilder.toString().trim()+"BBB");
		
		SortedSet<String> sortedSet = new TreeSet<String>();
		sortedSet.add("Иван");
		sortedSet.add("Ян");
		sortedSet.add("Антон");
		sortedSet.add("Антон");
		sortedSet.add("Пётр");
		sortedSet.add("Абрам");
		
		for (String string : sortedSet) {
			System.out.println(string);
		}
		
		System.out.println("Maximum: " + Collections.min(sortedSet).toUpperCase());
				
	}

}
