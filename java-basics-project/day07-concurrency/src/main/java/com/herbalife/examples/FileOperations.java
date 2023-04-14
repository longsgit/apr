package com.herbalife.examples;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileOperations {
    public static void main(String[] args) throws IOException {
        callCloseExplicitly();
        callCloseImplicitlyUsingTry();
    }

    private static void callCloseImplicitlyUsingTry() throws IOException {
        try(FileReader fileReader1 = new FileReader("./cities.csv")) {

        }
        //fileReader1 will automatically get closed
    }

    private static void callCloseExplicitly() throws IOException {
        //You create objects and then explicitly call close()
        FileReader fileReader = new FileReader("./cities.csv");
        //do something with the fileReader
        fileReader.close();
    }
}

