import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;

public class ClasseControladora {

    Repositorio dados = Repositorio.getInstance();

    public int numeroHomicidios(){
        int numeroDeHomicidios=0;
        for (Homicidio iterador:dados.listar()) {
            if (iterador.getNatureza().equals("HOMICIDIO") && iterador.getDataFalecimento().getYear() == 2015 && iterador.getDataFalecimento().getMonth()== Month.NOVEMBER){
                numeroDeHomicidios++;
            }
        }
        return numeroDeHomicidios;
    }

    public String[] cidadesComMaisCrimes(){
        ArrayList<String> cidades = new ArrayList<>();
        ArrayList<Integer> numero = new ArrayList<>();
        String retorno[] = new String[3];

        for (Homicidio iterador:dados.listar()) {

            if(cidades.contains(iterador.getMinicipio())){
             int indexCidade = cidades.indexOf(iterador.getMinicipio());
             int atual = numero.get(indexCidade);
              numero.set(indexCidade,atual + 1);
            }
            else{
                cidades.add(iterador.getMinicipio());
                numero.add(1);
            }
        }

        for (int k = 0; k <3 ; k++) {
            int x=0;
            int aux = 0;

            for (int i = 0; i < numero.size(); i++) {
                if (numero.get(i) > aux){
                    aux = numero.get(i);
                    x = i;
                }
            }
            retorno[k] = (k+1)+"º - " +cidades.get(x) + " com " + numero.get(x) +" ocorrências.\t";
            numero.remove(x);
            cidades.remove(x);
        }

        return retorno;
    }

    public float mediaIdadeVítimas(){
        int y=0;
        float resultado=0;
        for (Homicidio iterador: dados.listar()) {
            if (iterador.getIdade() != 999){
                resultado += iterador.getIdade();
            }
            else y++;
        }
        return resultado/(dados.listar().size()-y);
    }

    public int proporcaoHM(){
        int homem=0;
        for (Homicidio iterador:dados.listar()) {
            if (iterador.getSexo().equals("MASCULINO")) homem++;
        }
        return (homem*100)/dados.listar().size();
    }

    public ArrayList<LocalDate> dataComMaisCrimes(){
        ArrayList<LocalDate> p = new ArrayList<>();
        ArrayList<LocalDate> pAux = new ArrayList<>();


        for (Homicidio iterador:dados.listar()) {
            if (!p.contains(iterador.getDataFalecimento())){
                p.add(iterador.getDataFalecimento());
            }
            pAux.add(iterador.getDataFalecimento());
        }

        ArrayList<Integer> aux = new ArrayList<>();
        ArrayList<LocalDate> retorno = new ArrayList<>();
        aux.add(0);
        int j=0;

        for (int i = 0; i < p.size() ; i++) {
           int vezes = Collections.frequency(pAux,p.get(i));
            if (vezes > j){
               aux.clear();
               aux.add(i);
               j=vezes;
           }else if (vezes == j) aux.add(i);
        }

        for (int i = 0; i < aux.size() ; i++) {
            retorno.add(p.get(aux.get(i)));
        }

        return retorno;
    }


}
