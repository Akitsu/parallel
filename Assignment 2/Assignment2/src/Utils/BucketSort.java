package Utils;

import Model.Student;

import java.util.*;

public class BucketSort{

    public static void sort(int[] a, int maxVal) {
        int [] bucket=new int[maxVal+1];

        for (int i=0; i<bucket.length; i++) {
            bucket[i]=0;
        }

        for (int i=0; i<a.length; i++) {
            bucket[a[i]]++;
        }

        int outPos=0;
        for (int i=0; i<bucket.length; i++) {
            for (int j=0; j<bucket[i]; j++) {
                a[outPos++]=i;
            }
        }
    }
    public static ArrayList<Integer> sortArrayList(ArrayList<Integer> a, int maxVal) {
        ArrayList<Integer> sortedArraylist = new ArrayList<>();
        int [] bucket=new int[maxVal+1];

        for (int i=0; i<bucket.length; i++) {
            bucket[i]=0;
        }

        for (int i=0; i<a.size(); i++) {
            bucket[a.get(i)]++;
        }

        for (int i=0; i<bucket.length; i++) {
            for (int j=0; j<bucket[i]; j++) {
                sortedArraylist.add(i);
            }
        }
        return sortedArraylist;

    }

}