import Model.ModelManager;

import java.time.LocalDate;

public class testModel {
    public static void main(String[] args) {
        ModelManager modelManager = new ModelManager("rooms.bin", "rooms.bin");
        System.out.println(modelManager.searchToday(LocalDate.now()));
    }
}
