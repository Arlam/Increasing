package aa.task.increasing;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class FilterTest {

    private Filter filter;

    @Before
    public void init() {
        filter = new Filter();
    }

    @Test
    public void testGetMaxLengthIncreasingList0() {
        final Integer[] inputArray = {1, 2, 3, 4};
        List<Integer> inputList = Arrays.asList(inputArray);
        assertEquals(inputList, filter.getMaxLengthIncreasingList(inputList));
    }

    @Test
    public void testGetMaxLengthIncreasingList1() {
        final Integer[] inputArray = {2, 3, 1, 4};
        List<Integer> inputList = Arrays.asList(inputArray);
        assertEquals(Arrays.asList(2, 3, 4), filter.getMaxLengthIncreasingList(inputList));
    }

    @Test
    public void testGetMaxLengthIncreasingList2() {
        final Integer[] inputArray = {4, 3, 2, 1};
        List<Integer> inputList = Arrays.asList(inputArray);
        assertEquals(Arrays.asList(4), filter.getMaxLengthIncreasingList(inputList));
    }

    @Test
    public void testGetMaxLengthIncreasingList3() {
        final Integer[] inputArray = {4, 3, 2, 1, 5, 6, 4, 8};
        List<Integer> inputList = Arrays.asList(inputArray);
        assertEquals(Arrays.asList(3, 5, 6, 8), filter.getMaxLengthIncreasingList(inputList));
    }

    @Test
    public void testLogSet() {
        List<Integer> inputList = new ArrayList<>();
        int size = 10000;
        for (int i = 0; i < size; i++) {
            Random random = new Random();
            inputList.add(random.nextInt(size));
//            inputList.add(i+1);
        }
//        System.out.println(inputList);
        long startTime = System.currentTimeMillis();
        final List<Integer> result = filter.getMaxLengthIncreasingList(inputList);

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("totalTime: " + totalTime + "; size=" + result.size());
        System.out.println(result);
    }
}
