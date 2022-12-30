public class Goruntu extends Veri implements Kucultulebilir
{
    private double kisaKenar,uzunKenar;
    private String renk;
    public Goruntu(double kisaKenar,double uzunKenar,String renk)
    {
        super("Goruntu",0);
        this.kisaKenar=kisaKenar;
        this.uzunKenar=uzunKenar;
        this.renk=renk;
    }

    @Override
    public int boyutHesapla()
    {
        int boyut = alan()*cevre()*10;
        setBoyut(boyut);
        return boyut;
    }

    public double boyutAzalt()
    {
        setBoyut(getBoyut()*75/100);
        System.out.println("Boyut azaltılmıştır.");
        return getBoyut();
    }
    public int alan()
    {
       return (int)(kisaKenar*uzunKenar);
    }
    public int cevre()
    {
        return (int)(2*(kisaKenar+uzunKenar));
    }

    public String getRenk() {
        return renk;
    }

    public double getKisaKenar() {
        return kisaKenar;
    }

    public double getUzunKenar() {
        return uzunKenar;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }

    public void setKisaKenar(double kisaKenar) {
        this.kisaKenar = kisaKenar;
    }

    public void setUzunKenar(double uzunKenar) {
        this.uzunKenar = uzunKenar;
    }
}
