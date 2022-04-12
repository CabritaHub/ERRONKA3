package ERRONKA;

import java.util.Objects;

public class EskaeraClass {

String Langilea, Matrikula, Deskribapena,  Prezioa,  Orduak;

	
	
	public EskaeraClass(String Langilea,String Matrikula,String Deskribapena, String Prezioa, String Orduak) {
		
		this.Langilea=Langilea;
		this.Matrikula=Matrikula;
		this.Deskribapena=Deskribapena;
		this.Prezioa=Prezioa;
		this.Orduak=Orduak;		
	}



	@Override
	public int hashCode() {
		return Objects.hash(Deskribapena, Langilea, Matrikula, Orduak, Prezioa);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EskaeraClass other = (EskaeraClass) obj;
		return Objects.equals(Deskribapena, other.Deskribapena) && Objects.equals(Langilea, other.Langilea)
				&& Objects.equals(Matrikula, other.Matrikula) && Objects.equals(Orduak, other.Orduak)
				&& Objects.equals(Prezioa, other.Prezioa);
	}



	@Override
	public String toString() {
		return "EskaeraClass [Langilea=" + Langilea + ", Matrikula=" + Matrikula + ", Deskribapena=" + Deskribapena
				+ ", Prezioa=" + Prezioa + ", Orduak=" + Orduak + "]";
	}



	public String getLangilea() {
		return Langilea;
	}



	public void setLangilea(String langilea) {
		Langilea = langilea;
	}



	public String getMatrikula() {
		return Matrikula;
	}



	public void setMatrikula(String matrikula) {
		Matrikula = matrikula;
	}



	public String getDeskribapena() {
		return Deskribapena;
	}



	public void setDeskribapena(String deskribapena) {
		Deskribapena = deskribapena;
	}



	public String getPrezioa() {
		return Prezioa;
	}



	public void setPrezioa(String prezioa) {
		Prezioa = prezioa;
	}



	public String getOrduak() {
		return Orduak;
	}



	public void setOrduak(String orduak) {
		Orduak = orduak;
	}
	
	
	
}
