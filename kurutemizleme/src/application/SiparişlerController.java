package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;

import DBConnect.DBConnect;
import Kayýtlar.Sipariþ;
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

public class SipariþlerController {

    Connection conn=null;
    PreparedStatement sorguifadesi=null;
    ResultSet getirilen=null;
    String sql;
    
    public SipariþlerController(){
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
    private TableColumn<Sipariþ, Date> table_gtarih;

    @FXML
    private TableColumn<Sipariþ, Integer> table_müþteri;

    @FXML
    private TableColumn<Sipariþ, Date> table_ttarihi;

    @FXML
    private TableColumn<Sipariþ, Integer> table_tutar;

    @FXML
    private TableView<Sipariþ> table_view;

    @FXML
    private TableColumn<Sipariþ, Integer> table_ödeme;

    @FXML
    private TableColumn<Sipariþ, Integer> table_ürün;

    @FXML
    private TextField text_gtarih;

    @FXML
    private TextField text_müþteri;

    @FXML
    private TextField text_ttarih;

    @FXML
    private TextField text_tutar;

    @FXML
    private TextField text_ödeme;

    @FXML
    private TextField text_ürün;

    @FXML
    void ara_clk(ActionEvent event) {
  	  sql="Select * from getirilen where M_id Like '" + text_müþteri.getText() + "' and T_TARIH like '"+ text_ttarih.getText()+"'";
  	  tabloyaz(table_view,sql);
    }

    @FXML
    void ekle_clk(ActionEvent event) {
    	 sql="insert into getirilen(M_id , G_URUN, G_TARIH, T_TARIH, A_TUTAR, O_DURUMU) values(?,?,?,?,?,?)";
       	 try {
       			sorguifadesi=conn.prepareStatement(sql);
       			sorguifadesi.setString(1, text_müþteri.getText().trim());
       			sorguifadesi.setString(2, text_ürün.getText().trim());
       			sorguifadesi.setString(3, text_gtarih.getText().trim());
       			sorguifadesi.setString(4, text_ttarih.getText().trim());
       			sorguifadesi.setString(5, text_tutar.getText().trim());
       			sorguifadesi.setString(6, text_ödeme.getText().trim());
       			sorguifadesi.executeUpdate();
       			System.out.println("kullanýcý ekleme gerçekleþti ");
       	    }catch(SQLException e){ System.out.print("hata"+e.getMessage().toString());}
       	 tabloyaz(table_view,"select *from getirilen");
    }

    @FXML
    void güncelle_clk(ActionEvent event) {
   	 sql="update getirilen set O_DURUMU=? where M_id=? and T_TARIH=?";
   	 try {
   			sorguifadesi=conn.prepareStatement(sql);
   			sorguifadesi.setString(1, text_ödeme.getText().trim());
   			sorguifadesi.setString(2, text_müþteri.getText().trim());
   			sorguifadesi.setString(3, text_ttarih.getText().trim());
   			sorguifadesi.executeUpdate();
   			System.out.println("güncelleme gercekleþti");
   	    }catch(SQLException e){ System.out.print("hata"+e.getMessage().toString());}
   	tabloyaz(table_view,"select *from getirilen");
    }

    @FXML
    void table_view_clk(MouseEvent event) {

    }

    @FXML
    void initialize() {
 tabloyaz(table_view,"select * from getirilen");
    }
    
    public void tabloyaz(TableView<Sipariþ> tableview,String sql) {
    	
    	 
    	try {
        	ObservableList<Sipariþ> liste=FXCollections.observableArrayList();
        	sorguifadesi=conn.prepareStatement(sql);
            ResultSet getirilen=sorguifadesi.executeQuery();

            
           while(getirilen.next()) {
        	   liste.add(new Sipariþ(getirilen.getInt("M_id"),getirilen.getInt("G_URUN"),getirilen.getDate("G_TARIH"),getirilen.getDate("T_TARIH"),getirilen.getInt("A_TUTAR"),getirilen.getInt("O_DURUMU")));}
     
      
        table_müþteri.setCellValueFactory(new PropertyValueFactory<>("M_ID"));
        table_ürün.setCellValueFactory(new PropertyValueFactory<>("G_URUN") );
        table_gtarih.setCellValueFactory(new PropertyValueFactory<>("G_TARÝHÝ") );
        table_ttarihi.setCellValueFactory(new PropertyValueFactory<>("T_TARÝHÝ") );
        table_tutar.setCellValueFactory(new PropertyValueFactory<>("TUTAR") );
        table_ödeme.setCellValueFactory(new PropertyValueFactory<>("Ö_DURUMU") );
        table_view.setItems(liste);
 
    	}
    	catch(Exception e) {System.out.println("hata"+e.getMessage().toString());}
    	
    	
  
    }


}
