import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClasseAbstraite {

    private String nom;
    private List<Attribut> listeAttributs;

    public ClasseAbstraite(String mName) {
        this.nom = mName;
        listeAttributs = new ArrayList<>();
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
	                break;
	            case 6:
	                System.out.println("Vous avez saisi : choix 6");
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
        System.out.println("10- Rendre la classe abstraite");//TODO

    }
    private void creerNouvelAttribut(Scanner sc){
        System.out.println("Creation d'un nouvel attribut");
        System.out.println("Donner un nom a votre attribut");
        String str = sc.nextLine();
        Attribut a = new Attribut(str);
        this.listeAttributs.add(a);
        a.menu(sc); //todo ça devrait peut être pas être là
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
        System.out.println("** Attributs de la  Classes"+ this.getNom() +"**");
        //TODO
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
}
