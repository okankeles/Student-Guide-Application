public class Test {
    public static void main(String[] args) {
        DoublyLinkedList dl = new DoublyLinkedList();
        UserInterface.printMenu();
        int entry=UserInterface.entry();
        while(entry!=7){
            if(entry==1){
                UserInterface.readTxt(dl);
            }
            if(entry==2){
                dl.addStudent(UserInterface.getStudent());
                dl.prnt();
                entry=UserInterface.entry();
            }
            if(entry==3){
               String isim = UserInterface.isimAl();
               dl.ogrenciBul(isim);
               entry=UserInterface.entry();
            }
            if(entry==4){
                dl.ogrenciSil(UserInterface.numaraAl());
                entry=UserInterface.entry();
            }
            if(entry==5){
                dl.prnt();
                entry=UserInterface.entry();
            }
            if(entry==6){
                dl.reversePrnt();
                entry=UserInterface.entry();
            }
        }
    }
}
