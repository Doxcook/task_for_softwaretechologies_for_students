package org.softwaretechnologies;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ElevatorTest {
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    private static final PrintStream originalErr = System.err;

    Elevator elevator = new Elevator(-3, 100);

    @BeforeAll
    public static void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterAll
    public static void rollBackStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @BeforeEach
    public void cleanStream() {
        elevator.goToExactFloor(-3);
        outContent.reset();
        System.err.flush();
    }



    private static String createMessage(int currentFloor, int floor) {
        StringBuilder buffer = new StringBuilder();
        while (currentFloor != floor) {
            buffer.append("Текущий этаж: ")
                    .append(currentFloor)
                    .append(System.lineSeparator());
            if(currentFloor > floor) {
                currentFloor--;
            } else currentFloor++;
        }
        buffer.append("Вы достигли указанного этажа: ")
                .append(floor)
                .append(System.lineSeparator());
        return buffer.toString();
    }

    @Test
    void goToExactFloor_to_0() {
        elevator.goToExactFloor(0);
        assertEquals(createMessage(-3, 0), outContent.toString());
        assertEquals(0, elevator.getCurrentFloor());
    }

    @Test
    void goToExactFloor_to_100_then_to_50_then_to_50() {
        elevator.goToExactFloor(100);
        String messageTo100 = createMessage(-3, 100);
        assertEquals(messageTo100, outContent.toString());
        assertEquals(100, elevator.getCurrentFloor());

        elevator.goToExactFloor(50);
        String messageTo50 = messageTo100 + createMessage(100, 50);
        assertEquals(messageTo50, outContent.toString());
        assertEquals(50, elevator.getCurrentFloor());

        elevator.goToExactFloor(50);
        String messageTo50To50 = messageTo50 + createMessage(50, 50);
        assertEquals(messageTo50To50, outContent.toString());
        assertEquals(50, elevator.getCurrentFloor());
    }

    @Test
    void goToCurrentFloor() {
        elevator.goToExactFloor(-3);
        String messageTo_3 = createMessage(-3, -3);
        assertEquals(messageTo_3, outContent.toString());
        assertEquals(-3, elevator.getCurrentFloor());
    }

    @Test
    void wrongFloor() {
        elevator.goToExactFloor(101);
        assertEquals(-3, elevator.getCurrentFloor());
        elevator.goToExactFloor(-4);
        assertEquals(-3, elevator.getCurrentFloor());
        String s = "Указан неверный этаж" + System.lineSeparator() + "Указан неверный этаж" + System.lineSeparator();
        assertEquals(s, outContent.toString());
    }
}