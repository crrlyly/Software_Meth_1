package fleet;
/**
 First, a single, very descriptive sentence describing the class.
 Then, additional lines of description are added to elaborate on the
 details if necessary.
 @author Carly Chick
 */
public enum Department {
    ComputerScience,
    ElectricalEngineering,
    InformationTechnologyAndInformatics,
    Math,
    BusinessAnalyticsAndInformationTechnology;

    public static Department parseEmployee(String departmentStr) {
        Department[] allDepartments = Department.values(); // get all enum constants
        for (int i = 0; i < allDepartments.length; i++) {
            if (allDepartments[i].name().equalsIgnoreCase(departmentStr)) {
                return allDepartments[i];
            }
        }
        return null; // not found
    }

}
