import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int scelta = 0;
        Scanner scanner = new Scanner(System.in);
        BancaCentrale bancaCentrale = new BancaCentrale();
        do {
            // Menu
            System.out.println("Cosa vuoi fare?:");
            System.out.println("1. Registrazione");
            System.out.println("2. Login");
            System.out.println("3. Stampa database");
            System.out.println("4. Elimina user");
            System.out.println("5. Modifica username");
            System.out.println("6. Visualizza lista utenti");
            System.out.println("7. Uscire");
            System.out.print("Seleziona un'opzione: ");
            scelta = scanner.nextInt();
            switch (scelta) {
                case 1:
                    // Caso della registrazione
                    bancaCentrale.registration();
                    break;
                case 2:
                    // Caso del Login
                    int valid = bancaCentrale.verify();
                    if (valid == 1) {
                        // Se l'utente si logga correttamente, farà le operazioni di rateizzazione
                        bancaCentrale.sceltaBanca();
                        break;
                    } else {
                        // Se l'utente non si logga correttamente il programma terminerà
                        System.out.println("ACCESSO NEGATO");
                        return;
                    }
                case 3:
                    // Stampa di tutte le operazioni svolte dagli utenti
                    bancaCentrale.stampaDatabase();
                    break;
                case 4:
                    bancaCentrale.deleteUser();
                    break;
                case 5:
                    bancaCentrale.modifyUser();
                    break;
                case 6:
                    bancaCentrale.readUser();
                    break;
                case 7:
                    System.out.println("Grazie e arrivederci");
                    return;

                default:
                    System.out.println("Non hai inserito una scelta giusta");
                    break;
            }
        } while (scelta != 7);
    }
}