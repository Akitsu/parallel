package main;

import Utils.*;

import java.util.ArrayList;
import java.util.concurrent.*;

public class Assignment2 {
    private static ArrayList<Integer> partlySorted = new ArrayList<>();
    private static BlockingQueue<int[]> queue;
    private static int[] students;
    private static ExecutorService executorProducers;
    private static ExecutorService executorConsumers;
    private static int amount = 1000000;
    private static EventProfiler profiler;
    public static void main(String[] args) throws InterruptedException {

        profiler = new EventProfiler(true);
        ArrayList<Integer> sortedArraylist = new ArrayList<>();
        profiler.start();

        Generator g = new Generator();
        students = g.generate(amount);
        profiler.log("students generated");
//        BucketSort.sort(students,amount);
//        profiler.log("normal bucket sort");

        queue = new ArrayBlockingQueue<int[]>(amount);


        if (startServices()){
        sortedArraylist = BucketSort.sortArrayList(partlySorted,amount);
        }
//        for (int i = 0; i < sortedArraylist.size(); i++) {
//            System.out.println(sortedArraylist.get(i));
//        }
        profiler.log("done");


    }
    public static synchronized void update (int[] intArray){
        for (int i = 0; i < intArray.length; i++) {
            partlySorted.add(intArray[i]);
        }

    }
    public static  void startProducers(){
        executorProducers = Executors.newCachedThreadPool();
        StudentNumberProducer producer = new StudentNumberProducer(queue, students);
//        StudentNumberProducer producer1 = new StudentNumberProducer(queue, students);
        executorProducers.submit(producer);
//        executorProducers.submit(producer1);
        profiler.log("starting producer");

    }
    public static  void startConsumers(){
        executorConsumers = Executors.newCachedThreadPool();
        StudentNumberConsumer consumer = new StudentNumberConsumer(1, queue, amount);
        StudentNumberConsumer consumer1 = new StudentNumberConsumer(2, queue, amount);
        StudentNumberConsumer consumer2 = new StudentNumberConsumer(3, queue, amount);
        executorConsumers.submit(consumer);
        executorConsumers.submit(consumer1);
        executorConsumers.submit(consumer2);
        profiler.log("starting consumer");

    }
    private static boolean startServices(){
        startProducers();
        startConsumers();
        executorProducers.shutdown();
        executorConsumers.shutdown();
        try {
            executorProducers.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e){

        }
        profiler.log("producer is klaar");
        try {
            executorConsumers.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e){
            System.out.println("exceptionnn");
        }

        profiler.log("consumer is klaar");
        return true;
    }



}