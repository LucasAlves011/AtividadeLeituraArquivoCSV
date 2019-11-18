import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Teste001 {
    public static void main(String[]args) throws IOException  {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data ;

        Repositorio lista = Repositorio.getInstance();
        String virgula = ",";

        File arquivo = new File("cvli_pernambuco_dezembro-2015.csv");
        FileReader leitor = new FileReader(arquivo);

        try {
            BufferedReader sla = new BufferedReader(leitor);
            String linha = sla.readLine();

            while (linha != null){
                String[] k = linha.split(virgula);
                data = LocalDate.parse(k[0],formato);
                if(k[5].equals("")){
                    lista.cadastrar(new Homicidio(data,k[1],k[2],k[3],k[4],999,k[6],Integer.parseInt(k[7])));
                }
                else{
                    lista.cadastrar(new Homicidio(data,k[1],k[2],k[3],k[4],Integer.parseInt(k[5]),k[6],Integer.parseInt(k[7])));}
                linha = sla.readLine();
            }

        }catch (IOException x){
            System.out.println("Deu de IO");
        }catch (NumberFormatException x){
            System.out.println("Erro de fomato do número em algum lugar");
            x.printStackTrace();
        }

        ClasseControladora controle = new ClasseControladora();

        System.out.println("\t\t\t\t\t\t\tForam registrados  "+controle.numeroHomicidios() +" homicídios em novembro de 2015." );

        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  - - - - - - - - - - - - - - - - - - - - - - - - - -");

        System.out.println("\t\t\t\t\t\t\t\tRanking da criminalidade em novembro de 2015:\n\n"+Arrays.toString(controle.cidadesComMaisCrimes()));

        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  - - - - - - - - - - - - - - - - - - - - - - - - - -");

        System.out.printf("\nA idade médias dos assassitos é de : %.1f anos.",controle.mediaIdadeVítimas() );

        System.out.println("\n\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  - - - - - - - - - - - - - - - - - - - - - - - - - -");

        System.out.printf("\nA proporção de crimes contra homens é de %d %%.\n" +
                "A proporção de crimes contra mulheres é de %d %%",controle.proporcaoHM(),100-controle.proporcaoHM());

        System.out.println("\n\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println(" Data com mais crimes :" + controle.dataComMaisCrimes());


    }


}
