import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.io.Serializable;

interface Map<K, V> {
    
    V put(K key, V value);
    
	boolean containsKey(K key);
    
    V get(K key);
    
    default void forEach( BiConsumer <? super K, ? super V> action) {
	}
    
    Set<java.util.Map.Entry<K,V>> entrySet();
    
}