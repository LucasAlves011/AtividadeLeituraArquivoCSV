import java.util.ArrayList;
import java.util.List;

public class Repositorio {

    public static Repositorio instance;

    private ArrayList<Homicidio> rep;

    private Repositorio(){
        rep = new ArrayList<>();
    }

    public static Repositorio getInstance(){
        if (instance == null){
            instance = new Repositorio();
        }
        return instance;
    }

    public void cadastrar(Homicidio x){
        rep.add(x);
    }

    public List<Homicidio> listar(){
        return rep;
    }

}

