/**
 *
 * @author Damian
 */
public class Login {
    private String login;
    private String password;

    /**
     *
     * @param _login login jaki dana instancja klasy będzie przechowywać
     * @param _password hasło jakie dana instancja klasy będzie przechowywać
     */
    public Login(String _login, String _password){
        login = _login;
        password = _password;
    }

    /**
     *
     * @param _login login do porównania z przechowywanym wewnątrz obiektu
     * @param _password hasło do porównania z przechowywanym wewnątrz obiektu
     * @return prawda, gdy login i hasło zgadzaja sie, fałsz gdy albo login albo hasło nie pasuje do tych przechowywanych przez instancję klasy
     */
    public boolean check(String _login, String _password){

        return (login.equals(_login) && password.equals(_password));
    }

}