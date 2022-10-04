package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.Conteudo;

public class ExtratorConteudoIMDB implements ExtratorConteudo {

    public List<Conteudo> extraiConteudos (String json) {
        // extrair os dados (parse) - título, imagem, nota
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        for (Map<String,String> atributos : listaDeAtributos) {
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");
            conteudos.add(new Conteudo(titulo, urlImagem));
        }
        return conteudos;
    }
    
}
