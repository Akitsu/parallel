package main;

import Model.Student;
import Utils.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.*;

public class Assignment2 {
    public static void main(String[] args) throws InterruptedException {
        EventProfiler profiler = new EventProfiler(true);
        profiler.start();
//
        int amount = 10000;
        Generator g = new Generator();
        int[] students = g.generate(amount);

        profiler.log("Sorting Main bucket");


        ExecutorService executorService = Executors.newCachedThreadPool();

        ArrayList<Integer> partlySortedArray = new ArrayList<Integer>();

        BlockingQueue<int[]> queue = new ArrayBlockingQueue<int[]>(amount);

        StudentNumberProducer producer = new StudentNumberProducer(queue, students);
        StudentNumberConsumer consumer1 = new StudentNumberConsumer(1, queue, partlySortedArray, amount);
//        StudentNumberConsumer consumer2 = new StudentNumberConsumer(1, queue, partlySortedArray, amount);

        for (int i = 0; i < partlySortedArray.size(); i++) {
            System.out.println(partlySortedArray.get(i));
        }
        executorService.submit(producer);

        executorService.submit(consumer1);
//        executorService.submit(consumer2);



        executorService.shutdown();
        System.out.println(partlySortedArray.size());
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }

}