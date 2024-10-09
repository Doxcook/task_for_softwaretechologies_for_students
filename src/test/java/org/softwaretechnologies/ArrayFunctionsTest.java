package org.softwaretechnologies;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayFunctionsTest {

    @Test
    void reverseEvenArray() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        ArrayFunctions.reverse(array);
        assertArrayEquals(new int[]{8,7,6,5,4,3,2,1}, array);
    }

    @Test
    void reverseOddArray() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrayFunctions.reverse(array);
        assertArrayEquals(new int[]{9,8,7,6,5,4,3,2,1}, array);
    }

    @Test
    void reverseEmptyArray() {
        int[] array = {};
        ArrayFunctions.reverse(array);
        assertArrayEquals(new int[]{}, array);
    }

    @Test
    void reverseOneArray() {
        int[] array = {1};
        ArrayFunctions.reverse(array);
        assertArrayEquals(new int[]{1}, array);
    }

    private void assertMatrix(int[][] expected, int[][] matrix) {
        assertEquals(expected.length, matrix.length);
        if(expected.length > 0) {
            assertEquals(expected[0].length, matrix[0].length);
        }
        int i = 0;
        for (int[] ints : matrix) {
            assertArrayEquals(expected[i], ints);
            i++;
        }
    }

    @Test
    void rotateOneMatrix() {
        int[][] matrix = {{1}};
        ArrayFunctions.rotateMatrix(matrix);
        assertMatrix(new int[][]{{1}}, matrix);
    }

    @Test
    void rotateEmptyMatrix() {
        int[][] matrix = {{}};
        ArrayFunctions.rotateMatrix(matrix);
        assertMatrix(new int[][]{{}}, matrix);
    }

    @Test
    void rotateEvenMatrix() {
        int[][] matrix = {{1,  2,  3,  4},
                          {5,  6,  7,  8},
                          {9,  10, 11, 12},
                          {13, 14, 15, 16}};
        ArrayFunctions.rotateMatrix(matrix);

        int[][] reversedMatrix = {{1,  5,  9,  13},
                                  {2,  6,  10, 14},
                                  {3,  7,  11, 15},
                                  {4,  8,  12, 16}};
        assertMatrix(reversedMatrix, matrix);
    }

    @Test
    void rotateOddMatrix() {
        int[][] matrix = {{1,  2,  3},
                          {5,  6,  7},
                          {9,  10, 11}};
        ArrayFunctions.rotateMatrix(matrix);

        int[][] reversedMatrix = {{1,  5,  9},
                                 {2,  6,  10},
                                 {3,  7,  11}};
        assertMatrix(reversedMatrix, matrix);
    }
}