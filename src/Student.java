import java.util.ArrayList;
public class Student {
    private int ogrenciNo;
    private String adSoyad;
    //private ArrayList<String> telNo = new ArrayList<String>();
    private ArrayList<Integer> telNo=new ArrayList<Integer>();
    public Student(){
        ogrenciNo=0;
        adSoyad="";
        telNo=null;
    }
    public Student(int ogrenciNo,String adSoyad, ArrayList<Integer> telNo){
        this.ogrenciNo=ogrenciNo;
        this.adSoyad=adSoyad;
        this.telNo=telNo;
    }

    public int getOgrenciNo() {
        return ogrenciNo;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public ArrayList<Integer> getTelNo() {
        return telNo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ogrenciNo=" + ogrenciNo +
                ", adSoyad='" + adSoyad + '\'' +
                ", telNo=" + telNo +
                '}';
    }
}
