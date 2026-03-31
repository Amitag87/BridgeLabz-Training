import java.util.LinkedList;

class CustomHashMap<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private LinkedList<Entry<K, V>>[] buckets;
    private int capacity = 16;
    private int size = 0;
    
    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        buckets = new LinkedList[capacity];
    }
    
    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }
    
    public void put(K key, V value) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        buckets[index].add(new Entry<>(key, value));
        size++;
    }
    
    public V get(K key) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) return null;
        
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }
    
    public void remove(K key) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) return;
        
        buckets[index].removeIf(entry -> {
            if (entry.key.equals(key)) {
                size--;
                return true;
            }
            return false;
        });
    }
    
    public int size() {
        return size;
    }
    
    public boolean containsKey(K key) {
        return get(key) != null;
    }
    
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        
        System.out.println("Size: " + map.size());
        System.out.println("Get 'two': " + map.get("two"));
        System.out.println("Contains 'three': " + map.containsKey("three"));
        
        map.remove("two");
        System.out.println("After removing 'two', size: " + map.size());
        System.out.println("Get 'two': " + map.get("two"));
        
        map.put("one", 100);
        System.out.println("Updated 'one': " + map.get("one"));
    }
}
