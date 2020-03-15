import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class RandomPairingBySorting {

	public static void main(String[] args) throws FileNotFoundException {
		FileInputStream fis = new FileInputStream(
				new File("/Users/syagnamo/Documents/AlternateWorkspace/project-random-pairing/src/Input.csv"));
		Scanner in = new Scanner(fis);
		List<Employee> employees = new ArrayList<>();
		while (in.hasNext()) {
			String line = in.next();
			String[] words = line.split(",");
			employees.add(new Employee(words[0], words[1], words[2]));
		}

		Collections.sort(employees, Comparator.comparing(Employee::getTeam).thenComparing(Employee::getLocation)
				.thenComparing(Employee::getName));

		for (Employee employee : employees) {
			if (employee.isUsed())
				continue;
			int j = employees.size() - 1;
			while (j >= 0) {
				Employee other = employees.get(j);
				if (!other.isUsed() && !employee.equals(other)) {
					System.out.println(employee.getName() + " - " + other.getName());
					employee.setUsed(true);
					other.setUsed(true);
					break;
				}
				j--;
			}
		}

		for (Employee employee : employees) {
			if (!employee.isUsed())
				System.out.println(employee.toString());
		}
		in.close();
	}

}
