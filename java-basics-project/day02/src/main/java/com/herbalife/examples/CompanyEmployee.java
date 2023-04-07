package com.herbalife.examples;

public class CompanyEmployee {
    private String name;
    private static Office office;

    //static initializers
    static {
        office = new Office();
    }

    public CompanyEmployee(String name) {
        this.name = name;
        //this.office = new Office();
    }

    public static Office getOffice() {
        return office;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
