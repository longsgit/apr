package com.herbalife.examples;

public class MethodsUsingLambda {
    public static void main(String[] args) {
        SoftwareEngineer coder = () -> "Writing code";
        SoftwareEngineer qaEngineer = () -> "Running test cases";
        SoftwareEngineer uiProgrammer = () -> "Styling using SASS";

        workInProject(coder);
        workInProject(qaEngineer);
        workInProject(uiProgrammer);
        workInProject(() -> "Managing the standup");
        workInProject(() -> "Gathering requirements");

        String branch = "TRAINING-1023";

        workInProject(() -> {
            System.out.println("Create a new branch " + branch);
            System.out.println("Start writing code");
            System.out.println("Add and Commit the code");
            System.out.println("Push the code");
            System.out.println("Raise a PR");
            System.out.println("Move the story to Dev testing");
            return "In Dev testing";
        });

    }

    static void workInProject(SoftwareEngineer softwareEngineer) {
        System.out.println(softwareEngineer.work());
    }
}

@FunctionalInterface
interface SoftwareEngineer {
    String work();
}
