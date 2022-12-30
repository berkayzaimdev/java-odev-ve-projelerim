package com.example.proje.Hatalar;

public class SifreBosluk extends Exception
{
    public SifreBosluk()
    {
        super("Şifrede boşluk karakteri olamaz!");
    }
}
