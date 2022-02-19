public class Tests {
    public static void main(String args[]) {
        ExternalChainingHashMap<Integer, Integer> testMap = constructEmptyMap();
        System.out.println("adding <5, 5>");
        testMap.put(5, 5);
        System.out.println("adding <6, 5>");
        testMap.put(6, 5);
        System.out.println("adding <5, 9>. Should return 5!");
        
    }
    public static ExternalChainingHashMap<Integer, Integer> constructEmptyMap() {
        return new ExternalChainingHashMap<>();
    }
}
