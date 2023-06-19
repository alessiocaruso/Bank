import java.util.ArrayList;
import java.util.Scanner;

public class BancaCentrale {
    // Variabili
    public ArrayList<String> username = new ArrayList<>();
    public ArrayList<String> password = new ArrayList<>();
    public ArrayList<String> database = new ArrayList<>();
    public String currentUser;

    public void registration() {
        // Registrazione
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci un nuovo username");
        String usernameString = scanner.nextLine();
        System.out.println("Inserisci una password");
        String passwordString = scanner.nextLine();
        if (username.contains(usernameString)) {
            // Se esiste già un utente con quell'username la registrazione fallirà
            System.out.println("Username già in uso. Registrazione fallita.");
            return;
        }

        username.add(usernameString);
        password.add(passwordString);
    }

    public int verify() {
        // Verifica per il login
        Scanner scanner = new Scanner(System.in);
        boolean isValid = false;
        System.out.println("Inserisci il tuo username");
        String usernameVerify = scanner.nextLine();
        System.out.println("Inserisci la tua password");
        String passwordVerify = scanner.nextLine();
        // Vediamo se nello stesso indice di username e password avremmo le giuste
        // credenziali
        for (int i = 0; i < username.size(); i++) {
            String currentUsername = username.get(i);
            String currentPassword = password.get(i);

            if (currentUsername.equals(usernameVerify) && currentPassword.equals(passwordVerify)) {
                // Se le credenziali sono giuste l'utente potrà accedere e impostiamo la
                // booleana a true
                System.out.println("ACCESSO CONSENTITO");
                isValid = true;
                // Salviamo il nome dell'User perchè ci servirà per il database
                currentUser = currentUsername;
                break;
            }
        }
        if (isValid) {
            // Se l'utente si logga ritorniamo il valore 1, altrimenti 0
            return 1;
        } else {
            return 0;
        }
    }
    // SCELTA MANUALE BANCA
    /*
     * public void sceltaBanca() {
     * Scanner scanner = new Scanner(System.in);
     * float interesse = 0;
     * System.out.println("Quanto capitale hai?");
     * int capitale = scanner.nextInt();
     * int scelta = 0;
     * 
     * System.out.println("Scegli la banca:");
     * System.out.println("1. AXIS");
     * System.out.println("2. ICICI");
     * System.out.println("3. SBI");
     * 
     * System.out.print("Seleziona un'opzione: ");
     * scelta = scanner.nextInt();
     * switch (scelta) {
     * case 1:
     * AXIS bank1 = new AXIS();
     * interesse = bank1.getRateOfInterest(capitale);
     * System.out.println("L'interesse per l'importo selezionato è di " +
     * interesse);
     * database.add("L'utente " + username +
     * " ha calcolato l'interesse per la banca AXIS con un capitale di "
     * + capitale);
     * break;
     * case 2:
     * ICICI bank2 = new ICICI();
     * interesse = bank2.getRateOfInterest(capitale);
     * System.out.println("L'interesse per l'importo selezionato è di " +
     * interesse);
     * database.add("L'utente " + username +
     * " ha calcolato l'interesse per la banca ICICI con un capitale di "
     * + capitale);
     * 
     * break;
     * 
     * case 3:
     * SBI bank3 = new SBI();
     * interesse = bank3.getRateOfInterest(capitale);
     * System.out.println("L'interesse per l'importo selezionato è di " +
     * interesse);
     * database.add("L'utente " + username +
     * " ha calcolato l'interesse per la banca SBI con un capitale di "
     * + capitale);
     * 
     * break;
     * default:
     * System.out.println("Non hai inserito una scelta giusta");
     * break;
     * }
     * 
     * }
     */

    // Scelta intelligente banca
    public void sceltaBanca() {
        Scanner scanner = new Scanner(System.in);
        float interesse = 0;
        System.out.println("Quanto capitale hai?");
        int capitale = scanner.nextInt();
        int scelta = 0;
        // In base al capitale inserito dall'utente avremmo la banca ideale per lui
        if (capitale >= 0 && capitale < 5000) {
            System.out
                    .println("La scelta migliore per questo tipo di capitale è la banca ICICI che ha un tasso del 7%");
            ICICI bank1 = new ICICI();
            interesse = bank1.getRateOfInterest(capitale);
            System.out.println("L'interesse per l'importo selezionato è di " +
                    interesse);
            database.add("L'utente " + currentUser +
                    " ha calcolato l'interesse per la banca ICICI con un capitale di "
                    + capitale);
        } else if (capitale >= 5000 && capitale <= 10000) {
            System.out.println("La scelta migliore per questo tipo di capitale è la banca AXIS che ha un tasso del 7%");
            AXIS bank1 = new AXIS();
            interesse = bank1.getRateOfInterest(capitale);
            System.out.println("L'interesse per l'importo selezionato è di " +
                    interesse);
            database.add("L'utente " + currentUser +
                    " ha calcolato l'interesse per la banca AXIS con un capitale di "
                    + capitale);
        } else if (capitale > 10000) {
            System.out
                    .println("La scelta migliore per questo tipo di capitale è la banca SBI che ha un tasso del 7%");
            SBI bank1 = new SBI();
            interesse = bank1.getRateOfInterest(capitale);
            System.out.println("L'interesse per l'importo selezionato è di " +
                    interesse);
            database.add("L'utente " + currentUser +
                    " ha calcolato l'interesse per la banca SBI con un capitale di "
                    + capitale);
        }
    }

    public void stampaDatabase() {
        for (int i = 0; i < database.size(); i++) {
            System.out.println(database.get(i));
        }
    }
}
