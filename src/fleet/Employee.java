package fleet;
/**
 * The Employee enum represents employees by their last names.
 * Each employee is also associated with a Department.
 * which helps organize employees by their field of work.
 *
 * @author Carly Chick
 */
public enum Employee {
    Patel(Department.ComputerScience),
    Lim(Department.ElectricalEngineering),
    Zimnes(Department.ComputerScience),
    Harper(Department.ElectricalEngineering),
    Kaur(Department.InformationTechnologyAndInformatics),
    Taylor(Department.Math),
    Ramesh(Department.Math),
    Ceravolo(Department.BusinessAnalyticsAndInformationTechnology);

    private Department dept;

    /**
     * Creates an employee constant with the given department.
     *
     * @param dept
     */
    Employee(Department dept) {
        this.dept = dept;
    }

    public Department getDept() {
        return dept;
    }

    /**
     * Converts a string into the matching employee constant.
     * The match is case-insensitive, so "patel" and "Patel" both work.
     *
     * @param employeeStr the string to match against employee names
     * @return the matching employee constant; null if no match is found
     */
    public static Employee parseEmployee(String employeeStr) {
        Employee[] allEmployees = Employee.values();   // get all enum constants
        for (int i = 0; i < allEmployees.length; i++) {
            if (allEmployees[i].name().equalsIgnoreCase(employeeStr)) {
                return allEmployees[i];
            }
        }
        return null; // not found
    }
}
