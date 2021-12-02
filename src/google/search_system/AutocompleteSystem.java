package search_system;

import java.util.*;
import java.util.stream.Collectors;

public class AutocompleteSystem {

    LinkedHashMap<String, Integer> map, resultMap;
    StringBuffer currentSearch;

    public AutocompleteSystem(String[] sentences, int[] times) {
        map = new LinkedHashMap<>(sentences.length);
        for (int i = 0; i < sentences.length; i++) {
            map.put(sentences[i], times[i]);
        }
        currentSearch = new StringBuffer();
    }

    public List<String> input(char c) {
        if (c == '#' && currentSearch.length() != 0) {
            if (map.containsKey(currentSearch.toString())) {
                map.put(currentSearch.toString(), map.get(currentSearch.toString()) + 1);
            } else {
                map.put(currentSearch.toString(), 1);
            }
        }
        if (c == '#') {
            currentSearch.setLength(0);
            return Collections.emptyList();
        }

        currentSearch.append(c);
        String searchString = currentSearch.toString();
        resultMap = new LinkedHashMap<>();
        for (String s: map.keySet()) {
            if (s.startsWith(searchString)) {
                resultMap.put(s, map.get(s));
            }
        }

        return resultMap.entrySet().stream()
                .sorted(new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        int hotDiff = o2.getValue() - o1.getValue();
                        if (hotDiff != 0) return hotDiff;
                        return o2.getKey().compareTo(o1.getKey());
                    }
                })
                .limit(3).map(Map.Entry::getKey).collect(Collectors.toList());
    }

}
