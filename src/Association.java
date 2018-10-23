import java.util.Scanner;

public class Association {
    public void menu() {

        //TODO
        afficherOptionsMenu();

        int choix;
        Scanner sc = new Scanner(System.in);
        choix = sc.nextInt();

        switch (choix) {
            case 1:
                System.out.println("Vous avez saisi : choix 1");
                break;
            default:
                break;
        }
    }
    void afficherOptionsMenu(){
        //TODO
    };

}
