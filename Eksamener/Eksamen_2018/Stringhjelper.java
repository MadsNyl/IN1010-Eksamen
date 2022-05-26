public class Stringhjelper {

    public static int inneholder(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            char bokstav = s.charAt(i);
            if (bokstav == t.charAt(0)) {
                for (int j = 1; j < t.length(); j++) {
                    if (s.charAt(i + j) != t.charAt(j)) {
                        return -1;
                    }
                }
                return i;
            }

        }

        return -1;
    }
}
