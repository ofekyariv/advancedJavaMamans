package application;

import java.util.Set;
import java.util.TreeMap;

public class AssociationTable<K extends Comparable<K>,V> {
	private TreeMap<K,V> table;
	
	public AssociationTable() {
		table = new TreeMap<>();
	}
	public AssociationTable(K[] keyValues,V[] values) {
		table = new TreeMap<>();
		if(keyValues.length!=values.length) {
			throw new Error("IllegalArgumentException");
		}
		else {
			for(int i =0; i<keyValues.length;i++) {
				table.put(keyValues[i],values[i]);
			}
		}
	}
	public void add(K key, V value) {
		table.put(key, value);
	}
	public V get(K key) {
		return table.get(key);
	}
	public boolean contains(K key) {
		return table.containsKey(key);
	}
	public boolean remove(K key) {
		return table.remove(key)!=null;
	}
	public int size() {
		return table.size();
	}
	//to check
	public Set<K> keyIterator() {
		return table.keySet();
	}
	

}
