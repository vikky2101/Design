package lrucache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V> extends LinkedHashMap<K, V> {
	private final int cache_Size;
	
	public LRUCache(final int size) {
		super(size, 0.75F, true);
		this.cache_Size = size;
	}
	
	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest){
		return this.cache_Size > 10;
	}

}
