package Utils;

import Model.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class Generator {

    public static void shuffleArray(int[] ar) {
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    public ArrayList<Student> generateStudent(int amount) {
        ArrayList<Student> students = new ArrayList<Student>();
        int sn = 0;
        for(int i = 0; i < amount; i++) {
            students.add(new Student(sn));
            sn++;
        }

        Collections.shuffle(students);

        return students;
    }
    public int[] generate(int amount) {
        int[] students = new int[amount];

        for(int i = 0; i < amount; i++) {
            students[i] = i;
        }

        shuffleArray(students);

        return students;
    }

}


