import java.util.Map;
class MapFactory<K, V> {
    public Map<K, V> getMap(int mapType) {
        switch (mapType) {
            case 1:
                return new HashMap<K,V>();
            case 2:
                return new TreeMap<K,V>();
            case 3:
                return new LinkedHashMap<K,V>();
            default:
                return new HashMap<K,V>();
        }
    }
}