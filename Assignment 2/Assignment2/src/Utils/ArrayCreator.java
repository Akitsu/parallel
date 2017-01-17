package Utils;

import java.util.ArrayList;

public class ArrayCreator {
    private ArrayList<Integer> arr;

    public ArrayCreator() {
    }

    public void addInt(int inte) {
        System.out.println(inte);
        arr.add(inte);

    }

    public ArrayList<Integer> getArr() {
        return arr;
    }
}
