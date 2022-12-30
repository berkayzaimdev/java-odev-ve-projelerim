import java.util.ArrayList;

public class Hece extends Metin
{
    private ArrayList<Harf> harfler;
    public Hece(String tip,String deger)
    {
        super(tip,deger);
        this.harfler=new ArrayList<Harf>();
        char[] temp=deger.toCharArray();
        for(int i=0;i<temp.length;i++)
        {
            harfler.add(new Harf("harf",String.valueOf(temp[i])));
        }
        setBoyut(temp.length);
        setTur("hece");
    }
    public void harfEkle(Harf h)
    {
        harfler.add(h);
        super.setDeger(donustur());
        System.out.print("Eklenen harf:"+h.getDeger());
        System.out.println("  Hecenin son hali:"+super.getDeger());
        setBoyut(getBoyut()+1);
    }
    public void harfSil(Harf h)
    {
        harfler.remove(h);
        super.setDeger(donustur());
        System.out.print("Silinen harf:"+h.getDeger());
        System.out.println("  Hecenin son hali:"+super.getDeger());
        setBoyut(getBoyut()-1);
    }

    public String donustur()
    {
        String sonuc="";
        for(Harf h: harfler)
        {
            sonuc+= h.getDeger();
        }
        return sonuc;
    }

    @Override
    public String getTip() {
        return super.getTip();
    }

    @Override
    public String getDeger() {
        return super.getDeger();
    }
}
