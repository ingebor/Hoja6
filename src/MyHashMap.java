import java.util.Collection;
import java.util.Set;
import java.util.HashMap;

class MyHashMap<K, V> implements Map<K,V> {

	private HashMap<K,V> hashMap = new HashMap<K,V>();

	@Override
	public boolean containsKey(Object arg0) {
		// TODO Auto-generated method stub
		return hashMap.containsKey(arg0);
	}

	@Override
	public Set entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object get(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putAll(Map arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object put(Object key, Object value) {
		hashMap.put(key, value);
		return val;
	}

}