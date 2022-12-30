package odev;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

/*
Programın özellikleri:
1- Top W'ya basınca hızlanıyor, S'ye basınca yavaşlıyor. (Hızı sıfır olmuyor)
2- Eksenlerde gerçekleşen çarpışma sayısını Label'larda tutuyor
3- Renk değişimini rastgele sayılarla yapıyor ve renk değişim sayısını Label'da tutuyor
4- Y eksenindeki çarpışma sayısı her 50'nin katı olduğunda Scene ve Label renkleri zıt hale geliyor
(Chrome'daki dinozor oyununa benzemesini istedim)
(Background rengini ayarlayamadım ancak Label'ların rengi animatik bir şekilde değişebiliyor)
*/

public class ZiplayanTop extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        TopPanel tp = new TopPanel();
        tp.setOnKeyPressed(e ->
        {
            if (e.getCode() == KeyCode.W)
                tp.hizlan();
            else if (e.getCode() == KeyCode.S)
                tp.yavasla();
        });
        Scene scene = new Scene(tp,300,200);
        primaryStage.setTitle("Zıplayan Top");
        primaryStage.setScene(scene);
        primaryStage.show();
        tp.requestFocus();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
