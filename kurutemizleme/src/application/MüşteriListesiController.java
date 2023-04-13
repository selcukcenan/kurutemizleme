package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import DBConnect.DBConnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import  Kayýtlar.müþteri;


public class MüþteriListesiController {
	
    Connection conn=null;
    PreparedStatement sorguifadesi=null;
    ResultSet getirilen=null;
    String sql;
    
    public MüþteriListesiController(){
    	conn=DBConnect.baglan();
       }
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_ara;
  
    @FXML
    private Button btn_güncelle;
    
    @FXML
    private Button btn_sil;

    @FXML
    private TableColumn<müþteri, String> table_adres;

    @FXML
    private TableColumn<müþteri, String> table_madý;

    @FXML
    private TableColumn<müþteri, String> table_msoyad;

    @FXML
    private TableColumn<müþteri, String> table_mtel;

    @FXML
    private TableView<müþteri> table_view;

    @FXML
    private TextField text_ad;
    
    @FXML
    private TextField text_tel;
    
    @FXML
    private TextField text_adres;

    @FXML
    private TextField text_soyad;
    
    @FXML
    void sil_clk(ActionEvent event) {
    	sql="delete from musteriler  where M_ADI  ";
   	 try {
   			sorguifadesi=conn.prepareStatement(sql);
   			sorguifadesi.setString(1, text_ad.getText().trim());
   			sorguifadesi.executeUpdate();
   			alert("Silme gerçikleþti","Bildiri",null);
   	    }catch(SQLException e){ System.out.print("hata"+e.getMessage().toString());}
   	      tabloyaz(table_view,"select *from urunler");
   	 
   	}
    
    
    
    
    @FXML
    void güncelle_clk(ActionEvent event) {
      	 sql="update musteriler set M_ADRES=? where M_ADI=?";
      	 try {
      			sorguifadesi=conn.prepareStatement(sql);
       			sorguifadesi.setString(1, text_adres.getText().trim());
       			sorguifadesi.setString(2, text_ad.getText());
      			sorguifadesi.executeUpdate();
      	    }catch(SQLException e){ System.out.print("hata"+e.getMessage().toString());}
      	tabloyaz(table_view,"select *from getirilen");
      	alert("güncelleme gerçikleþti","Bildiri",null);
      	tabloyaz(table_view,"select * from musteriler");
       }

    @FXML
    void ara_clk(ActionEvent event) {
  sql="Select * from musteriler where M_ADI Like '" + text_ad.getText() + "'";
  tabloyaz(table_view,sql);
  
    }
    
    @FXML
    void table_view_clk(MouseEvent event) {
  müþteri kayýtlar=new müþteri();
  kayýtlar=(müþteri) table_view.getItems().get(table_view.getSelectionModel().getSelectedIndex());
  text_ad.setText(kayýtlar.getM_adý());
  text_soyad.setText(kayýtlar.getM_soyad());
  
    }

    @FXML
    void initialize() {
    	sql="select * from musteriler";
    	tabloyaz(table_view,sql);
    	
    	}

    public void tabloyaz(TableView<müþteri> tableview,String sql) {
    	ObservableList<müþteri> liste=FXCollections.observableArrayList();
    	try {
        	sorguifadesi=conn.prepareStatement(sql);
            ResultSet getirilen=sorguifadesi.executeQuery();
        if(getirilen==null)
        {
        	alert("getirilen boþ","Hata",null);
        }
        else {
        while(getirilen.next()) {
        	//veri tabanýndakiler
        	liste.add(new müþteri(getirilen.getString("M_ADI"),getirilen.getString("M_SOYADI"),getirilen.getString("M_TEL"),getirilen.getString("M_ADRES")));
        }
        //ilki table colmlar ikinciler kayýtlardaki degiþkenler
        table_view.getItems().clear(); 
        table_madý.setCellValueFactory(new PropertyValueFactory<>("M_adý"));
        table_msoyad.setCellValueFactory(new PropertyValueFactory<>("M_soyad") );
        table_mtel.setCellValueFactory(new PropertyValueFactory<>("M_tel"));
        table_adres.setCellValueFactory(new PropertyValueFactory<>("Adres"));
        table_view.setItems(liste);
    	}
    	}
    	catch(Exception e) {System.out.println("hata"+e.getMessage().toString());}
    	
    }
    	
    	
    public static void alert(String mesaj1, String baþlýk, String masaj) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(baþlýk);
        alert.setHeaderText(masaj);
        alert.setContentText(mesaj1);
        alert.showAndWait();

}


}
