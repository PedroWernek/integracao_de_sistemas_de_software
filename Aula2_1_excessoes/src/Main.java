import java.util.List;

public class Main {
    public static void main(String[] args) {
        try{
            Usuario user = new Usuario("admin","123");
            System.out.println(user.fazerLogin());
        }catch (LoginInvalidoException e){
            System.out.println(e);
        }
    }
}