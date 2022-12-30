
public class Main
{
    public static void main(String[] args)
    {
        Dikdortgen d1 = new Dikdortgen(5,10);
        System.out.println("Dikdortgenin cevresi:"+d1.cevre());
        System.out.println("Dikdortgenin cevresi:"+d1.alan());
        System.out.println("\n");

        Daire c1 = new Daire(5);
        System.out.println("Dairenin cevresi:"+c1.cevre());
        System.out.println("Dairenin alani:"+c1.alan());
        System.out.println("\n");

        EskenarUcgen e1 = new EskenarUcgen(5);
        System.out.println("Eskenar ucgenin cevresi:"+e1.cevre());
        System.out.println("Eskenar ucgenin alani:"+e1.alan());
        e1.yerDegistir(5,10);
    }
}
