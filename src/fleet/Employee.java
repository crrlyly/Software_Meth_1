package fleet;
/**
 * The Employee enum represents employees by their last names.
 * Each employee is also associated with a Department.
 * This allows us to strongly type employee constants while
 * also tracking the department they belong to.
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

    Employee(Department dept) {
        this.dept = dept;
    }

    public Department getDept() {
        return dept;
    }
}
