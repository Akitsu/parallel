package Utils;

import Model.Student;

import java.util.concurrent.BlockingQueue;

public class StudentNumberProducer implements Runnable{

    BlockingQueue<int[]> queue;
    int[] studentNumbers;

    public StudentNumberProducer(BlockingQueue<int[]> queue, int[] a) {
        this.studentNumbers = a;
        this.queue = queue;
    }

    @Override
    public void run() {
        int partSize = 100;
        int i = 0;
        int arrayIndex = 0;
        int amountParts = (int) Math.ceil(studentNumbers.length / partSize);

        while(i < amountParts) {
            try {
                int part[] = new int[partSize];

                System.arraycopy(studentNumbers, arrayIndex , part, 0 , part.length);
                for (int j = 0; j < part.length; j++) {
                    int s = part[j];
                }

                queue.put(part);

                i++;
                arrayIndex = arrayIndex + partSize;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
