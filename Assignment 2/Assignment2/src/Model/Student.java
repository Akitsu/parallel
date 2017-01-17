package Model;

/**
 * Created by Anthony on 17-Jan-17.
 */
public class Student {
    private int studentnummer;

    public Student(int studentnummer) {
        this.studentnummer = studentnummer;
    }

    public int getStudentnummer() {
        return studentnummer;
    }

    public void setStudentnummer(int studentnummer) {
        this.studentnummer = studentnummer;
    }
}
