import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;

interface Map<K, V> {
    
    V put(K key, V value);
    
    boolean containsKey(K key);
    
    V get(K key);
    
    default void forEach( BiConsumer <? super K, ? super V> action) {
	}
    
    void putAll(Map<? extends K, ? extends V> m);
    
    //Set<Map.Entry<K,V>> entrySet();
    
    /*interface Entry<K, V>{
    	K getKey();
    	V getValue();
    	public static <K, V> Comparator<Map.Entry<K, V>> comparingBykey(Comparator<?
    	super K> cmp){
    		Objects.requireNonNull(cmp);
    		return (Comparator<Map.Entry<K, V>> & Serializable)
    				(c1, c2) -> cmp.compare(c1.getKey(), c2.getKey());
    	}*/
    //}
}