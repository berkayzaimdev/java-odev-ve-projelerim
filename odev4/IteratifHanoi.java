import java.util.Scanner;

public class IteratifHanoi
{
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        System.out.print("Kaç katlı hanoi kulesi hesaplamak istiyorsunuz?: ");
        int disksayisi = s.nextInt();
        Hanoi(disksayisi, 'A', 'B', 'C');
    }

    public static void Hanoi(int disksayisi, char baslangic, char hedef, char yardimci)
    {
        int toplamhamle = (int) (Math.pow(2, disksayisi)- 1);
        for (int i = 1; i <= toplamhamle; i++)
        {
            int hamle = (int) (i % 3);
            if (hamle == 1)
                yerDegistir(disksayisi, baslangic, hedef, yardimci);
            else if (hamle == 2)
                yerDegistir(disksayisi, baslangic, yardimci, hedef);
            else if (hamle == 0)
                yerDegistir(disksayisi, yardimci, hedef, baslangic);
        }
    }

    public static void yerDegistir(int disksayisi, char baslangic, char hedef, char yardimci)
    {
        if (disksayisi == 1)
        {
            System.out.println("Disk 1, "+baslangic+" konumundan " + hedef + " konumuna taşındı.");
            return;
        }
        yerDegistir(disksayisi - 1, baslangic, yardimci, hedef);
        System.out.println("Disk "+disksayisi+", " + baslangic + " konumundan " + hedef + " konumuna taşındı.");
        yerDegistir(disksayisi - 1, yardimci, hedef, baslangic);
    }
}
