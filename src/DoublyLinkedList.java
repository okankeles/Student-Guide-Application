public class DoublyLinkedList {
    public static class Node {
        private Node next;
        private Student stdnt;
        private Node prev;
        public Node(){
            next =null;
            prev =null;
            stdnt=null;
        }
        public Node(Student stdnt, Node prev, Node next){
            this.stdnt=stdnt;
            this.prev = prev;
            this.next = next;
        }
        public Node(Student stdnt){
            this.stdnt=stdnt;
        }
        public Node(Node original){
            this.stdnt=original.stdnt;
            this.next=original.next;
            this.prev =original.prev;
        }
    }
    private Node head;
    private Node tail;

    public void addStudent(Student student){
        //Method that takes a parameter of Student class type and adds it to the list sorted by student number.
        if(head==null){
            head=new Node(student);
            head.prev=null;
            return;
        }
        Node current=head;
        if(student.getOgrenciNo()<head.stdnt.getOgrenciNo()){
            Node temp=head;
            head=new Node(student);
            head.prev=null;
            head.next=temp;
            temp.prev =head;
            return;
        }
        while (current.next!=null&&student.getOgrenciNo()>current.stdnt.getOgrenciNo()){
            current=current.next;

        }
        if(current.next==null){
            current.next=new Node(student);
            tail=current.next;
            tail.prev=current;
        }
        else {
            Node temp = current.next;
            current.next=new Node(student);
            current.next.next=temp;
            current.next.prev=current;
            temp.prev=current.next;
        }

    }
    public void ogrenciBul(String adSoyad){
        //Method that searches for a student whose name and surname are given in the list
        //and prints the information of this student (if any, and other students with the same name and surname)
        Node current = head;
        while(current!=null){
            if(current.stdnt.getAdSoyad().equals(adSoyad)){
                System.out.println("No:"+current.stdnt.getOgrenciNo()+" Ad-Soyad:"+current.stdnt.getAdSoyad()+
                        " Tel No:"+current.stdnt.getTelNo());
            }
            current=current.next;
        }
        return;
    }
    public void ogrenciSil(int ogrenciNo){
        if(head==null){
            System.out.println("Kayıtlarda öğrenci yok!");
            return;
        }
        Node current = head;
        while (current!=null){
            if(current.stdnt.getOgrenciNo()==ogrenciNo){
                if(current==tail){
                    tail=current.prev;
                    tail.next=null;

                }
                else if(current==head){
                     head=head.next;
                     head.prev=null;

                }
                else{
                    current.prev.next=current.next;
                    current.next.prev=current.prev;

                }
            }
            else{
                System.out.println("Rehberde öğrenci bulunamadı!");
            }
            current=current.next;
        }
            return;
    }
    public void prnt(){
        if(head==null){
            System.out.println("Queue is empty!");
            return;
        }
        Node position=head;
        while(position!=null){
            System.out.print(position.stdnt.getOgrenciNo()+", "
                    +position.stdnt.getAdSoyad()+", "+ position.stdnt.getTelNo());
            System.out.println();
            position= position.next;
        }
    }
    public void reversePrnt(){
        if(head==null){
            System.out.println("There are no students in the records!");
            return;
        }
        Node current=tail;
        while (current!=null){
            System.out.print(current.stdnt.getOgrenciNo()+", "
                    +current.stdnt.getAdSoyad()+", "+ current.stdnt.getTelNo());
            System.out.println();
            current=current.prev;
        }


    }
    public int size(){
        int iterator=0;
        Node current=head;
        while (current!=null){
            current=current.next;
            iterator=iterator+1;
        }
        return iterator;
    }
}
