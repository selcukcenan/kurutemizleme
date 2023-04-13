package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class AnaSayfaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anc_sag;

    @FXML
    private AnchorPane anchor_sol;

    @FXML
    private Button btn_ayar;

    @FXML
    private Button btn_ham;
    
    @FXML
    private Button btn_m��teri;

    @FXML
    private Button btn_liste;

    @FXML
    private Button btn_sipari�;

    @FXML
    private Button btn_�r�n;

    @FXML
    void ayar_clk(ActionEvent event) {
     alert("bu form henuz kullan�lmamaktad�r","HATA",null);
    }
    
    @FXML
    void m��teri_clk(ActionEvent event) {
    	try {
    		  AnchorPane panel =(AnchorPane) FXMLLoader.load(getClass().getResource("M��teriListsi.fxml"));
    		  anc_sag.getChildren().setAll(panel);
    		    	}
    		    	catch (Exception e) {
    		    		 alert(e.getMessage().toString(),"Hata",null);
    		    	}
    }
    
    public int durum=0;
    @FXML
    void ham_clk(ActionEvent event) {
    	if(durum==0) {
    	FadeTransition fd1= new FadeTransition(Duration.seconds(1),anchor_sol);
        fd1.setFromValue(0);
        fd1.setToValue(1);
        fd1.play();
        
        TranslateTransition tt1=new TranslateTransition(Duration.seconds(1),anchor_sol);
        tt1.setByX(-200);
        tt1.setByY(0);
        tt1.play();
    	durum=1;
    	}
    	else {
            TranslateTransition tt1=new TranslateTransition(Duration.seconds(0.5),anchor_sol);
            tt1.setByX(+200);
            tt1.play();
            durum=0;
    	}
    	}

    @FXML
    void liste_clk(ActionEvent event) {
    	try {
    		  AnchorPane panel =(AnchorPane) FXMLLoader.load(getClass().getResource("kay�t.fxml"));
    		  anc_sag.getChildren().setAll(panel);
    		    	}
    		    	catch (Exception e) { alert(e.getMessage().toString(),"Hata",null);}
    	

    }

    @FXML
    void sipari�_clk(ActionEvent event) {
    	try {
  		  AnchorPane panel =(AnchorPane) FXMLLoader.load(getClass().getResource("Sipari�ler.fxml"));
  		  anc_sag.getChildren().setAll(panel);
  		    	}
  		    	catch (Exception e) { alert(e.getMessage().toString(),"Hata",null);}
    }

    @FXML
    void �r�n_clk(ActionEvent event) {
    	try {
    		  AnchorPane panel =(AnchorPane) FXMLLoader.load(getClass().getResource("urun_listesi.fxml"));
    		  anc_sag.getChildren().setAll(panel);
    		    	}
    		    	catch (Exception e) { alert(e.getMessage().toString(),"Hata",null);}
    }

    @FXML
    void initialize() {

    }
    
    public static void alert(String mesaj1, String ba�l�k, String masaj) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(ba�l�k);
        alert.setHeaderText(masaj);
        alert.setContentText(mesaj1);
        alert.showAndWait();

}
}

    
    
    
    
   