package it.unibs.fp.the_trinity.utilities;

public class UsefulStrings {
    public static final String STRONGER_ELEMENT = "L'elemento %s infligge un danno %d.\n";
    public static final String SELECT_LEVEL = "\nScegli il livello di difficolta' della partita: \n» Facile (1).\n» Normale (2).\n» Difficile (3).\n";

    public static final String PLAYER_1_NAME_REQUEST = "Inserire il nome del Primo Giocatore:\n";
    public static final String PLAYER_2_NAME_REQUEST = "Inserire il nome del Secondo Giocatore:\n";
    public static final String PLAYER_2_SECOND_NAME_REQUEST = "Inserire un nome (diverso da \"%s\") per il Secondo Giocatore:\n";
    public static final String HOMONYM_MESSAGE = "E' stato inserito lo stesso nome per entrambi i giocatori. \nVuoi che al Secondo Giocatore ne venga assegnato uno automaticamente? (S/N)\n";
    public static final String HOMONYM_FIXED_MESSAGE = "Congratulazioni Giocatore 2! \nIl tuo nuovo nome ora è \"";
    public static final String HOW_MANY_TAMAGOLEMS = "\nI Tamagolem schierati per entrambi i giocatori sono %d.\n";
    public static final String ONE_TAMAGOLEM = "\nOgni giocatore schiera un Tamagolem.\n";
    public static final String HOW_MANY_ELEMENTS = "\nSono stati estratti %d elementi:\n";
    public static final String HOW_MANY_STONES = "\nIl numero di pietre da assegnare è %d.\n";

    public static final String SETTING_ELEMENTS = "\n%s, ora devi scegliere quali pietre dare al tuo Tamagolem. \n Elementi ->";
    public static final String CHOOSE_ELEMENT_NAME = "\nInserire il nome (o l'iniziale) di un elemento:\n";
    public static final String SETTING_STONES_NUMBER_FOR_ELEMENT = "Inserire quante pietre assegnare all'elemento %s:\n";

    public static final String START_FIGHT_MESSAGE = "\n%s e %s, state per cominciare la battaglia. Inizieremo con l'evocazione dei Tamagolem." +
            "\n La procedura di evocazione di un Tamagolem è una sottofase che ricorre più volte durante lo scontro. In generale, l’evocazione interrompe lo" +
            "\nScontro ogni qualvolta sia necessario schierare in campo un nuovo Tamagolem da parte di un giocatore, evento che si verifica quando" +
            "\nil Tamagolem precedente del giocatore è eliminato dallo Scontro, ovvero perde tutta la vita %d." +
            "\nL’evocazione si verifica solo se il giocatore ha ancora TamaGolem disponibili, ossia il numero di Tamagolem eliminati è strettamente inferiore a %d." +
            "\nIn caso affermativo:" +
            "\n1. Un nuovo Tamagolem viene selezionato per la fase dell’evocazione; la sua Vita viene inizializzata al valore massimo %d." +
            "\n2. Il giocatore seleziona esattamente %d pietre degli elementi da far mangiare al Tamagolem, fra quelle a sua disposizione." +
            "\n   Le pietre selezionate verranno scagliate ciclicamente finché il Tamagolem resterà in vita." +
            "\n3. Il Tamagolem viene schierato in campo, l’evocazione termina e lo scontro può procedere.";

    public static final String WELCOME_MESSAGE =

            """

                      █▄▄ █▀▀ █▄ █ █ █ █▀▀ █▄ █ █ █ ▀█▀ █▀█   █ █▄ █
                      █▄█ ██▄ █ ▀█ ▀▄▀ ██▄ █ ▀█ █▄█  █  █▄█   █ █ ▀█
                    """;

