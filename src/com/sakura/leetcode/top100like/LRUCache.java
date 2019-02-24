package com.sakura.leetcode.top100like;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    class Cache<K, V> extends LinkedHashMap<K, V> {
        private final int CACHE_SIZE;

        Cache(int cacheSize) {
            super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
            CACHE_SIZE = cacheSize;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > CACHE_SIZE;
        }
    }

    private Cache<Integer, Integer> cache;

    public LRUCache(int capacity) {
        cache = new Cache(capacity);
    }

    public int get(int key) {
        return cache.containsKey(key) ? cache.get(key) : -1;
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}
