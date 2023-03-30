import business.Donator;
import business.Service;
import controller.LogInController;
public class Start {
    public static void main(String[] args) {
        Service.donatori.add(new Donator("cristi","cristi"));
        LogInController.getInstance();
    }
}