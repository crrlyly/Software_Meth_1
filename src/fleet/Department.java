package fleet;
/**
 * The Department enum represents the different departments
 * that employees can belong to. Each constant is a
 * field of study.
 *
 * @author Carly Chick
 */
public enum Department {
    ComputerScience,
    ElectricalEngineering,
    InformationTechnologyAndInformatics,
    Math,
    BusinessAnalyticsAndInformationTechnology;

    /**
     * Turns a string into the matching department constant.
     * It is case-insensitive, so for example
     * "math" and "Math" will both return the Math constant.
     *
     * @param departmentStr the string to match against department names
     * @return the matching department constant; null if no match is found
     */
    public static Department parseEmployee(String departmentStr) {
        Department[] allDepartments = Department.values(); // get all enum constants
        for (int i = 0; i < allDepartments.length; i++) {
            if (allDepartments[i].name().equalsIgnoreCase(departmentStr)) {
                return allDepartments[i];
            }
        }
        return null; // not found
    }

    /**
     *
     * @return
     */
    public String convertToWords(){
        switch(this.name()){
            case "ComputerScience":
                return "Computer Science";
            case "ElectricalEngineering":
                return "Electrical Engineering";
            case "InformationTechnologyAndInformatics":
                return "Information Technology and Informatics";
            case "Math":
                return "Mathematics";
            case "BusinessAnalyticsAndInformationTechnology":
                return "Business Analytics and Information Technology";
            default:
                return "Failed to find department.";
        }
    }

}