                    /*"  _____                         _          _       \n" +
                    " | __  |___ ___ _ _ ___ ___ _ _| |_ ___   |_|___   \n" +
                    " | __ -| -_|   | | | -_|   | | |  _| . |  | |   |  \n" +
                    " |_____|___|_|_|\\_/|___|_|_|___|_| |___|  |_|_|_|";

     "  ▄▄▄▄· ▄▄▄ . ▐ ▄  ▌ ▐·▄▄▄ . ▐ ▄ ▄• ▄▌▄▄▄▄▄          ▪   ▐ ▄ \n" +
     " ▐█ ▀█▪▀▄.▀·•█▌▐█▪█·█▌▀▄.▀·•█▌▐██▪██▌•██  ▪         ██ •█▌▐█ \n" +
     " ▐█▀▀█▄▐▀▀▪▄▐█▐▐▌▐█▐█•▐▀▀▪▄▐█▐▐▌█▌▐█▌ ▐█.▪ ▄█▀▄     ▐█·▐█▐▐▌ \n" +
     " ██▄▪▐█▐█▄▄▌██▐█▌ ███ ▐█▄▄▌██▐█▌▐█▄█▌ ▐█▌·▐█▌.▐▌    ▐█▌██▐█▌ \n" +
     " ·▀▀▀▀  ▀▀▀ ▀▀ █▪. ▀   ▀▀▀ ▀▀ █▪ ▀▀▀  ▀▀▀  ▀█▄▀▪    ▀▀▀▀▀ █▪";

        ██████╗░███████╗███╗░░██╗██╗░░░██╗███████╗███╗░░██╗██╗░░░██╗████████╗░█████╗░       ██╗███╗░░██╗
        ██╔══██╗██╔════╝████╗░██║██║░░░██║██╔════╝████╗░██║██║░░░██║╚══██╔══╝██╔══██╗       ██║████╗░██║
        ██████╦╝█████╗░░██╔██╗██║╚██╗░██╔╝█████╗░░██╔██╗██║██║░░░██║░░░██║░░░██║░░██║       ██║██╔██╗██║
        ██╔══██╗██╔══╝░░██║╚████║░╚████╔╝░██╔══╝░░██║╚████║██║░░░██║░░░██║░░░██║░░██║       ██║██║╚████║
        ██████╦╝███████╗██║░╚███║░░╚██╔╝░░███████╗██║░╚███║╚██████╔╝░░░██║░░░╚█████╔╝       ██║██║░╚███║
        ╚═════╝░╚══════╝╚═╝░░╚══╝░░░╚═╝░░░╚══════╝╚═╝░░╚══╝░╚═════╝░░░░╚═╝░░░░╚════╝░       ╚═╝╚═╝░░╚══╝*/


    public static final String TITLE =

            """
                        ███        ▄████████   ▄▄▄▄███▄▄▄▄      ▄████████    ▄██████▄   ▄██████▄   ▄█          ▄████████   ▄▄▄▄███▄▄▄▄  \s
                    ▀█████████▄   ███    ███ ▄██▀▀▀███▀▀▀██▄   ███    ███   ███    ███ ███    ███ ███         ███    ███ ▄██▀▀▀███▀▀▀██▄\s
                       ▀███▀▀██   ███    ███ ███   ███   ███   ███    ███   ███    █▀  ███    ███ ███         ███    █▀  ███   ███   ███\s
                        ███   ▀   ███    ███ ███   ███   ███   ███    ███  ▄███        ███    ███ ███        ▄███▄▄▄     ███   ███   ███\s
                        ███     ▀███████████ ███   ███   ███ ▀███████████ ▀▀███ ████▄  ███    ███ ███       ▀▀███▀▀▀     ███   ███   ███\s
                        ███       ███    ███ ███   ███   ███   ███    ███   ███    ███ ███    ███ ███         ███    █▄  ███   ███   ███\s
                        ███       ███    ███ ███   ███   ███   ███    ███   ███    ███ ███    ███ ███▌    ▄   ███    ███ ███   ███   ███\s
                       ▄████▀     ███    █▀   ▀█   ███   █▀    ███    █▀    ████████▀   ▀██████▀  █████▄▄██   ██████████  ▀█   ███   █▀ \s
                                                                                                  ▀                                     \s
                    """;

                    /*" ______   ____  ___ ___   ____   ____   ___   _        ___  ___ ___   \n" +
                    "|      | /    ||   |   | /    | /    | /   \\ | |      /  _]|   |   | \n" +
                    "|      ||  o  || _   _ ||  o  ||   __||     || |     /  [_ | _   _ |  \n" +
                    "|_|  |_||     ||  \\_/  ||     ||  |  ||  O  || |___ |    _]|  \\_/  |\n" +
                    "  |  |  |  _  ||   |   ||  _  ||  |_ ||     ||     ||   [_ |   |   |  \n" +
                    "  |  |  |  |  ||   |   ||  |  ||     ||     ||     ||     ||   |   |  \n" +
                    "  |__|  |__|__||___|___||__|__||___,_| \\___/ |_____||_____||___|___| \n";*/


