import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;


public class App {
    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar os top 250 filmes
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // extrair os dados (parse) - título, imagem, nota
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        
        // exibir os dados
        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println("\u001b[3mTítulo: \u001b[m\u001b[1m"+ filme.get("title") + "\u001b[m");
            System.out.println("\u001b[3mPoster: \u001b[m\u001b[1m"+ filme.get("image") + "\u001b[m");
            System.out.println("\u001b[45m\u001b[3mClassificação: \u001b[m\u001b[45m\u001b[1m"+ filme.get("imDbRating") + " \u001b[m");

            int nota = Math.round(Float.parseFloat(filme.get("imDbRating")));
            for(int i = 1; i <= nota; i++) {
                System.out.print("\u2b50");
            }
            System.out.println("\n");
        }
    }
}
