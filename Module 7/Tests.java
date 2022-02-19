public class Tests {
    public static void main(String args[]) {
        ExternalChainingHashMap<Integer, Integer> testMap = constructEmptyMap();
        // Tests two puts of different K, V
        System.out.println("adding <5, 5>");
        testMap.put(5, 5);
        printSize(testMap);
        System.out.println();
        System.out.println("adding <6, 5>");
        testMap.put(6, 5);
        printBackingArray(testMap.getTable());
        printSize(testMap);

        // Tests for updating existing key.
        System.out.println("adding <5, 9>. Should return 5!");
        System.out.println(5 == testMap.put(5, 9));
        printBackingArray(testMap.getTable());
        printSize(testMap);

        // Tests for removing existing key
        System.out.println("removing <6, 5>");
        System.out.println(5 == testMap.remove(6));
        printBackingArray(testMap.getTable());
        printSize(testMap);

        // Begins tests for handling resize:
        System.out.println("\n\nNew table nearly full to test resize...");
        testMap = constructMapOfSize12();
        printSize(testMap);
        printBackingArray(testMap.getTable());
        System.out.println("Adding element");
        testMap.put(12, 12);
        printBackingArray(testMap.getTable());
        printSize(testMap);
        System.out.println("triggering resize by adding element!");
        testMap.put(13, 13);
        printBackingArray(testMap.getTable());
        printSize(testMap);

        // Tests for removing key not in the table
        System.out.println("removing key 7 (not in table!)");
        System.out.println(testMap.remove(7));
        printBackingArray(testMap.getTable());
    }
    public static ExternalChainingHashMap<Integer, Integer> constructEmptyMap() {
        return new ExternalChainingHashMap<>();
    }

    public static void printBackingArray(ExternalChainingMapEntry<Integer, Integer>[] table) {
        String res = "";
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                res = res.concat("_ ");
            } else {
                res = res.concat(table[i].toString() + " ");
                ExternalChainingMapEntry<Integer, Integer> curr = table[i];
                while (curr.getNext() != null) {
                    res = res.concat("=> " + curr.getNext().toString());
                    curr = curr.getNext();
                    if (curr.getNext() == null) {
                        res = res.concat("END OF EXT CHAIN ");
                    }
                }
            }
        }
        System.out.println("Current map: " + res + "\nCapacity: " + table.length);
    }

    public static void printSize(ExternalChainingHashMap<Integer, Integer> testMap) {
        System.out.println("Size: " + testMap.size());
    }

    public static ExternalChainingHashMap<Integer, Integer> constructMapOfSize12() {
        ExternalChainingHashMap<Integer, Integer> newMap = new ExternalChainingHashMap<>();
        for (int i = 0; i < 7; i++) {
            newMap.put(i, i);
        }
        return newMap;
    }
}
