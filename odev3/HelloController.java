package com.example.odev4;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField yazi;

    @FXML
    protected void onArtirButtonClick()
    {
        yazi.setText(String.valueOf(Integer.parseInt(yazi.getText())+1));
    }

    @FXML
    protected void onAzaltButtonClick()
    {
        yazi.setText(String.valueOf(Integer.parseInt(yazi.getText())-1));
    }

    @FXML
    protected void onSifirlaButtonClick()
    {
        yazi.setText("0");
    }
}