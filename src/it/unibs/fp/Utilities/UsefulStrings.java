package it.unibs.fp.Utilities;

public class UsefulStrings {
    private static final String STRONGER_ELEMENT = "L'elemento %s infligge un danno %d.\n";
    private static final String HOW_MANY_ELEMENTS = "\nQual è il livello della partita? Scegli fra le seguenti opzioni:\n» Basso (1).\n» Intermedio (2).\n» Difficile (3).";

    public static final String PLAYER_1_NAME_REQUEST = "Inserire il nome del Primo Giocatore:\n";
    public static final String PLAYER_2_NAME_REQUEST = "Inserire il nome del Secondo Giocatore:\n";
    public static final String HOMONYMY_MESSAGE = "E' stato inserito lo stesso nome per entrambi i giocatori. \nVuoi che al Secondo Giocatore ne venga assegnato uno automaticamente? (S/N)\n";
    public static final String HOMONYMY_FIXED_MESSAGE = "Congratulazioni Giocatore 2! \nIl tuo nuovo nome ora è \"";

    public static final String WELCOME_MESSAGE =

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


            "\n  █▄▄ █▀▀ █▄ █ █ █ █▀▀ █▄ █ █ █ ▀█▀ █▀█   █ █▄ █\n" +
              "  █▄█ ██▄ █ ▀█ ▀▄▀ ██▄ █ ▀█ █▄█  █  █▄█   █ █ ▀█\n";


    public static final String TITLE =

     "    ███        ▄████████   ▄▄▄▄███▄▄▄▄      ▄████████    ▄██████▄   ▄██████▄   ▄█          ▄████████   ▄▄▄▄███▄▄▄▄   \n" +
     "▀█████████▄   ███    ███ ▄██▀▀▀███▀▀▀██▄   ███    ███   ███    ███ ███    ███ ███         ███    ███ ▄██▀▀▀███▀▀▀██▄ \n" +
     "   ▀███▀▀██   ███    ███ ███   ███   ███   ███    ███   ███    █▀  ███    ███ ███         ███    █▀  ███   ███   ███ \n" +
     "    ███   ▀   ███    ███ ███   ███   ███   ███    ███  ▄███        ███    ███ ███        ▄███▄▄▄     ███   ███   ███ \n" +
     "    ███     ▀███████████ ███   ███   ███ ▀███████████ ▀▀███ ████▄  ███    ███ ███       ▀▀███▀▀▀     ███   ███   ███ \n" +
     "    ███       ███    ███ ███   ███   ███   ███    ███   ███    ███ ███    ███ ███         ███    █▄  ███   ███   ███ \n" +
     "    ███       ███    ███ ███   ███   ███   ███    ███   ███    ███ ███    ███ ███▌    ▄   ███    ███ ███   ███   ███ \n" +
     "   ▄████▀     ███    █▀   ▀█   ███   █▀    ███    █▀    ████████▀   ▀██████▀  █████▄▄██   ██████████  ▀█   ███   █▀  \n" +
     "                                                                              ▀                                      \n";

                    /*" ______   ____  ___ ___   ____   ____   ___   _        ___  ___ ___   \n" +
                    "|      | /    ||   |   | /    | /    | /   \\ | |      /  _]|   |   | \n" +
                    "|      ||  o  || _   _ ||  o  ||   __||     || |     /  [_ | _   _ |  \n" +
                    "|_|  |_||     ||  \\_/  ||     ||  |  ||  O  || |___ |    _]|  \\_/  |\n" +
                    "  |  |  |  _  ||   |   ||  _  ||  |_ ||     ||     ||   [_ |   |   |  \n" +
                    "  |  |  |  |  ||   |   ||  |  ||     ||     ||     ||     ||   |   |  \n" +
                    "  |__|  |__|__||___|___||__|__||___,_| \\___/ |_____||_____||___|___| \n";*/


    private static final String[] HOMONYMY_NAMES = {
            "Vincenzo",
            "Lagrange",
            "Robber",
            "TetoSfonda",
            "Keyshan",
            "Emilio Fede",
            "Palombaro Procopio",
            "Zeb99",
            "La testa di Art Attack",
            "Christian 'Ice'",
            "Papa Bergoglio II",
            "La Winx che non si caga nessuno",
            "Paolo Brosio",
            "Terry A. Davis",
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


    public static String getStrongerElement() {
        return STRONGER_ELEMENT;
    }

    public static String getHowManyElements() {
        return HOW_MANY_ELEMENTS;
    }

    public static String getHomonymyNames() {
        return HOMONYMY_NAMES[(int) (Math.random() * HOMONYMY_NAMES.length)];
    }

    public static String getErrorPhrase() {
        return ERROR_STRINGS[(int) (Math.random() * ERROR_STRINGS.length)];
    }

    public static String getGoodbyePhrase() {
        return GOODBYE_STRINGS[(int) (Math.random() * GOODBYE_STRINGS.length)];
    }

}