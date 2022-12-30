package com.example.proje;

import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Admin extends JFrame
{
    ArrayList<Vatandas> vatandaslar = Vatandas.vatandaslar;
    private JPanel adminPanel;
    private JButton listele;
    private JButton adButton;
    private JButton ihButton;
    private JButton cikisButton;
    private JButton adg;
    private JPanel ad;
    private JPanel ih;
    private JButton ihg;
    private JComboBox sektor;
    private JTextField yil;
    private JTextField alan;
    private JTable isvatandas;
    private JTable askerlikvatandas;
    private JPanel panel2;

    public Admin()
    {
        add(adminPanel);
        ad.setVisible(false);
        ih.setVisible(false);
        setSize(550,550);
        setTitle("Admin");
        listele.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Object data[][] = new Object[vatandaslar.size()][5];
                JPanel pvatandaslistesi = new JPanel();
                String[] columnNames = {"TC Kimlik Numarası", "İsim", "Soyisim", "Yaş", "Cinsiyet"};
                for(int i = 0; i < vatandaslar.size(); i++){
                    data[i][0] = vatandaslar.get(i).getTc();
                    data[i][1] = vatandaslar.get(i).getAd();
                    data[i][2] = vatandaslar.get(i).getSoyad();
                    data[i][3] = vatandaslar.get(i).getYas();
                    data[i][4] = vatandaslar.get(i).getCinsiyet();
                }
                JTable tvatandaslistesi = new JTable(data, columnNames);
                tvatandaslistesi.setVisible(true);
                JScrollPane scvatandaslistesi = new JScrollPane(tvatandaslistesi);
                scvatandaslistesi.setVisible(true);
                pvatandaslistesi.add(scvatandaslistesi);
                pvatandaslistesi.setVisible(true);
                JOptionPane.showMessageDialog(null, pvatandaslistesi);
            }
        });
        adButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                if(ad.isVisible()==false)
                {
                    ad.setVisible(true);
                    int c=0;
                    Object sutunt[][] = new Object[vatandaslar.size()][4];
                    String[] columnNames = {"TC Kimlik Numarası", "İsim", "Soyisim", "Yaş"};
                    for(Vatandas v : vatandaslar)
                    {
                        if(v.getYas()>18 && v.getYas()<40 && !v.getAskerlik().isYaptimi())
                        {
                            sutunt[c][0] = v.getTc();
                            sutunt[c][1] = v.getAd();
                            sutunt[c][2] = v.getSoyad();
                            sutunt[c][3] = v.getYas();
                            c++;
                        }
                    }
                    Object sutun[][] = new Object[c+1][4];
                    sutun[0][0]="TC Kimlik";
                    sutun[0][1]="İsim";
                    sutun[0][2]="Soyisim";
                    sutun[0][3]="Yaş";
                    for(int i=1;i<c+1;i++)
                        sutun[i]=sutunt[i-1];
                    DefaultTableModel dtm = new DefaultTableModel(sutun,columnNames);
                    askerlikvatandas.setModel(dtm);
                }
                else
                    ad.setVisible(false);
            }
        });
        adg.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                if(askerlikvatandas.getSelectedRow()<1)
                    JOptionPane.showMessageDialog(adminPanel, "Lütfen önce vatandaş seçiniz!");
                else
                {
                    Object t = askerlikvatandas.getValueAt(askerlikvatandas.getSelectedRow(),0);
                    for(Vatandas v : vatandaslar)
                    {
                        if((long) t==v.getTc())
                        {
                            v.setAskerlik(new Askerlik(true));
                            JOptionPane.showMessageDialog(adminPanel, "Güncelleme Başarılı!");
                            ad.setVisible(false);
                        }
                    }
                }
            }
        });
        ihButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                if(ih.isVisible()==false)
                {
                    ih.setVisible(true);
                    int c=0;
                    Object sutunt[][] = new Object[vatandaslar.size()][5];
                    String[] columnNames = {"TC Kimlik Numarası", "İsim", "Soyisim", "Yaş", "Cinsiyet"};
                    for(Vatandas v : vatandaslar)
                    {
                        if(v.getYas()>18)
                        {
                            sutunt[c][0] = v.getTc();
                            sutunt[c][1] = v.getAd();
                            sutunt[c][2] = v.getSoyad();
                            sutunt[c][3] = v.getYas();
                            sutunt[c][4] = v.getCinsiyet();
                            c++;
                        }
                    }
                    Object sutun[][] = new Object[c+1][5];
                    sutun[0][0]="TC Kimlik No";
                    sutun[0][1]="İsim";
                    sutun[0][2]="Soyisim";
                    sutun[0][3]="Yaş";
                    sutun[0][4]="Cinsiyet";
                    for(int i=1;i<c+1;i++)
                        sutun[i]=sutunt[i-1];
                    DefaultTableModel dtm = new DefaultTableModel(sutun,columnNames);
                    isvatandas.setModel(dtm);
                }
                else
                    ih.setVisible(false);
            }
        });
        ihg.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                ArrayList<Exception> hatalar = new ArrayList<>();
                if(isvatandas.getSelectedRow()<1)
                    hatalar.add(new Exception("Lütfen vatandaş seçiniz!"));
                if(sektor.getSelectedIndex()==0)
                    hatalar.add(new Exception("Lütfen sektör seçiniz!"));
                if(alan.getText().length()==0)
                    hatalar.add(new Exception("Lütfen alan bilgisi giriniz!"));
                if(yil.getText().length()==0)
                    hatalar.add(new Exception("Lütfen çalışma yılı bilgisi giriniz!"));
                if(hatalar.size()>0)
                {
                    String mesaj = "";
                    for (Exception h : hatalar)
                        mesaj += h.getMessage() + "\n";
                    JOptionPane.showMessageDialog(adminPanel, mesaj);
                }
                else
                {
                    Object t = isvatandas.getValueAt(isvatandas.getSelectedRow(),0);
                    for(Vatandas v : vatandaslar)
                    {
                        if((long) t==v.getTc())
                        {
                            if(v.getYas()-18<Integer.parseInt(yil.getText()))
                            {
                                JOptionPane.showMessageDialog(adminPanel, "Lütfen geçerli bir çalışma yılı giriniz!");
                            }
                            else
                            {
                                if(sektor.getSelectedItem().toString()=="Özel Sektör")
                                    //v.setIshayati(new IsHayati("deneme",11));
                                    v.setIshayati(new Ozel(alan.getText(),Integer.parseInt(yil.getText())));
                                else if(sektor.getSelectedItem().toString()=="Kamu Sektörü")
                                    //v.setIshayati(new IsHayati("deneme",11));
                                    v.setIshayati(new Kamu(alan.getText(),Integer.parseInt(yil.getText())));
                                JOptionPane.showMessageDialog(adminPanel, "Güncelleme Başarılı!");
                                ad.setVisible(false);
                            }
                        }
                    }
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
