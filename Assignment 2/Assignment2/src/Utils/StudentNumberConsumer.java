package Utils;

import main.Assignment2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class StudentNumberConsumer implements Runnable{
    private int id;
    private BlockingQueue<int[]> queue;
    private int amount;


    public StudentNumberConsumer(int id, BlockingQueue<int[]> queue, int amount) {
        this.id = id;
        this.queue = queue;
        this.amount = amount;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int[] studentNumberArray = queue.take();
                BucketSort.sort(studentNumberArray, amount);

                Assignment2.update(studentNumberArray);


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
