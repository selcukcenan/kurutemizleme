package Kay�tlar;

import java.util.Date;

public class Sipari� {
	
private int M_ID;
private int G_URUN;
private Date G_TAR�H�;
private Date T_TAR�H�;
private int TUTAR;
private int �_DURUMU;


public Sipari�(){
	
	
}

public Sipari�(Integer M_ID,Integer G_URUN,Date G_TAR�H�,Date T_TAR�H�,Integer TUTAR   ,Integer �_DURUMU ){
	this.M_ID=M_ID;
	this.G_URUN=G_URUN;
	this.G_TAR�H�=G_TAR�H�;
	this.T_TAR�H�=T_TAR�H�;
	this.TUTAR=TUTAR;
	this.�_DURUMU=�_DURUMU;
		
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

public Date getG_TAR�H�() {
	return G_TAR�H�;
}

public void setG_TAR�H�(Date g_TAR�H�) {
	G_TAR�H� = g_TAR�H�;
}

public Date getT_TAR�H�() {
	return T_TAR�H�;
}

public void setT_TAR�H�(Date t_TAR�H�) {
	T_TAR�H� = t_TAR�H�;
}

public int getTUTAR() {
	return TUTAR;
}

public void setTUTAR(int tUTAR) {
	TUTAR = tUTAR;
}

public int get�_DURUMU() {
	return �_DURUMU;
}

public void set�_DURUMU(int �_DURUMU) {
	�_DURUMU = �_DURUMU;
}







}
