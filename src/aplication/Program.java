package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {
	
	public static void main (String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		
		Scanner read = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department name: ");
		String depName = read.nextLine();
		
		System.out.println("Enter worker  data: ");
		System.out.print("name: ");
		String workName = read.nextLine();
		
		System.out.print("level: ");
		String workLevel = read.nextLine();
		
		System.out.print("Base salary: ");
		double workBaseSal = read.nextDouble();
		
		Worker worker = new Worker(workName,WorkerLevel.valueOf(workLevel),workBaseSal ,new Departament(depName));
		
		System.out.print("How many contracts to this worker? ");
		int n = read.nextInt();
		
		for (int i = 1 ; i < n ;  i++) {
			
			System.out.printf("ENter contract #%d  data : \n",i);
			Date contractDate = sdf.parse(read.next());
			
			System.out.print("Value per hour: ");
			double valuePerHour = read.nextDouble();
			
			
			System.out.print("Duration (hours): ");
			int hours = read.nextInt();
			
			HourContract contract = new HourContract(contractDate,valuePerHour,hours);
			
			worker.addContract(contract);
		}
		
		System.out.printf("\nEnter month and year to calculate income (MM/YYYY)");
		String monthAndYear = read.next();
		
		int month = Integer.parseInt(monthAndYear.substring(0,2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.printf("\nName: %s",worker.getName());
		System.out.printf("\nName: %s",worker.getDepartament());
		System.out.printf("Income for %s : %s", monthAndYear,String.format("%.2f", worker.income(year, month)));
		
		read.close();
	}
}
