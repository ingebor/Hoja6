import java.util.function.BiConsumer;

interface Map<K, V> {
    
    V put(K key, V value);
    
    boolean containsKey(K key);
    
    V get(K key);
    
    default void forEach( BiConsumer <? super K, ? super V> action) {
	}
}