public class MoreOnStrings {
    public static void main(String[] args) {
        String name = "Thomas";
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            System.out.println(ch);
        }
        System.out.println(name.toUpperCase());
        System.out.println(name.toLowerCase());
        String[] letters = name.split("");
        System.out.println(letters);
    }
}
