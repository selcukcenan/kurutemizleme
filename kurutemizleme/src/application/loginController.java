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
    private Button btn_giriþ;

    @FXML
    private Button btn_kayýt;

    @FXML
    private TextField text_kul_adý;

    @FXML
    private TextField text_þifre;

    @FXML
    void giriþ_clk(ActionEvent event) {
        //	sql="Select * from musteriler where M_ADI=? Sifre=?";
    	 // try {
       	
    	 //sorguifadesi=DBConnect.baglan().prepareStatement(sql);
    	 // sorguifadesi.setString(1, text_kul_adý.getText().toString());
    	 //sorguifadesi.setString(2, DBConnect.MD5þifreleme(text_þifre.getText().toString()) );
    	 // ResultSet getirilen=sorguifadesi.executeQuery();
  		
    	 //if(!getirilen.next()) {
    	 //alert("kullanýcý adý veya þifre yanliþ","baþarýsýz",null);
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
    
    public static void alert(String mesaj1, String baþlýk, String masaj) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(baþlýk);
        alert.setHeaderText(masaj);
        alert.setContentText(mesaj1);
        alert.showAndWait();
    }
    
    
  
    

}
