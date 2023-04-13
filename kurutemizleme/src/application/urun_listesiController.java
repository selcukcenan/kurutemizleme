package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import DBConnect.DBConnect;
import Kayýtlar.Ürünler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class urun_listesiController {
	
    Connection conn=null;
    PreparedStatement sorguifadesi=null;
    ResultSet getirilen=null;
    String sql;
    
    public urun_listesiController(){
    	conn=DBConnect.baglan();
       }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_ara;

    @FXML
    private Button btn_ekle;

    @FXML
    private Button btn_güncelle;

    @FXML
    private Button btn_sil;

    @FXML
    private TableColumn<Ürünler, Integer> table_Fiyat;

    @FXML
    private TableColumn<Ürünler, String> table_Tip;

    @FXML
    private TableView<Ürünler> table_view;

    @FXML
    private TextField text_Fiyat;

    @FXML
    private TextField text_tip;

    @FXML
    void ara_clk(ActionEvent event) {
    	  sql="Select * from urunler where U_TIPI Like '" + text_tip.getText() + "'";
    	  tabloyaz(table_view,sql);
    }

    @FXML
    void ekle_clk(ActionEvent event) {
      	 sql="insert into urunler(U_TIPI, U_FIYATI) values(?,?)";
       	 try {
       			sorguifadesi=conn.prepareStatement(sql);
       			sorguifadesi.setString(2, String.valueOf(text_Fiyat.getText().trim()));
       			sorguifadesi.setString(1, text_tip.getText().trim());
       			sorguifadesi.executeUpdate();
       			System.out.println("kullanýcý ekleme gerçekleþti ");
       	    }catch(SQLException e){ System.out.print("hata"+e.getMessage().toString());}
       	 tabloyaz(table_view,"select *from urunler");
    }

    @FXML
    void güncelle_clk(ActionEvent event) {
    	 sql="update urunler set U_FIYATI=? where U_TIPI=?";
    	 try {
    			sorguifadesi=conn.prepareStatement(sql);
    			sorguifadesi.setString(1, String.valueOf(text_Fiyat.getText().trim()));
    			sorguifadesi.setString(2, text_tip.getText().trim());
    			sorguifadesi.executeUpdate();
    			System.out.println("güncelleme gercekleþti");
    	    }catch(SQLException e){ System.out.print("hata"+e.getMessage().toString());}
    	    tabloyaz(table_view,"select *from urunler");
    	 
    }

    @FXML
    void sil_clk(ActionEvent event) {
    	sql="delete from urunler  where U_TIPI ";
   	 try {
   			sorguifadesi=conn.prepareStatement(sql);
   			sorguifadesi.setString(1, text_tip.getText().trim());
   			sorguifadesi.executeUpdate();
   			System.out.println("ürün silme gerçekleþti");
   	    }catch(SQLException e){ System.out.print("hata"+e.getMessage().toString());}
   	      tabloyaz(table_view,"select *from urunler");
   	 
   	}
    	
    

    @FXML
    void table_view_clk(MouseEvent event) {
          Ürünler kayýtlar=new Ürünler();
    	  kayýtlar=(Ürünler) table_view.getItems().get(table_view.getSelectionModel().getSelectedIndex());
    	  text_tip.setText(kayýtlar.getUrun_tip());
    	  text_Fiyat.setText(String.valueOf(kayýtlar.getUrun_fiyat()));
    }

    @FXML
    void initialize() {
    	sql="select * from urunler";
    	tabloyaz(table_view,sql);
    }
    
    
    public void tabloyaz(TableView<Ürünler> tableview,String sql) {
    	
 
    	try {
        	ObservableList<Ürünler> liste=FXCollections.observableArrayList();
        	sorguifadesi=conn.prepareStatement(sql);
            ResultSet getirilen=sorguifadesi.executeQuery();

            
           while(getirilen.next()) {
        	   liste.add(new Ürünler(getirilen.getString("U_TIPI"),getirilen.getInt("U_FIYATI")));}
     
      
        table_Tip.setCellValueFactory(new PropertyValueFactory<>("urun_tip"));
        table_Fiyat.setCellValueFactory(new PropertyValueFactory<>("urun_fiyat") );

        table_view.setItems(liste);
 
    	}
    	catch(Exception e) {System.out.println("hata"+e.getMessage().toString());}
    	
    	
  
    }

}

