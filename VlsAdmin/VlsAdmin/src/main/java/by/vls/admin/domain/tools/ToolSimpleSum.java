package by.vls.admin.domain.tools;

import java.util.Scanner;

public class ToolSimpleSum implements Tool {

	@Override
	public void takeTool() {
		// TODO Auto-generated method stub

	}

	@Override
	public void useTool() {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		System.out.println("Summ = " + sum(a,b));

	}
	
	private int sum(int a, int b){
		return a+b;
	}

}
