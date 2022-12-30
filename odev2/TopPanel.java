package odev;
import javafx.animation.KeyValue;
import javafx.scene.text.Font;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.Label;
import javafx.util.Duration;
import java.util.Random;


public class TopPanel extends Pane {
    public double yaricap=30;
    private double x=yaricap,y=yaricap;
    private double katx=1,katy=1;
    private Circle top = new Circle(x,y,yaricap);
    private Timeline animasyon;
    private int cx=0,cy=0,cr=0;
    private Label colx = new Label("X eksenindeki çarpışma sayısı:"+cx);
    private Label coly= new Label("Y eksenindeki çarpışma sayısı:"+cy);
    private Label renk= new Label("Topun renk değiştirme sayısı:"+cr);

    public TopPanel()
    {
        top.setFill(Color.GREEN);
        getChildren().add(top);

        colx.setTranslateY(150);
        coly.setTranslateY(165);
        renk.setTranslateY(180);

        colx.setFont(Font.font("Verdana"));
        coly.setFont(Font.font("Verdana"));
        renk.setFont(Font.font("Verdana"));

        getChildren().add(colx);
        getChildren().add(coly);
        getChildren().add(renk);

        animasyon = new Timeline(new KeyFrame(Duration.millis(50), e -> hareket()));
        animasyon.setCycleCount(Timeline.INDEFINITE);
        animasyon.play();
    }

    public void renkdegis()
    {
        Random r = new Random();
        top.setFill(Color.rgb(r.nextInt(256),r.nextInt(256),r.nextInt(256)));
        renk.setText("Topun renk değiştirme sayısı:"+(++cr));
    }

    public void hizlan()
    {
        animasyon.setRate(animasyon.getRate() + 0.5);
    }

    public void yavasla()
    {
        if(animasyon.getRate()>0.5)
            animasyon.setRate(animasyon.getRate()-0.5);
        else
            animasyon.setRate(0.1);
    }

    protected void hareket()
    {
        top.setOnMouseClicked(e -> renkdegis());
        if (x < yaricap || x > getWidth() - yaricap)
        {
            katx *= -1;
            colx.setText("X eksenindeki çarpışma sayısı:"+(++cx));
        }
        if (y < yaricap || y > getHeight() - yaricap)
        {
            katy *= -1;
            coly.setText("Y eksenindeki çarpışma sayısı:"+(++cy));
        }
        x += katx;
        y += katy;
        top.setCenterX(x);
        top.setCenterY(y);
        if(cy>0&&cy%100==0)
        {
            setStyle("-fx-background-color: white;transition:all 5s ");
            Timeline tlx = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(colx.textFillProperty(), Color.WHITE)),
                    new KeyFrame(Duration.millis(500), new KeyValue(colx.textFillProperty(), Color.BLACK))
            );
            Timeline tly = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(coly.textFillProperty(), Color.WHITE)),
                    new KeyFrame(Duration.millis(500), new KeyValue(coly.textFillProperty(), Color.BLACK))
            );
            Timeline tlr = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(renk.textFillProperty(), Color.WHITE)),
                    new KeyFrame(Duration.millis(500), new KeyValue(renk.textFillProperty(), Color.BLACK))
            );
            tlx.play();
            tly.play();
            tlr.play();
        }
        else if(cy>0&&cy%50==0)
        {
            setStyle("-fx-background-color:black;transition:all 5s");
            Timeline tlx = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(colx.textFillProperty(), Color.BLACK)),
                    new KeyFrame(Duration.millis(500), new KeyValue(colx.textFillProperty(), Color.WHITE))
            );
            Timeline tly = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(coly.textFillProperty(), Color.BLACK)),
                    new KeyFrame(Duration.millis(500), new KeyValue(coly.textFillProperty(), Color.WHITE))
            );
            Timeline tlr = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(renk.textFillProperty(), Color.BLACK)),
                    new KeyFrame(Duration.millis(500), new KeyValue(renk.textFillProperty(), Color.WHITE))
            );
            tlx.play();
            tly.play();
            tlr.play();
        }
    }
}
