package Kayýtlar;

public class müþteri {
  private String M_adý;
  private String M_soyad;
  private String M_tel;
  private String Adres;
  
	public müþteri() {
		
	}
	
	public müþteri(String Ad,String Soyad,String Telefon, String Adres) {
	this.M_adý=Ad;
	this.M_soyad=Soyad;
	this.M_tel=Telefon;
	this.Adres=Adres;
	
	
}

	public String getM_adý() {
		return M_adý;
	}

	public void setM_adý(String m_adý) {
		M_adý = m_adý;
	}

	public String getM_soyad() {
		return M_soyad;
	}

	public void setM_soyad(String m_soyad) {
		M_soyad = m_soyad;
	}

	public String getM_tel() {
		return M_tel;
	}

	public void setM_tel(String m_tel) {
		M_tel = m_tel;
	}

	public String getAdres() {
		return Adres;
	}

	public void setAdres(String adres) {
		Adres = adres;
	}
	
	
	
}
