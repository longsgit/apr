//POJO classes
//POJOs are commonly referred to as "Java beans"

//A Java bean is an ordinary java class with
// private variables and public getter/setter properties
// a default no-args constructor
// public methods
public class Person {
    private String name;
    private int age;

    //Constructor overloading

    public Person() {

    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(this.name + " is feeling hungry");
    }

    public void work(int hours) {
        System.out.println(String.format("%s is working for %s hours", this.name, hours));
    }
}
