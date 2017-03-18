package by.vls.admin.view;

import java.util.Map;
import java.util.Set;

import by.vls.admin.domain.tools.Tool;

public class ToolBox {
	private String label;
	private String link;
	private Map<String, Tool> tools;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Map<String, Tool> getTools() {
		return tools;
	}

	public void setTools(Map<String, Tool> tools) {
		this.tools = tools;
	}

	public ToolBox() {

	}

	public Set<String> showTools() {

		return tools.keySet();
	}

	public Tool selectTool(String toolName) {

		return tools.get(toolName);

	}
}
