public class ConditionalsAndLoops {
    public static void main(String[] args) {
        //if-else, switch-case
        int num = 10;

        //String output = "Even" if num % 2 == 0 else "Odd"
        if (num % 2 == 0) {
            System.out.println("Even");
        } else if (num % 2 == 1) {
            System.out.println("Odd");
        }
        //In the latest version of Java, switch-case is not written like this anymore
        //switch-case is not a statement anymore, it's an expression
        switch (num % 2) {
            case 0:
                System.out.println("Even");
                break;
            case 1:
                System.out.println("Odd");
                break;
            default:
                System.out.println("WTH is this number?");
        }
        String name = "Ram";
        switch (name) {
            case "Ram":
                System.out.println("Ram");
            case "Sam":
                System.out.println("Sam");
        }

        //Loops
        //for, for-each, while, do-while
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        int count = 0;
        while (count < 5) {
            System.out.println("Do something");
            count++;
        }
        do {
            System.out.println(count);
            count++;
        } while (count < 10);

    }

}
