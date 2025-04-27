package Array;

public class Hash {

    private Element[] table;

    private boolean[] deleted;

    private int N;

    public Hash(int N){
        table = new Element[N];
        deleted = new boolean[N];
        this.N = N;
    }

    private int hashFunction(int value){
        return value % N;
    }

    public Element search(int value){
        int address;
        address = hashFunction(value);
        while (table[address] != null){
            if (!deleted[address] && table[address].getData() == value){
                break;
            }
            address = (address + 1) % N;
        }
        return table[address];
    }
    public void insert(int value){
        int address;
        address = hashFunction(value);
        while (table[address] != null && !deleted[address]){
            address = (address + 1) % N;
        }
        if (table[address] != null){
            deleted[address] = false;
        }
        table[address] = new Element(value);
    }

    int[] union(int[] list1, int[] list2) {
        int tableSize = list1.length + list2.length;
        List.Hash seen = new List.Hash(tableSize);

        int count = 0;

        for (int num : list1) {
            seen.insert(num);
            count++;
        }
        for (int num : list2) {
            if (seen.search(num) == null) {
                count++;
            }
        }

        int[] result = new int[count];
        int index = 0;

        for (int num : list1) {
            result[index++] = num;
        }
        for (int num : list2) {
            if (seen.search(num) == null) {
                result[index++] = num;
            }
        }

        return result;
    }

}
