package com.example.proje.Hatalar;

public class IsimHata extends Exception
{
    public IsimHata()
    {
        super("İsminizi yanlış bir formatta girdiniz!");
    }
}