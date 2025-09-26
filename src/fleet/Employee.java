package fleet;
/**
 * The Employee enum represents employees by their last names.
 * Each employee is also associated with a Department.
 *
 * @author Carly Chick
 */
public enum Employee {
    PATEL(Department.ComputerScience),
    LIM(Department.ElectricalEngineering),
    ZIMNES(Department.ComputerScience),
    HARPER(Department.ElectricalEngineering),
    KAUR(Department.InformationTechnologyAndInformatics),
    TAYLOR(Department.Math),
    RAMESH(Department.Math),
    CERAVOLO(Department.BusinessAnalyticsAndInformationTechnology);

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
        return null;
    }
}
