package com.herbalife;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MyLibraryUsingMockitoTest {
    @Mock
    private List<Integer> numbers;

    @InjectMocks
    private MyLibrary myLibrary;

    @Test
    public void checkIfMyLibraryIsNotNull() {
        assertNotNull(myLibrary);
    }

    @Test
    public void testNumbersAreEmptyInTheBeginning() {
        assertEquals(myLibrary.getSize(), 0);
    }

    @Test
    public void addANumberAndCheckTheSize() {
        when(numbers.add(100)).thenReturn(true);
        when(numbers.size()).thenReturn(1);
        myLibrary.add(100);
        assertEquals(myLibrary.getSize(), 1);
        verify(numbers, times(1)).add(100);
        verify(numbers, times(1)).size();
    }

    @Test
    @Disabled
    public void removeANumberAndCheckTheSize() {
        //NEED TO WRITE A LOT MORE TO MOCK STREAM API
        when(numbers.contains(100)).thenReturn(false);
        when(numbers.remove(100)).thenReturn(100);
        when(numbers.size()).thenReturn(0);

        myLibrary.remove(100);
        assertTrue(myLibrary.getSize() == 0);
    }
}
