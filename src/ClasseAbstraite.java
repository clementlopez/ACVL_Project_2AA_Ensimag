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

        afficherOptionsMenu();

        int choix;
        Scanner sc = new Scanner(System.in);
        choix = sc.nextInt();

        switch (choix) {
            case 1:
                System.out.println("Vous avez saisi : choix 1");
                creerNouvelAttribut();
                break;
            case 2:
                System.out.println("Vous avez saisi : choix 2");
                afficherAttributs();
                break;
            case 3:
                System.out.println("Vous avez saisi : choix 3");
                choixAttribut().menu();
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
                System.out.println("Comment voulez vous appeler cet attribut");
                String str;
                str = sc.nextLine();
                setNom(str);
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
        System.out.println("9- Renommer la classe");//TODO
        System.out.println("9- Rendre la classe abstraite");//TODO

    }
    private void creerNouvelAttribut(){
        System.out.println("Création d'un nouvel attribut");
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
        System.out.println("Vous avez choisi l'attribut " + listeAttributs.get(choix).getNom());

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
