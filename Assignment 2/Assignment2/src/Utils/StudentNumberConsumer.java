package Utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class StudentNumberConsumer implements Runnable{
    private int id;
    private BlockingQueue<int[]> queue;
    private ArrayList<Integer> sortedArray;
    private int amount;
    private ArrayCreator ac = new ArrayCreator();

    public StudentNumberConsumer(int id, BlockingQueue<int[]> queue, ArrayList<Integer> sortedArray, int amount) {
        this.id = id;
        this.queue = queue;
        this.sortedArray = sortedArray;
        this.amount = amount;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int[] studentNumberArray = queue.take();
                BucketSort.sort(studentNumberArray, amount);
                addToArray(studentNumberArray);
//                for (int i = 0; i < studentNumberArray.length; i++) {
//                    System.out.println(i + " = " + studentNumberArray[i]);
//                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void addToArray(int[] a) {

        System.out.println("sgfsdgw");
        for (int i = 0; i < a.length; i++) {
            System.out.println("gwgwe");
            ac.addInt(a[i]);
        }
    }

}
