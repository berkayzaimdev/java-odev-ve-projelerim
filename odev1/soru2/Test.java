public class Test
{
    public static void main(String[] args)
    {
        Harf v = new Harf("sessiz","v");
        Harf e = new Harf("sesli","e");
        Harf r = new Harf("sessiz","r");
        Harf s = new Harf("sessiz","s");
        Harf i = new Harf("sesli","i");
        Harf t = new Harf("sessiz","t");
        Hece h1 = new Hece("yapım eki","Univers");
        Metin m1 = new Metin("cumle","Marmara");
        h1.harfEkle(i);
        h1.harfEkle(t);
        h1.harfEkle(e);
        h1.harfEkle(s);
        h1.harfEkle(i);
        h1.harfSil(i);
        System.out.println(m1.getDeger());
        m1.heceEkle(h1);
        System.out.println(m1.getBoyut());
        System.out.println(m1.getTur()+"\n\n");

        Goruntu g1 = new Goruntu(40.75,45.25,"Mavi");
        System.out.println(g1.getRenk());
        g1.boyutHesapla();
        System.out.println(g1.getBoyut());
        g1.boyutAzalt();
        System.out.println(g1.getBoyut());
    }
}