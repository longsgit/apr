public class StringCreationAndComparison {
    public static void main(String[] args) {
        String language1 = "Java";
        String language2 = new String("Java"); //NOT Recommended

        if (language1 == language2) {
            System.out.println("Same");
        } else {
            System.out.println("Not same");
        }
        if (language1.equals(language2)) {
            System.out.println("Similar");
        }
        if (language1.equalsIgnoreCase(language2)) {
            System.out.println("Similar");
        }

        //Always stick to one way of creating string; without 'new' keyword is recommended
        //Always use .equals to compare string values
    }
}
