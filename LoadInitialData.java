import Model.Room;
import Model.Rooms;
import Utilities.MyFileHandler;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LoadInitialData {
    public static void main(String[] args) {
        Rooms rooms = new Rooms();
        String[] studentArray = null;

        try {
            studentArray = MyFileHandler.readArrayFromTextFile("rooms.txt");

            for (String temp : studentArray) {
                String[] tempArr = temp.split(",");
                int number = Integer.parseInt(tempArr[0]);
                String type = tempArr[1];
                double price = Double.parseDouble(tempArr[2]);

                rooms.add(new Room(number, type, price));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File was not found, or could not be opened");
        }

        try {
            MyFileHandler.writeToBinaryFile("rooms.bin", rooms);
        } catch (FileNotFoundException e) {
            System.out.println("Error opening file ");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO Error writing to file ");
        }

        System.out.println("Done");
    }
}
