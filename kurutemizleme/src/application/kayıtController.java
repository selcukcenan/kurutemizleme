package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import DBConnect.DBConnect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class kay�tController {
	
    Connection conn=null;
    PreparedStatement sorguifadesi=null;
    ResultSet getirilen=null;
    String sql;
	
	public kay�tController() {
		conn=DBConnect.baglan();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_kay�t;

    @FXML
    private TextField text_ad;

    @FXML
    private TextField text_yetki;
    
    @FXML
    private TextField text_adres;

    @FXML
    private TextField text_soy_ad;

    @FXML
    private TextField text_tel;

    @FXML
    private TextField text_�ifre;

    @FXML
    void kay�t_clk(ActionEvent event) {
    	sql="insert into musteriler(M_ADI, M_SOYADI, M_TEL, M_ADRES, Sifre,yetki) values(?,?,?,?,?,?)";
    	try {
    		sorguifadesi=conn.prepareStatement(sql);
   			sorguifadesi.setString(1, text_ad.getText().trim());
   			sorguifadesi.setString(2, text_soy_ad.getText().trim());
   			sorguifadesi.setString(3, text_tel.getText().trim());
   			sorguifadesi.setString(4, text_adres.getText().trim());
   			sorguifadesi.setString(5, DBConnect.MD5�ifreleme(text_�ifre.getText().trim()));
   			sorguifadesi.setInt(6, 0);
   			
   			sorguifadesi.executeUpdate();
   			System.out.println("kullan�c� ekleme ger�ekle�ti ");
    	}
    	catch(Exception e) {System.out.print("hata"+e.getMessage().toString());}
    }

    @FXML
    void initialize() {

    }

}
