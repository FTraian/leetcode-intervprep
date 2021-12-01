package lru_cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUQuickCache extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
