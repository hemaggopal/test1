package com.infosys.learning.collections;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapSample {

	public static void main(String[] args) {
		Map<String, String> conMap = new ConcurrentHashMap<String, String>();
		conMap.put("key1", "val1");
		conMap.put("key2", "val2");

		Iterator<Map.Entry<String, String>> conIterator = conMap.entrySet().iterator();
		while (conIterator.hasNext()) {
			Map.Entry<String, String> entry = conIterator.next();
			if (entry.getKey().equals("key1"))
				conMap.remove(entry.getKey());
		}

		Map<String, String> map = new HashMap<String, String>();
		map.put("key1", "val1");
		map.put("key2", "val2");

		Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
		try {
			while (it.hasNext()) {
				Map.Entry<String, String> entry = it.next();
				if (entry.getKey().equals("key1"))
					map.remove(entry.getKey());
			}
		} catch (ConcurrentModificationException ce) {
			System.out.println("Iterators fail fast in HashMap and not in ConcurrentHashMap");
		}
	}
}
