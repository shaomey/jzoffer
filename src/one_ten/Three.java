package one_ten;

public class Three {
    public static String replaceSpace(String s) {
        if (s.length() == 0) {
            return s;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                builder.append(s.charAt(i));
            } else {
                builder.append("%20");
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace("  "));
    }
}
