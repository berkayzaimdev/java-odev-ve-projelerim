public abstract class Veri
{
    private String tur;
    private int boyut;
    Veri()
    {

    }
    Veri(String tur,int boyut)
    {
        this.tur=tur;
        this.boyut=boyut;
    }
    public abstract int boyutHesapla();

    public String getTur()
    {
        return tur;
    }

    public int getBoyut()
    {
        return boyut;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public void setBoyut(int boyut) {
        this.boyut = boyut;
    }
}
