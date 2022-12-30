public class EskenarUcgen extends Sekil implements Hareketli
{
    private int kenar;
    private double yukseklik;
    //yükseklik değeri irrasyonel sayı ile çarpım halinde olduğu için INT olamaz.
    private int posX,posY;

    public EskenarUcgen(int kenar)
    {
        this.kenar=kenar;
        yukseklik=Math.sqrt(3)*(this.kenar/2.0);
    }

    @Override
    public double cevre()
    {
        return 3*kenar;
    }

    @Override
    public double alan()
    {
        return (kenar*yukseklik)/2;
    }

    @Override
    public void yerDegistir(int posX,int posY)
    {
        this.posX=posX;
        this.posY=posY;
        System.out.println("X ekseninde "+posX+"br, Y ekseninde "+posY+"br yer değiştirildi.");
    }
}
