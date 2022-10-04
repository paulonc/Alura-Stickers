import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import enums.APIEnum;
import model.Conteudo;
import util.ClienteHttp;
import util.ExtratorConteudo;
import util.ExtratorConteudoNasa;
import util.GeradorFigurinha;


public class App {
    public static void main(String[] args) throws Exception {

        // String url = APIEnum.IMDB.getUrl();
        // ExtratorConteudo extrator = new ExtratorConteudoIMDB();

        String url = APIEnum.NASA.getUrl();
        ExtratorConteudo extrator = new ExtratorConteudoNasa();

        // String url = APIEnum.ANIMAIS.getUrl();
        // ExtratorConteudo extrator = new ExtratorConteudoAnimal();

        
        var http = new ClienteHttp();
        String json = http.buscaDados(url);

 
        List<Conteudo> conteudos = extrator.extraiConteudos(json);
        
        var geradoraDeFigurinhas = new GeradorFigurinha();
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            Conteudo conteudo = conteudos.get(i);
            System.out.println("\u001b[3mTítulo: \u001b[m\u001b[1m"+ conteudo.titulo() + "\u001b[m");
            System.out.println("\u001b[3mPoster: \u001b[m\u001b[1m"+ conteudo.urlImagem() + "\u001b[m");
            

            var textos = Arrays.asList("TOPZERA", "METEU ESSA?", "SÓ SUCESSO", "VALE A PENA", "RAPAAAAZ");
            int n = random.nextInt(5);
            
            InputStream inputStream = new URL(conteudo.urlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.titulo() + ".png";
            
            geradoraDeFigurinhas.cria(inputStream, nomeArquivo, textos.get(n));


        }
    }
}
