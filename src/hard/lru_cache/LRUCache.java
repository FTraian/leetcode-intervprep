package hard.lru_cache;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class LRUCache {

    private final int capacity;
    private final Map<Integer, CacheElement> cache;
    private final PriorityQueue<CacheElement> queue;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        queue = new PriorityQueue<>(capacity);
    }

    public int get(int key) {
        CacheElement e;
        if ((e = cache.get(key)) == null) {
            return -1;
        }

        queue.remove(e);
        e.lruTimestamp = System.currentTimeMillis();
        queue.add(e);
        return e.value;
    }

    public void put(int key, int value) {
        if (cache.size() + 1 > capacity) {
            CacheElement head = queue.poll();
            cache.remove(head.key, head);
        }
        CacheElement e = new CacheElement();
        e.key = key;
        e.value = value;
        e.lruTimestamp = System.currentTimeMillis();
        cache.put(key, e);
        queue.add(e);
    }

    class CacheElement implements Comparable<CacheElement> {

        Integer key;
        Integer value;
        long lruTimestamp;

        @Override
        public int compareTo(CacheElement o) {
            return (int) (this.lruTimestamp - o.lruTimestamp);
        }
    }

    public static void main(String[] args) {
//        [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */