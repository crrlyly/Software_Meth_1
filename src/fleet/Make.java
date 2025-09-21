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

//    public static int compareStringsIgnoreCase(String a, String b) {
//        int len1 = a.length();
//        int len2 = b.length();
//        int lim = Math.min(len1, len2);
//
//        for (int i = 0; i < lim; i++) {
//            char c1 = Character.toLowerCase(a.charAt(i));
//            char c2 = Character.toLowerCase(b.charAt(i));
//            if (c1 != c2) {
//                return c1 - c2; // negative if c1 < c2, positive if c1 > c2
//            }
//        }
//        return len1 - len2; // shorter string comes first if prefix matches
//    }
}
