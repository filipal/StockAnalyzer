package application;

public class Colors {
	
    // Definicija ANSI escape sekvenci za boje
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";

    public static void main(String[] args) {
        System.out.println(BLUE + "Ovo je izbornik u plavoj boji." + RESET);
        System.out.println(GREEN + "Ovo je poruka u zelenoj boji." + RESET);
    }
}
