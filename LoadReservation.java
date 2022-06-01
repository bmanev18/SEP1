import Model.Reservations;
import Utilities.MyFileHandler;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LoadReservation {
    public static void main(String[] args) {
        Reservations reservations = new Reservations();

        try {
            MyFileHandler.writeToBinaryFile("reservations.bin", reservations);
        } catch (FileNotFoundException e) {
            System.out.println("Error opening file ");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO Error writing to file ");
        }

        System.out.println("Done");
    }
}
