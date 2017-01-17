package main;

import Model.Student;
import Utils.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.*;

public class Assignment2 {
    private static ArrayList<Integer> partlySorted = new ArrayList<>();


    public static void main(String[] args) throws InterruptedException {
        EventProfiler profiler = new EventProfiler(true);


        profiler.start();

        int amount = 10000;
        Generator g = new Generator();
        int[] students = g.generate(amount);

        profiler.log("Sorting Main bucket");
        ExecutorService executorService = Executors.newCachedThreadPool();
        BlockingQueue<int[]> queue = new ArrayBlockingQueue<int[]>(amount);

        StudentNumberProducer producer = new StudentNumberProducer(queue, students);
        StudentNumberConsumer consumer1 = new StudentNumberConsumer(1, queue, amount);
//        StudentNumberConsumer consumer2 = new StudentNumberConsumer(2, queue, amount);
//        StudentNumberConsumer consumer3 = new StudentNumberConsumer(3, queue, amount);

        executorService.submit(producer);

        executorService.submit(consumer1);
//        executorService.submit(consumer2);
//        executorService.submit(consumer3);

        profiler.log("done");


        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);



    }
    public static synchronized void update (int[] intArray){
        for (int i = 0; i < intArray.length; i++) {
            partlySorted.add(intArray[i]);
            System.out.println(i);
        }

    }



}