    private static final String[] HOMONYMY_NAMES = {
            "Franco",
            "Vincenzo",
            "Lagrange",
            "Robber",
            "TetoShfonda",
            "Keyshan",
            "Palombaro Procopio",
            "Barry Bee Benson",
            "ZebA99",
            "Shaggy all'1%",
            "La testa di Art Attack",
            "Christian 'Ice'",
            "Papa Bergoglio II",
            "La Winx che non si caga nessuno",
            "Paolo Brosio",
            "Terry A. Davis",
            "Emilio è Peggio",
            "Emilio Credenza",
            "Teo Mammupoveri",
            "Gerry Freddie",
            "Enrico Daddy",
            "THE_REAL_JOSH"
    };

    private static final String[] ERROR_STRINGS = {
            "Scappellamento a destra come se fosse Antani.",
            "Errore di inserimento. That's what she said.",
            "Si e' verificato un problema. Reinstalla il Sistema Operativo.",
            "Non dovresti non inserire un dato non invalido.",
            "Inserire un dato valido.",
            "ERROR 404 (NOT FOUND)",
            "Si e' verificato un errore al momento del tuo concepimento.",
            "ERRORE ERRORE ERRORE",
            "Se rilevi problemi nel leggere le istruzioni, attiva la Sintesi Vocale (consigliato il TTS \"Inglese Indiano\")." +
                    "\nAh beh tanto non potrai leggere neanche questo messaggio. \nGolden Shower.",
            "How dare you. Don't mess with the Pietro.",
            "Greta Thunberg non sarebbe contenta nel vederti sprecare energia.",
            "Mark Zuckerberg non e' contento nello spiare cose che non gli servono.",
            "Non arrenderti! \nAnche una scimmia che digita caratteri casuali per l'eternita' puo' scrivere perfettamente ogni testo mai concepito.",
            "I comandi sono quelli. Non puoi sbagliare. \nO forse si'. \nNon dovresti poter sbagliare. Ecco.",
            "Cadiamo solo per imparare a rialzarci.",
            "Il Conte Dracula Vlad diceva: \"Sbagliando si impala\""
    };

    private static final String[] GOODBYE_STRINGS = {
            "Torni presto da noi. Se stanno operando coercizione su di lei, faccia \"No\" con la testa. Non si preoccupi, la stiamo osservando dalla Webcam.",
            "Se hai rilevato qualche bug, inviaci una mail all'indirizzo movetotrash@tmpmail.com",
            "Torni presto da noi. Dai nostri dati statistici risulta che la maggior parte dei nostri utenti soffre di depressione." +
                    "\nSe e' il Suo caso contatti il Numero Verde a Pagamento contenuto nella documentazione." +
                    "\nSe invece non soffre di depressione e vuole provare, riapra questo programma finche' non produce effetti.",
            "Addioo, addiooo, aamici aaddio \nNoi ciiiiiiiii dobbiamo laasciaaaree \nMa ehi, io dico, che e' oookkeey!",
            "See You Space Cowboy.",
            "E' stato un bell'esame, a prostata.",
            "ARI ARI ARI ARI ARI ARI Arrivederci!"
    };

    // TODO static final means also "Public", and they must not be here


    private static final int LOW_MILLIS_PAUSE = 500;
    private static final int MEDIUM_MILLIS_PAUSE = 750;
    private static final int HIGH_MILLIS_PAUSE = 1000;

    public static String getHomonymName() {
        return HOMONYMY_NAMES[(int) (Math.random() * HOMONYMY_NAMES.length)];
    }

    public static String getErrorString() {
        return ERROR_STRINGS[(int) (Math.random() * ERROR_STRINGS.length)];
    }

    public static String getGoodbyeString() {
        return GOODBYE_STRINGS[(int) (Math.random() * GOODBYE_STRINGS.length)];
    }

    public static String player2SecondNameRequest(String player1Name) {
        return String.format(PLAYER_2_SECOND_NAME_REQUEST, player1Name);
    }
}