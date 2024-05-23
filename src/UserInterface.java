import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class UserInterface {
    public static void printMenu(){
        System.out.println("-----Student Guide Application-----\n");
        System.out.println("Please enter the action you want to select as a number on the keyboard.\n");
        System.out.println("1) A doubly linked list is created in memory by reading from the text file named ogrenciler.txt.");
        System.out.println("2)The student whose all data has been entered from the keyboard is added to the appropriate position in the list,\n" +
                " sorted by student number.\n");
        System.out.println("The information of a student (if any, of all students with the same name and surname)\n" +
                " whose name and surname are entered on the keyboard is printed on the screen.\n");
        System.out.println("4)The student whose student number is entered will be deleted from the list.\n");
        System.out.println("5)All records in the list will be printed on the screen in ascending order\n" +
                " (from the smallest student number to the largest student number).\n");
        System.out.println("6)EXIT");
    }
    public static int entry(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers:");
        int entry= scanner.nextInt();
        return entry;
    }
    public static Student getStudent(){
        String adSoyad;
        int ogrenciNo;
        int telNo;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name-surname:");
        adSoyad=scanner.nextLine();
        System.out.println("Student number:");
        ogrenciNo=scanner.nextInt();
        Student student = new Student(ogrenciNo,adSoyad,getTellNo());
        return student;
    }
    public static String isimAl(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type the name of the student you want to call:");
        String adSoyad=scanner.nextLine();
        return adSoyad;
    }
    public static int numaraAl(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of the student you want to delete:");
        int numara=scanner.nextInt();
        return numara;
    }
    public static ArrayList<Integer> getTellNo(){
        ArrayList<Integer> telNo=new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);
        boolean another=true;
        while(another==true){
            System.out.println("Tel No:");
            int entry=scanner.nextInt();
            if(entry==0){
                break;
            }
            telNo.add(entry);
            System.out.println("If another phone number will be added, enter it. If not, press 0.");
        }
        return telNo;
    }
    public static void readTxt(DoublyLinkedList dl){
        File obj = new File("src/ogrenciler.txt");
        try {
            Scanner scanner=new Scanner(obj);
            scanner.useDelimiter("\\D");
            while (scanner.hasNextLine()){
                int ogrenciNo=scanner.nextInt();
                String adSoyad=scanner.next();
                ArrayList<Integer> arrayList = new ArrayList<Integer>();
                while(scanner.hasNextInt()){
                   arrayList.add(scanner.nextInt());
                }
                Student student = new Student(ogrenciNo,adSoyad,arrayList);
                dl.addStudent(student);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
