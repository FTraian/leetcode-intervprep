package hard.lru_cache;

import java.util.*;

class LRUCache {

    private final int capacity;
    private final Map<Integer, CacheElement> cache;
    private final Deque<CacheElement> queue;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        queue = new LinkedList<>();
    }

    public int get(int key) {
        CacheElement e;
        if ((e = cache.get(key)) == null) {
            return -1;
        }

        queue.remove(e);
        queue.addLast(e);
        return e.value;
    }

    public void put(int key, int value) {
        if (cache.get(key) == null && cache.size() + 1 > capacity) {
            CacheElement head = queue.pollFirst();
            cache.remove(head.key);
        }

        CacheElement e;
        if (cache.get(key) != null) {
            e = cache.get(key);
            queue.remove(e);
            e.value = value;

            cache.put(key, e);
            queue.addLast(e);
        } else {
            e = new CacheElement();
            e.key = key;
            e.value = value;

            cache.put(key, e);
            queue.addLast(e);
        }
    }

    class CacheElement implements Comparable<CacheElement> {

        Integer key;
        Integer value;

        @Override
        public int compareTo(CacheElement o) {
            return this.key - o.key;
        }
    }

    public static void main(String[] args) {
//        [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(2, 2);
        System.out.println(cache.get(2));
        cache.put(1, 1);
//        System.out.println(cache.get(2));
        cache.put(4, 1);
        System.out.println(cache.get(2));
//        System.out.println(cache.get(3));
//        System.out.println(cache.get(4));
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */