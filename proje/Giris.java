package com.example.proje;
import javax.swing.*;
import java.awt.event.ActionListener;

public class Giris extends JFrame
{
    private JPanel panel;
    private JTextField kullaniciadi;
    private JPasswordField sifre;
    private JButton girisButton;
    private JButton Kayit;

    public Giris()
    {
        add(panel);
        setSize(400,400);
        setTitle("Giriş");
        girisButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                String username = kullaniciadi.getText();
                String password = new String(sifre.getPassword());
                if (username.equals("admin") && password.equals("123"))
                {
                    Admin a = new Admin();
                    a.setVisible(true);
                    setVisible(false);
                }
                else
                {
                    boolean giris = false;
                    for(Vatandas v : Vatandas.vatandaslar)
                    {
                        if(!giris&&username.equals(Long.toString(v.getTc()))&&password.equals(v.getSifre()))
                        {
                            v.setVisible(true);
                            setVisible(false);
                            giris=true;
                        }
                    }
                    if(!giris)
                        JOptionPane.showMessageDialog(panel, "Kullanıcı adı veya şifre yanlış.");
                }
            }
        });
        Kayit.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                Kayit k = new Kayit();
                k.setVisible(true);
                setVisible(false);
            }
        });
        //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
}
}
