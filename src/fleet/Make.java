package fleet;
/**
 * An enum class that enumerates through different vehicle makes.
 * Provides utility methods for parsing and comparing make strings.
 *
 * @author Carly Chick
 */
public enum Make {
    FORD,
    CHEVY,
    TOYOTA,
    HONDA;

    /**
     * Parses a string into its corresponding {@code Make} value.
     * The comparison is case-insensitive, so "ford" and "FORD" both match {@code Make.FORD}.
     *
     * @param makeStr the string to parse, representing a vehicle make
     * @return the matching {@code Make} constant if found, or {@code null} if no match exists
     */
    public static Make parseMake(String makeStr) {
        Make[] allMakes = Make.values();
        for (int i = 0; i < allMakes.length; i++) {
            if (allMakes[i].name().equalsIgnoreCase(makeStr)) {
                return allMakes[i];
            }
        }
        return null;
    }

    /**
     * Compares two strings lexicographically, ignoring case differences.
     * Works similarly to {@link String#compareToIgnoreCase(String)}.
     *
     * @param a the first string to compare
     * @param b the second string to compare
     * @return a negative integer if {@code a} comes before {@code b};
     *          a positive integer if {@code a} comes after {@code b};
     *          or zero if the strings are equal ignoring case
     */
    public static int compareStringsIgnoreCase(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        int lim = Math.min(len1, len2);

        for (int i = 0; i < lim; i++) {
            char c1 = Character.toLowerCase(a.charAt(i));
            char c2 = Character.toLowerCase(b.charAt(i));
            if (c1 != c2) {
                return c1 - c2; // negative if c1 < c2, positive if c1 > c2
            }
        }
        return len1 - len2; // shorter string comes first if prefix matches
    }
}
