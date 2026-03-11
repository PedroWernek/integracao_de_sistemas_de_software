public class Usuario {
    private String login;
    private String senha;

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String fazerLogin() throws LoginInvalidoException {
            if (this.login == "admin" && this.senha == "123") {
                return "Login feito com sucesso";
            }else{
                throw new LoginInvalidoException("Bestinha!!!");
            }
    }
}
