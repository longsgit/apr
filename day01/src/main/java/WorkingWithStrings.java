public class WorkingWithStrings {
    public static void main(String[] args) {
        //String is an immutable entity
        String language = "Java";
        String name = "Sam";
        language += " is cool";
        name = "Hello " + name;
        String lang = "Java is cool";

        String message = "";
        for (int i = 0; i < 10; i++) {
            message += i;
        }

        //Strings are meant to be used as constants
        //If you want to manipulate strings do not use strings, use StringBuilder instead

        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < 10; i++) {
            stringBuilder.append(i);
        }
        System.out.println(stringBuilder.toString());

    }
}
