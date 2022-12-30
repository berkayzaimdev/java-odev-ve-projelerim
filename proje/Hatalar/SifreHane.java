package com.example.proje.Hatalar;

public class SifreHane extends Exception
{
    public SifreHane()
    {
        super("Şifreniz en az 8 haneli olmalıdır!");
    }
}
