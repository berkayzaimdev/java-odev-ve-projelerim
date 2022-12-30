public class Dikdortgen extends Sekil
{
    private int kisakenar,uzunkenar;

    public Dikdortgen(int kisakenar,int uzunkenar)
    {
        this.kisakenar=kisakenar;
        this.uzunkenar=uzunkenar;
    }

    @Override
    public double cevre()
    {
        return 2*(kisakenar+uzunkenar);
    }

    @Override
    public double alan()
    {
        return kisakenar*uzunkenar;
    }

}
