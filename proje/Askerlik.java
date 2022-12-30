package com.example.proje;

public class Askerlik
{
    private String cinsiyet;
    private int yas;
    private boolean yaptimi=false;
    private String durum;
    public Askerlik(boolean yaptimi)
    {
        this.yaptimi=yaptimi;
        if(yaptimi)
            durum="Askerliğinizi yaptınız.";
    }
    public Askerlik(String cinsiyet,int yas)
    {
        this.cinsiyet=cinsiyet;
        this.yas=yas;
        if(cinsiyet=="Kadın")
            durum="Askerlik yükümlülüğü yoktur.";
        else
        {
            if(yas<18)
                durum="Yaş("+yas+") 18 olmadığı için askerliğe elverişli değildir.";
            else if(yas>40)
                durum=yas+" yaşı, yaş haddinden dolayı askerliğe elverişli değildir.";
            else
                durum="Askerlik yükümlülüğünüz bulunmaktadır! Lütfen en yakındaki askerlik şubesine müracaat ediniz.";
        }
    }
    public String getDurum()
    {
        return durum;
    }

    public boolean isYaptimi() {
        return yaptimi;
    }
}
