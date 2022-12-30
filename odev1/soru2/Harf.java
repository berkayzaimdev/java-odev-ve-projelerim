public class Harf extends Metin
{
    static int boyut=1;

    public Harf(String tip,String deger)
    {
        super(tip,deger);
        setTur("harf");
    }

    @Override
    public String getTip() {
        return super.getTip();
    }

    @Override
    public String getDeger() {
        return super.getDeger();
    }

    @Override
    public int getBoyut()
    {
        return boyut;
    }
}
