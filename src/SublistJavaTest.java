import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SublistJavaTest {

    @Test
    public void testEqualLists() {
        SublistJava<Integer> sublistJava = new SublistJava<>();
        assertEquals(CheckResult.EQUAL, sublistJava.checkSublist(Arrays.asList(1, 2), Arrays.asList(1, 2)));
        assertEquals(CheckResult.EQUAL, sublistJava.checkSublist(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3)));
    }

    @Test
    public void testSublist() {
        SublistJava<Integer> sublistJava = new SublistJava<>();
        assertEquals(CheckResult.SUBLIST, sublistJava.checkSublist(Arrays.asList(1), Arrays.asList(1, 2)));
    }

    @Test
    public void testSuperlist() {
        SublistJava<Integer> sublistJava = new SublistJava<>();
        assertEquals(CheckResult.SUPERLIST, sublistJava.checkSublist(Arrays.asList(1, 2), Arrays.asList(1)));
    }

    @Test
    public void testUnequalLists() {
        SublistJava<Integer> sublistJava = new SublistJava<>();
        assertEquals(CheckResult.UNEQUAL, sublistJava.checkSublist(Arrays.asList(1, 2), Arrays.asList(2, 1)));
    }

    @Test
    public void testEmptyLists() {
        SublistJava<Integer> sublistJava = new SublistJava<>();
        assertEquals(CheckResult.EQUAL, sublistJava.checkSublist(new ArrayList<>(), new ArrayList<>()));
    }

    @Test
    public void testEmptyAndNonEmptyLists() {
        SublistJava<Integer> sublistJava = new SublistJava<>();
        assertEquals(CheckResult.SUBLIST, sublistJava.checkSublist(new ArrayList<>(), Arrays.asList(1, 2, 3)));
        assertEquals(CheckResult.SUPERLIST, sublistJava.checkSublist(Arrays.asList(1, 2, 3), new ArrayList<>()));
    }

    @Test
    public void testEqual() {
        SublistJava<Integer> sublistJava = new SublistJava<>();
        assertEquals(CheckResult.EQUAL, sublistJava.checkSublist(Arrays.asList(1, 2), Arrays.asList(1, 2)));
        assertEquals(CheckResult.EQUAL, sublistJava.checkSublist(Arrays.asList(), Arrays.asList()));
    }

    @Test
    public void testSublist2() {
        SublistJava<Integer> sublistJava = new SublistJava<>();
        assertEquals(CheckResult.SUBLIST, sublistJava.checkSublist(Arrays.asList(1), Arrays.asList(1, 2)));
        assertEquals(CheckResult.SUBLIST, sublistJava.checkSublist(Arrays.asList(), Arrays.asList(1, 2, 3)));
        assertEquals(CheckResult.SUBLIST, sublistJava.checkSublist(Arrays.asList(2, 3), Arrays.asList(1, 2, 3)));
    }

    @Test
    public void testSuperlist2() {
        SublistJava<Integer> sublistJava = new SublistJava<>();
        assertEquals(CheckResult.SUPERLIST, sublistJava.checkSublist(Arrays.asList(1, 2), Arrays.asList(1)));
        assertEquals(CheckResult.SUPERLIST, sublistJava.checkSublist(Arrays.asList(1, 2, 3), Arrays.asList(1, 2)));
        assertEquals(CheckResult.SUPERLIST, sublistJava.checkSublist(Arrays.asList(1, 2, 3), Arrays.asList()));
    }

    @Test
    public void testUnequal() {
        SublistJava<Integer> sublistJava = new SublistJava<>();
        assertEquals(CheckResult.UNEQUAL, sublistJava.checkSublist(Arrays.asList(1, 2), Arrays.asList(2, 1)));
        assertEquals(CheckResult.UNEQUAL, sublistJava.checkSublist(Arrays.asList(1), Arrays.asList(2)));
        assertEquals(CheckResult.UNEQUAL, sublistJava.checkSublist(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6)));
    }
}
