import java.util.ArrayList;

public class Metin extends Veri {
    private String tip, deger;
    private ArrayList<Hece> heceler;

    public Metin(String tip, String deger) {
        this.tip = tip;
        this.deger = deger;
        this.heceler = new ArrayList<Hece>();
        setBoyut(deger.length());
        setTur("metin");
    }

    @Override
    public int boyutHesapla() {
        return 0;
    }

    public String getTip() {
        return tip;
    }

    public String getDeger() {
        return deger;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public void setDeger(String deger) {
        this.deger = deger;
    }

    public void heceEkle(Hece he) {
        heceler.add(he);
        setDeger(donustur());
        System.out.print("Eklenen hece:" + he.getDeger());
        System.out.println(" Metnin son hali:" + getDeger());
        setBoyut(getBoyut() + he.getBoyut());
    }

    public void heceSil(Hece he) {
        heceler.remove(he);
        setDeger(donustur());
        System.out.print("Silinen hece:" + he.getDeger());
        System.out.println(" Metnin son hali:" + getDeger());
        setBoyut(getBoyut() - he.getBoyut());
    }

    public String donustur() {
        String sonuc = deger;
        for (Hece he : heceler) {
            sonuc += he.getDeger();
        }
        return sonuc;
    }
}
