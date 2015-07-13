package aa.task.increasing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Filter {
    public List<Integer> getMaxLengthIncreasingList(List<Integer> initialList) {
        List<Integer> result = new LinkedList<>();
        List<Integer> chainsLength = new ArrayList<>(initialList.size());
        for (Integer valueId = 0; valueId < initialList.size(); valueId++) {
            Integer length = getMaxLength(chainsLength, initialList, valueId) + 1;
            chainsLength.add(valueId, length);
        }

        int size = chainsLength.size();
        Integer maxValue = null;
        while (size > 0) {
            int lastElementId = getLastElementId(chainsLength, initialList, maxValue, size);
            if (lastElementId >= 0) {
                Integer element = initialList.get(lastElementId);
                result.add(0, element);
                maxValue = element;
            }
            size = lastElementId;
        }
        return result;
    }

    private int getLastElementId(List<Integer> chainsLength, List<Integer> initialList, Integer maxValue, int size) {
        int maxSize = 0;
        int id = -1;
        for (int i = size - 1; i >= 0; i--) {
            int value = initialList.get(i);
            Integer length = chainsLength.get(i);
            if (maxSize < length && (maxValue == null || value <= maxValue)) {
                maxSize = length;
                id = i;
            }
        }
        return id;
    }

    private int getMaxLength(List<Integer> lengths, List<Integer> values, Integer valueId) {
        int value = values.get(valueId);
        int max = 0;
        for (int i = 0; i < valueId; i++) {
            if (lengths.get(i) > max && values.get(i) <= value) {
                max = lengths.get(i);
            }
        }
        return max;
    }
}
