import java.util.ArrayList;
import java.util.Scanner;

public class ClasseAbstraite {

    private String nom;
    private ArrayList<Attribut> listeAttributs;

    public ClasseAbstraite(String mName) {
        this.nom = mName;
    }

    public void menu() {

        String str;
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();

        switch (str) {
            case "1":
                System.out.println("Vous avez saisi : choix 1");
                creerNouvelAttribut();
                break;
            case "2":
                System.out.println("Vous avez saisi : choix 2");
                afficherAttributs();
                break;
            case "3":
                System.out.println("Vous avez saisi : choix 3");
                choixAttribut().menu();
                break;
            case "4":
                System.out.println("Vous avez saisi : choix 4");
                //TODO
                break;
            case "5":
                System.out.println("Vous avez saisi : choix 5");
                break;
            case "6":
                System.out.println("Vous avez saisi : choix 6");
                break;
            case "7":
                System.out.println("Vous avez saisi : choix 7");
                break;
            case "8":
                System.out.println("Vous avez saisi : choix 8");
                break;
            default:
        }
    }
    private void afficherOptionsMenu() {
        System.out.println("** Menu Classe **");

        System.out.println("Que voulez vous faire ?");
        System.out.println("0- Quitter");
        System.out.println("1- Créer un nouvel attribut");
        System.out.println("2- Voir les attributs existants");
        System.out.println("3- Modifier les attributs existants");
        System.out.println("4- Supprimer un attribut existant");
        System.out.println("5- Créer une nouvelle méthode");
        System.out.println("6- Voir les méthodes existantes");
        System.out.println("7- Modifier les méthodes existantes");
        System.out.println("8- Supprimer une méthode existante");
    }
    private void creerNouvelAttribut(){
        System.out.println("Donner un nom à votre attribut");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Attribut a = new Attribut(str);
        this.listeAttributs.add(a);
        a.menu(); //todo ça devrait peut être pas être là
    }

    public Attribut choixAttribut(){
        System.out.println("** Choix d'une Classe **");
        for (int i=0; i<listeAttributs.size(); i++){
            System.out.print(i + " - " + listeAttributs.get(i).getNom() );
        }
        int choix;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Lequel voulez vous choisir ?");

            choix = sc.nextInt();
        }while(choix > listeAttributs.size());

        return listeAttributs.get(choix);
    }
    public void afficherAttributs () {
        System.out.println("** Attributs de la  Classes"+ this.getNom() +"**");
        //TODO
    }

    public String getNom() {
        return nom;
    }
}
