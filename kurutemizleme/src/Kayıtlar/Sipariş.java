package Kayýtlar;

import java.util.Date;

public class Sipariþ {
	
private int M_ID;
private int G_URUN;
private Date G_TARÝHÝ;
private Date T_TARÝHÝ;
private int TUTAR;
private int Ö_DURUMU;


public Sipariþ(){
	
	
}

public Sipariþ(Integer M_ID,Integer G_URUN,Date G_TARÝHÝ,Date T_TARÝHÝ,Integer TUTAR   ,Integer Ö_DURUMU ){
	this.M_ID=M_ID;
	this.G_URUN=G_URUN;
	this.G_TARÝHÝ=G_TARÝHÝ;
	this.T_TARÝHÝ=T_TARÝHÝ;
	this.TUTAR=TUTAR;
	this.Ö_DURUMU=Ö_DURUMU;
		
}

public int getM_ID() {
	return M_ID;
}

public void setM_ID(int m_ID) {
	M_ID = m_ID;
}

public int getG_URUN() {
	return G_URUN;
}

public void setG_URUN(int g_URUN) {
	G_URUN = g_URUN;
}

public Date getG_TARÝHÝ() {
	return G_TARÝHÝ;
}

public void setG_TARÝHÝ(Date g_TARÝHÝ) {
	G_TARÝHÝ = g_TARÝHÝ;
}

public Date getT_TARÝHÝ() {
	return T_TARÝHÝ;
}

public void setT_TARÝHÝ(Date t_TARÝHÝ) {
	T_TARÝHÝ = t_TARÝHÝ;
}

public int getTUTAR() {
	return TUTAR;
}

public void setTUTAR(int tUTAR) {
	TUTAR = tUTAR;
}

public int getÖ_DURUMU() {
	return Ö_DURUMU;
}

public void setÖ_DURUMU(int ö_DURUMU) {
	Ö_DURUMU = ö_DURUMU;
}







}
