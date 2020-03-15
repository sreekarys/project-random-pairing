
public class Employee {
	private String name;
	private String team;
	private String location;
	private boolean used;

	public Employee(String name, String location, String team) {
		this.name = name;
		this.location = location;
		this.team = team;
	}

	public String getName() {
		return name;
	}

	public String getTeam() {
		return team;
	}

	public String getLocation() {
		return location;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	@Override
	public boolean equals(Object obj) {
		Employee other = (Employee) obj;
		return this.location.equalsIgnoreCase(other.getLocation()) || this.team.equalsIgnoreCase(other.getTeam());
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", team=" + team + ", location=" + location + "]";
	}

}
