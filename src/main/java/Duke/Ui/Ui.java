package Duke.Ui;

public class Ui {
    public static final String LOGO = "  _____ _   _\n" +
            " | ____| |_| |__   __ _ _ __\n" +
            " |  _| | __| '_ \\ / _` | '_ \\\n" +
            " | |___| |_| | | | (_| | | | |\n" +
            " |_____|\\__|_| |_|\\__,_|_| |_|\n" +
            "\n";
    public static final String INTRO = " Hi there, I'm Ethan!\n" +
            " Do you need anything?\n";
    public static final String BYE = " Bye. See you soon!\n" +
            "----------------------------BYE----------------------------";
    public static final String YOU = "----------------------------YOU----------------------------\n";
    public static final String ETHAN = "---------------------------ETHAN---------------------------\n";

    public static void printBye(){
        System.out.println(BYE);
    }
    public static void printYou(){
        System.out.println(YOU);
    }
    public static void printETHAN(){
        System.out.println(ETHAN);
    }
    public static void printStart() {
        System.out.println("Hello from\n" + LOGO + ETHAN + INTRO);
    }
}
