package com.example.proje;

public abstract class IsHayati
{
    private String sektor,alan;
    private int calismayili;
    public IsHayati(String sektor,String alan,int calismayili)
    {
        this.sektor = sektor;
        this.alan=alan;
        this.calismayili=calismayili;
    }
    @Override
    public String toString()
    {
        return "Sektör:"+sektor+"\n"+"Çalışma Alanı:"+alan+"\n"+"Çalışma Yılı:"+calismayili;
    }
    public int getCalismayili() {
        return calismayili;
    }
    public String getSektor() {
        return sektor;
    }
}
