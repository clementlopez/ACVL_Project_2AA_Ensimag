import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Classe {

    private String nom;
    private List<Attribut> listeAttributs;
    private List<Methode> listeMethodes;
    private boolean estAbstraite;

    public Classe(String mName) {
        this.nom = mName;
        listeAttributs = new ArrayList<>();
        this.estAbstraite = false;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Attribut> getListeAttributs() {
        return listeAttributs;
    }

    public void setListeAttributs(List<Attribut> listeAttributs) {
        this.listeAttributs = listeAttributs;
    }

    public boolean isEstAbstraite() {
		return estAbstraite;
	}

	public void setEstAbstraite(boolean estAbstraite) {
		this.estAbstraite = estAbstraite;
	}

	public void menu() {
    	int choix = -1;
        while(choix!=0){
        	afficherOptionsMenu();
	        Scanner sc = new Scanner(System.in);
	        choix = sc.nextInt();
	        switch (choix) {
	            case 1:
	                System.out.println("Vous avez saisi : choix 1");
	                creerNouvelAttribut(sc);
	                break;
	            case 2:
	                System.out.println("Vous avez saisi : choix 2");
	                afficherAttributs();
	                break;
	            case 3:
	                System.out.println("Vous avez saisi : choix 3");
	                choixAttribut(sc).menu(sc);
	                break;
	            case 4:
	                System.out.println("Vous avez saisi : choix 4");
	                //TODO
	                break;
	            case 5:
	                System.out.println("Vous avez saisi : choix 5");
	                creerNouvelleMethode(sc);
	                break;
	            case 6:
	                System.out.println("Vous avez saisi : choix 6");
	                afficherMethodes();
	                break;
	            case 7:
	                System.out.println("Vous avez saisi : choix 7");
	                break;
	            case 8:
	                System.out.println("Vous avez saisi : choix 8");
	                break;
	            case 9:
	                System.out.println("Vous avez saisi : choix 9");
	                System.out.println("Comment voulez vous appeler cette Classe");
	                renommer(sc);
	                break;
	            case 10:
	                System.out.println("Vous avez saisi : choix 10");
	                changeAbstrait();
	                break;
	            default:
	        }
        }
    }
    private void afficherOptionsMenu() {
        System.out.println("** Menu Classe **");

        System.out.println("Que voulez vous faire ?");
        System.out.println("0- Quitter");
        System.out.println("1- Creer un nouvel attribut");
        System.out.println("2- Voir les attributs existants");
        System.out.println("3- Modifier les attributs existants");
        System.out.println("4- Supprimer un attribut existant");
        System.out.println("5- Creer une nouvelle methode");
        System.out.println("6- Voir les methodes existantes");
        System.out.println("7- Modifier les methodes existantes");
        System.out.println("8- Supprimer une methode existante");
        System.out.println("9- Renommer la classe");//TODO
        if(isEstAbstraite()) {
        	System.out.println("10- Rendre la classe non-abstraite");
        }
        else {
        	System.out.println("10- Rendre la classe abstraite");
        }
    }
    private void creerNouvelAttribut(Scanner sc){
        System.out.println("Creation d'un nouvel attribut");
        System.out.println("Donner un nom a votre attribut");
        String str = sc.nextLine();
        Attribut a = new Attribut(str);
        this.listeAttributs.add(a);
        a.menu(sc);
    }
    
    private void creerNouvelleMethode(Scanner sc){
        System.out.println("Creation d'une nouvelle methode");
        System.out.println("Donner un nom a votre methode");
        String str = sc.nextLine();
        Methode m = new Methode(str);
        this.listeMethodes.add(m);
        m.menu(sc);
    }

    public Attribut choixAttribut(Scanner sc){
        System.out.println("** Choix d'une Classe **");
        for (int i=0; i<listeAttributs.size(); i++){
            System.out.print(i + " - " + listeAttributs.get(i).getNom() );
        }
        int choix;
        do{
            System.out.println("Lequel voulez vous choisir ?");

            choix = sc.nextInt();
        }while(choix > listeAttributs.size());
        System.out.println("Vous avez choisi l'attribut " + listeAttributs.get(choix).getNom());
        return listeAttributs.get(choix);
    }
    
    public void afficherAttributs () {
        System.out.println("** Attributs de la  Classe "+ this.getNom() +"**");
        for(Attribut att : listeAttributs){
        	att.afficher();
        }
    }
    
    public void afficherMethodes () {
        System.out.println("** Methodes de la  Classe "+ this.getNom() +"**");
        for(Methode meth : listeMethodes){
        	meth.afficher();
        }
    }
    
    private void renommer(Scanner sc){
    	String str = "";
        while(str.equals("")){
        	str = sc.nextLine();
        }
        setNom(str);
    }
    
    public String getNom() {
        return nom;
    }
    
    public void afficher(){
    	System.out.println("\t\t- " + getNom());
    	System.out.println("\t\t\tListe des attributs");
    	for(Attribut att : listeAttributs){
    		att.afficher();
    	}
    	System.out.println("\t\t\tListe des methodes");
    	for(Methode meth : listeMethodes){
    		meth.afficher();
    	}
    }

	public void supprimerElementsEnRelationAvecClasse(Classe classe) {
		for(Attribut att : listeAttributs){
			if(att.getType().getNom().equals(classe.getNom())){
				listeAttributs.remove(att);
			}
		}
		for(Methode meth : listeMethodes){
			if(meth.getTypeRetour().equals(classe.getNom())){
				listeMethodes.remove(meth);
			}
		}
	}
	
	private void changeAbstrait() {
		setEstAbstraite(!isEstAbstraite());
		if(isEstAbstraite()) {
			System.out.println("La Classe " + getNom() + " est desormais abstraite");
		}
		else {
			System.out.println("La Classe " + getNom() + " n'est plus abstraite");
		}
	}
}
