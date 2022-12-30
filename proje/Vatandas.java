package com.example.proje;

import com.example.proje.Hatalar.SifreBosluk;
import com.example.proje.Hatalar.SifreHane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;

public class Vatandas extends JFrame
{
    static ArrayList<Vatandas> vatandaslar = new ArrayList<>();
    private long tc;
    private String sifre,ad,soyad,dtarihi,cinsiyet;
    private int yas;
    private Askerlik askerlik;
    private IsHayati ishayati;
    private JPanel wrapper;
    private JLabel hosgeldiniz;
    private JButton askerlikButton;
    private JButton emeklilikButton;
    private JButton cikisButton;
    private JButton sifreButton;
    private JPanel sifredegistir;
    private JPasswordField sifre1;
    private JPasswordField sifre2;
    private JButton sifreDegistir;

    public Vatandas(long tc,String sifre,String ad,String soyad,String dtarihi,String cinsiyet)
    {
        add(wrapper);
        sifredegistir.setVisible(false);
        setSize(350, 350);
        setTitle("Vatandaş");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.tc=tc;
        this.sifre=sifre;
        this.ad=ad;
        this.soyad=soyad;
        this.cinsiyet=cinsiyet;
        this.dtarihi=dtarihi;
        LocalDate dob = LocalDate.parse(dtarihi);
        this.yas=calculateAge(dob);
        this.askerlik=new Askerlik(cinsiyet,yas);
        hosgeldiniz.setText("Hoşgeldiniz "+ad+" "+soyad);
        askerlikButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                JOptionPane.showMessageDialog(null, askerlik.getDurum());
            }
        });
        emeklilikButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                String mesaj;
                if(ishayati==null)
                {
                    mesaj="İş hayatı bilgisi girilmedi.";
                }
                else if(yas<60)
                {
                    int yil;
                    mesaj="\nEmekliliğinize kalan yıl:";
                    if(ishayati.getSektor()=="Kamu Sektörü")
                    {
                        if(cinsiyet=="Kadın")
                            yil=50-yas;
                        else
                            yil=55-yas;
                    }
                    else
                    {
                        if(cinsiyet=="Kadın")
                            yil=55-yas;
                        else
                            yil=60-yas;
                    }
                    mesaj+=Integer.toString(yil);
                    if(yil<0)
                        mesaj=ishayati.toString()+"\nEmekliliğe hakkınız bulunuyor.";
                    else
                        mesaj=ishayati.toString()+mesaj;
                }
                else
                    mesaj=ishayati.toString()+"\nEmekliliğe hakkınız bulunuyor.";
                JOptionPane.showMessageDialog(null, mesaj);
            }
        });
        cikisButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                setVisible(false);
                new Giris().setVisible(true);
            }
        });
        sifreButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                if(sifredegistir.isVisible()==false)
                    sifredegistir.setVisible(true);
                else
                    sifredegistir.setVisible(false);
            }
        });
        sifreDegistir.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ArrayList<Exception> hatalar = new ArrayList<>();
                String tempsifre = "";
                boolean boslukmu=true;
                char[] sifre1=null;
                char[] sifre2=null;
                for(Component p :sifredegistir.getComponents())
                {
                    if (p instanceof JPasswordField)
                    {
                        JPasswordField sifrealani = (JPasswordField) p;
                        if (sifre1 == null)
                            sifre1 = sifrealani.getPassword();
                        else if (sifre2 == null)
                            sifre2 = sifrealani.getPassword();
                    }
                }
                if(getSifre().equals(String.valueOf(sifre1)))
                    hatalar.add(new Exception("Yeni şifre eskisiyle aynı olamaz!"));
                if(!Arrays.equals(sifre1,sifre2))
                    hatalar.add(new Exception("Şifreler birbiriyle uyuşmuyor!"));
                for (char x : sifre1)
                {
                    if (x == ' ' && boslukmu)
                    {
                        hatalar.add(new SifreBosluk());
                        boslukmu=false;
                    }
                    else
                        tempsifre += x;
                }
                if (tempsifre.length() < 8)
                    hatalar.add(new SifreHane());
                if (hatalar.size() > 0)
                {
                    String mesaj = "";
                    for (Exception h : hatalar)
                        mesaj += h.getMessage() + "\n";
                    JOptionPane.showMessageDialog(wrapper, mesaj);
                }
                else
                {
                    setSifre(String.valueOf(sifre1));
                    JOptionPane.showMessageDialog(wrapper, "Şifre başarıyla değiştirildi!");
                }
            }
        });
    }
    public static int calculateAge(LocalDate dob)
    {
        LocalDate curDate = LocalDate.now();
        if ((dob != null) && (curDate != null))
        {
            return Period.between(dob, curDate).getYears();
        }
        else
        {
            return 0;
        }
    }
    public long getTc() {
        return tc;
    }
    public String getSifre()
    {
        return sifre;
    }

    public String getAd()
    {
        return ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }
    public int getYas() {
        return yas;
    }

    public Askerlik getAskerlik()
    {
        return askerlik;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public void setIshayati(IsHayati ishayati)
    {
        this.ishayati = ishayati;
    }
    public void setAskerlik(Askerlik askerlik) {
        this.askerlik = askerlik;
    }
}
