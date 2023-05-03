package com.herbalife;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyLibraryTest {
    private MyLibrary myLibrary;

    @BeforeEach
    public void setUp() {
        myLibrary = new MyLibrary();
    }

    @Test
    public void checkMyLibraryIsNotNull() {
        assertNotNull(myLibrary);
    }

    @Test
    public void testNumbersAreEmptyInTheBeginning() {
        int size = myLibrary.getSize();
        assertEquals(size, 0);
    }

    @Test
    public void addANumberAndCheckTheSize() {
        myLibrary.add(100);
        assertEquals(myLibrary.getSize(), 1);
    }

    @Test
    public void removeANumberAndCheckTheSize() {
        myLibrary.add(100);
        myLibrary.remove(100);
        assertTrue(myLibrary.getSize() == 0);
    }

    @Test
    public void removeANumberThatDoesNotExist() {
        assertThrows(RuntimeException.class, () -> {
            myLibrary.remove(100);
        });
    }

    @Test
    public void checkErrorMessageWhenRemovingANumberThatDoesNotExist() {
        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            myLibrary.remove(100);
        });
        assertEquals(ex.getMessage(), "100 is not found");
    }

    @Test
    public void addDuplicates() {
        assertThrows(RuntimeException.class, () -> {
            myLibrary.add(100);
            myLibrary.add(100);
        });
    }

    @Test
    public void checkErrorMessageWhenAddingDuplicates() {
        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            myLibrary.add(100);
            myLibrary.add(100);
        });
        assertEquals(ex.getMessage(), "100 is already found");
    }

    @Test
    public void checkIncrementOfDummy() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        //NOT RECOMMENDED
        //You can look for utilities that use reflection internally and help you access private members

        Class cls = myLibrary.getClass();
        Method incrementMethod = cls.getDeclaredMethod("increment");
        incrementMethod.setAccessible(true);
        incrementMethod.invoke(myLibrary);
        Field dummyField = cls.getDeclaredField("dummy");
        dummyField.setAccessible(true);
        int dummy = (int) dummyField.get(myLibrary);
        assertEquals(1, dummy);

    }

}
