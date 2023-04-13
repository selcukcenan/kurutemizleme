package Kayıtlar;

public class Ürünler {

	
	  private String urun_tip;
	  private Integer urun_fiyat;

	  
		public Ürünler() {
			
		}
		
		public Ürünler(String urun_tip,Integer urun_fiyat) {
		this.urun_tip=urun_tip;
		this.urun_fiyat=urun_fiyat;

}

		public String getUrun_tip() {
			return urun_tip;
		}

		public void setUrun_tip(String urun_tip) {
			this.urun_tip = urun_tip;
		}

		public Integer getUrun_fiyat() {
			return urun_fiyat;
		}

		public void setUrun_fiyat(Integer urun_fiyat) {
			this.urun_fiyat = urun_fiyat;
		}
		
		
		
		
		
		
		
		
}
