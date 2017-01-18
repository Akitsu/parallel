package Utils;

import main.Assignment2;

import java.util.concurrent.BlockingQueue;

public class StudentNumberConsumer implements Runnable{
    private int id;
    private BlockingQueue<int[]> queue;
    private int amount;
    private int jobsProcessed;


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
                jobsProcessed++;
                BucketSort.sort(studentNumberArray, amount);

                Assignment2.update(studentNumberArray);

                if (queue.isEmpty()) {
                    break;
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


}
