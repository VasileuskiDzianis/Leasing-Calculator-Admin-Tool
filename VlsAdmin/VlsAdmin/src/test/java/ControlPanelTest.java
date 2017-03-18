
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.vls.admin.domain.Person;
import by.vls.admin.domain.tools.Tool;
import by.vls.admin.domain.tools.ToolReport;
import by.vls.admin.view.Menu;
import by.vls.admin.view.ToolBox;

public class ControlPanelTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
		
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
				
	}

}
