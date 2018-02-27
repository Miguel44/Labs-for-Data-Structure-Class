package ioManagementClasses;

import java.util.Scanner;

/**
 * Singlenton classs to manage I/O
 * @author pirvos
 *
 */
public class IOComponent {
	private static final  IOComponent 	COMPONENT = new IOComponent(); 
	private Scanner sc; 
	
	private IOComponent() { 
		sc=new Scanner(System.in);
	}
	
	public static IOComponent getComponent() { 
		return COMPONENT; 
	}

	public String getInput(String msg) { 
		System.out.println(msg); 
		return sc.nextLine(); 
	}
	
	public void output(String line) { 
		System.out.print(line);
	}
}
