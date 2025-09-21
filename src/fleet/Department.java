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
        for (Department d : Department.values()) {
            if (d.name().equalsIgnoreCase(departmentStr)) {
                return d;
            }
        }
        return null;
    }
}
