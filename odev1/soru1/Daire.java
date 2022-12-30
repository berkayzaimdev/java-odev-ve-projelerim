public class Daire extends Sekil
{
    private int yaricap;
    public Daire(int yaricap)
    {
        this.yaricap=yaricap;
    }

    @Override
    public double cevre()
    {
        return Math.PI*2*yaricap;
    }

    @Override
    public double alan()
    {
        return Math.pow(yaricap,2)*Math.PI;
    }
}
