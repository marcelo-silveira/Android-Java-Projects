package marcelo.junior.exentradadedados.helper;

public class util {
    public static boolean validarNome(String v){
        return v.matches("^[a-zA-Z]{2,30}$");
    }
}
