package com.example.proje;
import static com.example.proje.Vatandas.vatandaslar;

import javax.swing.*;

public class Test
{
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        vatandaslar.add(new Vatandas(11111111111L,"11111111","Ahmet","Yılmaz","1992-11-04","Erkek"));
        vatandaslar.add(new Vatandas(12345678910L,"11111111","Ayşe","Çelik","1982-04-13","Kadın"));
        vatandaslar.add(new Vatandas(45678901234L,"11111111","Mehmet","Kaya","1948-09-25","Erkek"));
        vatandaslar.add(new Vatandas(56789012345L,"11111111","Kaan","Güler","2008-05-21","Erkek"));
        vatandaslar.add(new Vatandas(67890123456L,"11111111","Zeynep","Çetin","2005-01-05","Kadın"));
        vatandaslar.add(new Vatandas(78901234567L,"11111111","İbrahim","Öztürk","1983-09-25","Erkek"));
        vatandaslar.add(new Vatandas(89012345678L,"11111111","Fatih","Arslan","1980-09-25","Erkek"));
        vatandaslar.add(new Vatandas(23456789012L,"11111111","Hüseyin","Gül","2003-10-18","Erkek"));
        vatandaslar.add(new Vatandas(34567890123L,"11111111","Fatma","Demir","1950-07-01","Kadın"));
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                Giris g = new Giris();
                g.setVisible(true);
            }
        });
    }
}
//Puanlama için bakılacak kriterler:
//1.   Proje Dokümanı
//6.   Arraylist nesne saklama-ekleme- silme
//10.  Overloding
//13.  Interface
//14.  Polymorphism