package nptel.W8_L3_L4_ApplicationOfMap;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        HashMap<Double, Boolean> hashMap = new HashMap<>();


        map.put(1, "one");
        map.put(2, "two");
        hashMap.put(1D, true);
        hashMap.put(2D, false);
        hashMap.put(3D, false);
        System.out.println(map);
        System.out.println(hashMap);

        map.remove(1);
        map.remove(2, "one");
        map.replace(2, "two", "one");
        System.out.println(map);

        System.out.println("Is empty : " + map.isEmpty());
        System.out.println("Map contains value one : " + map.containsValue("one"));
        System.out.println("Map size : " + map.size());
        System.out.println("Value of key 3D in hashmap : " + hashMap.get(3D));

        System.out.println("For each loop using EntrySetMethod");
        for (Map.Entry<Double, Boolean> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }



        System.out.println("Only hashSet() : " + hashMap.entrySet());
        Set<Double> keySet = hashMap.keySet();
        System.out.println("keySet() : " + keySet);
        Iterator<Double> iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            System.out.println("Key: " + iterator.next() + " - value: " + hashMap.get(iterator.next()) );
        }
        System.out.println("values() : " + hashMap.values());


        // Bulk methods
        // clear()
        // putAll(mapObject)


        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>(10);         // Default is 16
        LinkedHashMap<Double, Boolean> linkedHashMap2 = new LinkedHashMap<>(10, 0.50f);     // Fill ration is 0.5 mins if the map has been filled with 10 elements it automatically updates the size from 10 to 15 (+5 as 10*0.5). The default ratio is 0.75
        LinkedHashMap<Double, Boolean> linkedHashMap3 = new LinkedHashMap<>(10, 0.50f,  true);   // 3rd arguments is for specifying the order true:order , false: FIFO

        enum SIZE {S, M, L, XL} // Not Synchronized but have High Performance than the HashMap
        EnumMap<SIZE, String> enumMap = new EnumMap<>(SIZE.class);
        enumMap.put(SIZE.S, "Kids");
        enumMap.put(SIZE.M, "Teenagers");
//        enumMap.put(SIZE.L, "Young");
        enumMap.put(SIZE.XL, "Old");
        for (SIZE size : SIZE.values()) {
            System.out.println(size + " : " + enumMap.get(size));
        }

        // Synchronized (Thread Safe) Map
        Map<Integer, String> map1 = Collections.synchronizedMap(new HashMap<>());
        synchronized (map1) {
            map1.put(1, "one");
            map1.put(2, "two");
            map1.put(3, "three");

        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        System.out.println(arrayList);
        HashMap<Integer, String> hashMap1 = new HashMap<>();
        Iterator<Integer> iterator1 = arrayList.iterator();
        while (iterator1.hasNext()) {
            hashMap1.put(iterator1.next(), null);
        }
        System.out.println(hashMap1);
    }
}
