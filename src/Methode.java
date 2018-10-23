import java.util.ArrayList;
import java.util.List;

public class Methode {
	String nom;
	String typeRet = "void";
	List<Parametre> params;
	
	
	public Methode(String nom) {
		super();
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getTypeRet() {
		return typeRet;
	}
	public void setTypeRet(String typeRet) {
		this.typeRet = typeRet;
	}
	public List<Parametre> getParams() {
		return params;
	}
	public void setParams(List<Parametre> params) {
		this.params = new ArrayList<Parametre>(params);
	}
	
	
}
