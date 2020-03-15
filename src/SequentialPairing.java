import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SequentialPairing {

	public static void main(String args[]) throws FileNotFoundException {
		FileInputStream fis = new FileInputStream(
				new File("/Users/syagnamo/Documents/AlternateWorkspace/project-random-pairing/src/Input.csv"));
		Scanner in = new Scanner(fis);
		List<Employee> employees = new ArrayList<>();
		while (in.hasNext()) {
			String line = in.next();
			String[] words = line.split(",");
			employees.add(new Employee(words[0], words[1], words[2]));
		}

		for (int i = 0; i < employees.size(); i++) {
			if (employees.get(i).isUsed())
				continue;
			for (int j = i + 1; j < employees.size(); j++) {
				if (!employees.get(j).isUsed() && !employees.get(i).equals(employees.get(j))) {
					System.out.println(employees.get(i).getName() + " - " + employees.get(j).getName());
					employees.get(i).setUsed(true);
					employees.get(j).setUsed(true);
					break;
				}
			}
		}

		for (int i = 0; i < employees.size(); i++) {
			if (!employees.get(i).isUsed()) {
				System.out.println(employees.get(i).toString());
			}
		}
		in.close();
	}
}
