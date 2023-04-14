package com.herbalife.examples;

public class AutoCloseableExample {
    public static void main(String[] args) {
//        MyResource myResource = new MyResource();
//        ///User myResource
//        myResource.close();

        try(MyResource myResource1 = new MyResource()) {

        }
        System.out.println("End of main");
    }
}

class MyResource implements AutoCloseable {
    public MyResource() {
        System.out.println("MyResource created");
    }
    public void close() {
        System.out.println("MyResource closed");
    }
}
