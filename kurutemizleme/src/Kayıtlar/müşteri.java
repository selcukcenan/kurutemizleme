package Kay�tlar;

public class m��teri {
  private String M_ad�;
  private String M_soyad;
  private String M_tel;
  private String Adres;
  
	public m��teri() {
		
	}
	
	public m��teri(String Ad,String Soyad,String Telefon, String Adres) {
	this.M_ad�=Ad;
	this.M_soyad=Soyad;
	this.M_tel=Telefon;
	this.Adres=Adres;
	
	
}

	public String getM_ad�() {
		return M_ad�;
	}

	public void setM_ad�(String m_ad�) {
		M_ad� = m_ad�;
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
