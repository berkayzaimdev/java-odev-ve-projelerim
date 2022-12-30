package com.example.proje;
import com.example.proje.Hatalar.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static com.example.proje.Vatandas.vatandaslar;

public class Kayit extends JFrame
{
    private JPanel kayitPanel;
    private JTextField tc;
    private JPasswordField sifre;
    private JTextField isim;
    private JTextField soyisim;
    private JTextField dtarihi;
    private JRadioButton erkekRadioButton;
    private JRadioButton kadınRadioButton;
    private JButton kayit;
    private JButton cikisButton;

    public Kayit()
    {
        add(kayitPanel);
        setSize(550,550);
        setTitle("Kayıt Ol");
        kayit.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                ArrayList<Exception> hatalar = new ArrayList<>();
                long temptc=0;
                try
                {
                    temptc = Long.parseLong(tc.getText());
                    for(Vatandas v : vatandaslar)
                    {
                        if(v.getTc()==temptc)
                            hatalar.add(new TcOzdes());
                    }
                    if (temptc >= Math.pow(10, 11) || temptc < Math.pow(10, 10))
                        hatalar.add(new TcHane());
                }
                catch (NumberFormatException h)
                {
                    hatalar.add(new NumberFormatException("TC kimlik numarası rakamlardan oluşmalıdır."));
                }
                String tempsifre = "";
                boolean boslukmu=true;
                for (char x : sifre.getPassword())
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

                String tempisim = isim.getText();
                if (!tempisim.matches("[a-zA-Z]*"))
                    hatalar.add(new IsimHata());

                String tempsoyisim = soyisim.getText();
                if (!tempsoyisim.matches("[a-zA-Z]*"))
                    hatalar.add(new SoyisimHata());

                String tempdtarihi = dtarihi.getText();

                String tempcinsiyet=" ";
                if(erkekRadioButton.isSelected())
                    tempcinsiyet="Erkek";
                else if(kadınRadioButton.isSelected())
                    tempcinsiyet="Kadın";
                else
                    hatalar.add(new CinsiyetSec());

                if (hatalar.size() > 0)
                {
                    String mesaj = "";
                    for (Exception h : hatalar)
                        mesaj += h.getMessage() + "\n";
                    JOptionPane.showMessageDialog(kayitPanel, mesaj);
                }
                else
                {
                    vatandaslar.add(new Vatandas(temptc,tempsifre,tempisim,tempsoyisim,tempdtarihi,tempcinsiyet));
                    JOptionPane.showMessageDialog(kayitPanel, "Kayıt Başarılı!");
                }
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
    }
}
