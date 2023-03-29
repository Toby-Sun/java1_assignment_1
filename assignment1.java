
/**
 * major_project - write code to ask user to imput name, days gone and imported good and disply results.
 * 
 * @author (Chris Ashe, Drew Temple-Smith, Ho Chun Sun) 
 * @version (group assignment1, Oct 17 2020)
 */
// Standard import for the Scanner class
import java.util.*;

public class assignment1 {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		// enter travlers name last,first,initials
		System.out.print("Traveller's name (last, first, initials): ");
		String name = in.nextLine();
		
		// split name
		String[] tempName = name.split(",");
		String lname = tempName[0];
		String fname = tempName[1];
		String intial = tempName[2];
		
		// enter lenght of absence
		System.out.print("Length of absence (# of days): ");
		double days = in.nextDouble();
		
		// enter imported goods
		System.out.print("Total amount of imported goods ($ CAD): ");
		double imported = in.nextDouble();
		
		// display rearanged name first, initials, last
		System.out.print("");
		String fullName = fname + intial + " " + lname;
		System.out.println("Import Exemption Report for" + fullName);
		System.out.println("------------------------------------------------------------");
		
		// A variable is defined for Alcohol & Tobacco exemption eligibility
		String alcohol;
		if (0 <= days && days < 1) {
			alcohol = "No";
		} else if (1 <= days && days < 2) {
			alcohol = "No";
		} else if (days >= 2) {
			alcohol = "Yes";
		} else {
			alcohol = "Yes";
		}
		
		// A varible is defined for exemption amount
		double exempt;
		if (days < 1) {
			exempt = 0;
		} else if (1 <= days && days < 2) {
			exempt = 200;
		} else {
			exempt = 800;
		}

		System.out.printf("Absence Period (days) %28.1f\n", days);
		String output;
		output = String.format("$%.2f", exempt);
		System.out.printf("...Maximum personal Exemption %20s\n", output);
		System.out.printf("...Include Limited Alcohol & Tobacco? %12s\n", alcohol);
		
		// A varible is defined for Usable Personal Exemption
		double usableExemption;
		if (days >= 1 && days < 2 && imported > 200) {
			usableExemption = 0;
		} else if (days >= 2 && imported < 800) {
			usableExemption = imported;
		} else {
			usableExemption = exempt;
		}
		output = String.format("$%.2f", usableExemption);
		System.out.printf("Usable Personal Exemption %34s\n", output);
		
		// A varible is defined for Amount Subject to Special Duty & Taxes
		double specialTaxes;
		if (days >= 2 && imported > 800 && imported <= 1100) {
			specialTaxes = (imported - 800);
		} else if (days >= 2 && imported > 1100) {
			specialTaxes = 300;
		} else {
			specialTaxes = 0;
		}
		output = String.format("$%.2f", specialTaxes);
		System.out.printf("Amount Subject to Special Duty & Taxes %21s\n", output);
		
		// A varible is defined for Amount Subject to Regular Duty & Taxes
		double regularTaxes;
		if (days >= 1 && days < 2 && imported > 200 || days < 1) {
			regularTaxes = imported;
		} else if (days >= 2 && imported > 1100) {
			regularTaxes = (imported - 1100);
		} else {
			regularTaxes = 0;
		}
		output = String.format("$%.2f", regularTaxes);
		System.out.printf("Amount Subject to Regular Duty & Taxes %21s\n", output);

		System.out.printf("%60s\n", "----------");
		
		// A varible is defined for Total Amount of Imported Goods
		double totalAmount = usableExemption + specialTaxes + regularTaxes;
		output = String.format("$%.2f", totalAmount);
		System.out.printf("Total Amount of Imported Goods %29s\n", output);
		System.out.println("------------------------------------------------------------");

	}
}
