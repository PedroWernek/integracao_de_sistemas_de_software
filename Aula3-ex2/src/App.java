import controller.BancoController;

public class App {
    private static final BancoController controller = new BancoController();

    public static void run(){
        controller.navegar();
    }
}
