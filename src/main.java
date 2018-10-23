import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Bienvenue dans ce simulateur de diagrammes de classe");
		System.out.println("Que voulez vous faire ?");
		System.out.println("1- Créer une nouvelle classe");
		System.out.println("2- Voir les classes existantes");

        String str;
        Scanner sc = new Scanner(System.in);
        do{
            str = sc.nextLine();


        }while(false);

        switch (str){
            case "1":
                System.out.println("Vous avez saisi : choix 1");
                break;
            case "2":
                System.out.println("Vous avez saisi : choix 2");
                break;
        }


	}

}
