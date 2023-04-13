package application;

import java.net.URL;
import java.sql.PreparedStatement;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class loginController {
    PreparedStatement sorguifadesi=null;
    String sql;
    


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_giri�;

    @FXML
    private Button btn_kay�t;

    @FXML
    private TextField text_kul_ad�;

    @FXML
    private TextField text_�ifre;

    @FXML
    void giri�_clk(ActionEvent event) {
        //	sql="Select * from musteriler where M_ADI=? Sifre=?";
    	 // try {
       	
    	 //sorguifadesi=DBConnect.baglan().prepareStatement(sql);
    	 // sorguifadesi.setString(1, text_kul_ad�.getText().toString());
    	 //sorguifadesi.setString(2, DBConnect.MD5�ifreleme(text_�ifre.getText().toString()) );
    	 // ResultSet getirilen=sorguifadesi.executeQuery();
  		
    	 //if(!getirilen.next()) {
    	 //alert("kullan�c� ad� veya �ifre yanli�","ba�ar�s�z",null);
    	 // }
  		
    	try {
  Stage a=new Stage();
  AnchorPane panel=(AnchorPane) FXMLLoader.load(getClass().getResource("AnaSayfa.fxml"));
  Scene scane =new Scene(panel);
  a.setScene(scane);
  a.getIcons().add(new Image(getClass().getResourceAsStream("download.jpg")));
  a.showAndWait();
    	}
    	catch(Exception e) {}
   	    	    	
   	    	 
    	 //}
    //catch (SQLException e) {
    //	alert(e.getMessage().toString(),"Hata",null);
  		  
    //	}
      
        
       
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
