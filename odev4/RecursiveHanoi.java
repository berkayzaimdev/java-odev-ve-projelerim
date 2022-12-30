import java.util.Scanner;

public class RecursiveHanoi
{
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        System.out.print("Kaç katlı hanoi kulesi hesaplamak istiyorsunuz?: ");
        int disksayisi = s.nextInt();
        hanoi(disksayisi,'A','B','C');
    }
    public static void hanoi(int disksayisi, char baslangic, char hedef, char yardimci) {
        if (disksayisi == 1)
        {
            System.out.println("Disk 1, çubuk " + baslangic + "'den çubuk " + hedef + "'e taşındı.");
            return;
        }
        hanoi(disksayisi-1, baslangic, yardimci, hedef);
        System.out.println("Disk " + disksayisi + ", çubuk " + baslangic + "'den çubuk " + hedef + "'e taşındı.");
        hanoi(disksayisi-1, yardimci, hedef, baslangic);
    }
}

