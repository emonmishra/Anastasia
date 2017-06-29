package com.rockyou.storage;

import java.util.HashMap;
import java.util.Map;

public class CacheStorage {

    // TODO: based on xmx size, derive initial capacity
    Map<Key, Value> defaultCache = new HashMap<>(100000, 1);

    private Map<Key, Value> cache;

    public CacheStorage(Map<Key, Value> cache) {
        this.cache = cache;
    }

    public CacheStorage() {
        this.cache = defaultCache;
    }


    public Object get(Key key) {

        return cache.get(key);
    }

    public Object put(Key key, Value value) {
        return cache.put(key, value);
    }

    public Object delete(Key key) {
        return cache.remove(key);
    }

}
