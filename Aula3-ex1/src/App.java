import controller.BancoController;

public class App {
    public static void executar(){
        BancoController bancoController = new BancoController();
        bancoController.exibirMenu();
    }
}