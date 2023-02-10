package Game.utils;

import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    public static int getInt(){
        int responseInt = 0;
        boolean error = false;
        do{
            try {
                responseInt = scanner.nextInt();
                error = false;
            } catch (Exception e) {
                error = true;
            }
        }while(error);
        return responseInt;
    }

    public static String getString(){
        String line = scanner.nextLine();
        if(line.isEmpty()){
            scanner.nextLine();
        }
        return line;
    }

    public static String getStringNext(){
        String line = scanner.next();
        if(line.isBlank()){
            System.out.println("Invalid input");
        }
        return line;
    }
}
