public class OOBasics {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setName("Sam");
        p1.setAge(12);
        System.out.println(p1.getName());
        System.out.println(p1.getAge());

        Person p2 = new Person("Mary", 34);
        System.out.println(p2.getName());

        Training sb = new Training("Spring boot", 20, 200.34);
        System.out.println(sb);
    }
}
