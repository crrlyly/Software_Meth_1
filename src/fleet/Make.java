package fleet;
/**
 An enum class that enumerates through different vehicle makes
 @author Carly Chick
 */
public enum Make {
    FORD,
    CHEVY,
    TOYOTA,
    HONDA;

    public static Make parseMake(String makeStr) {
        for (Make m : Make.values()) {
            if (m.name().equalsIgnoreCase(makeStr)) {
                return m;
            }
        }
        return null; // not found
    }
}
