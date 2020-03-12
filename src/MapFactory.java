class MapFactory<K, V> {
    public Map<K, V> getMap(int mapType) {
        switch (mapType) {
            case 1:
                return new MyHashMap<K,V>();
            case 2:
                return new MyTreeMap<K,V>();
            case 3:
                return new MyLinkedHashMap<K,V>();
            default:
                return null;
        }
    }
}