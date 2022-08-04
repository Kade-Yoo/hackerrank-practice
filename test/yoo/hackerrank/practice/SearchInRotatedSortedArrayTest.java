package yoo.hackerrank.practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchInRotatedSortedArrayTest {

    @Test
    void example1() {
        int search = SearchInRotatedSortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3);
        assertEquals(search, -1);
    }

    @Test
    void example2() {
        int search = SearchInRotatedSortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
        assertEquals(search, 4);
    }

    @Test
    void example3() {
        int search = SearchInRotatedSortedArray.search(new int[]{1}, 0);
        assertEquals(search, -1);
    }

    @Test
    void example4() {
        int search = SearchInRotatedSortedArray.search(new int[]{1, 3}, 0);
        assertEquals(search, -1);
    }

    @Test
    void example5() {
        int search = SearchInRotatedSortedArray.search(new int[]{1, 3}, 3);
        assertEquals(search, 1);
    }

    @Test
    void example6() {
        int search = SearchInRotatedSortedArray.search(new int[]{1, 3, 5}, 5);
        assertEquals(search, 2);
    }

    @Test
    void example7() {
        int search = SearchInRotatedSortedArray.search(new int[]{5, 1, 3}, 1);
        assertEquals(search, 1);
    }
}