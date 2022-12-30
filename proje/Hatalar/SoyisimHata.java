package com.example.proje.Hatalar;

public class SoyisimHata extends Exception
{
    public SoyisimHata()
    {
        super("Soyisminizi yanlış bir formatta girdiniz!");
    }
}