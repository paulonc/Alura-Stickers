package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.Conteudo;

public class ExtratorConteudoAnimal implements ExtratorConteudo {

    @Override
    public List<Conteudo> extraiConteudos(String json) {
        
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        for (Map<String,String> atributos : listaDeAtributos) {
            String titulo = atributos.get("name");
            String urlImagem = atributos.get("image_link");
            conteudos.add(new Conteudo(titulo, urlImagem));
            
        }
        return conteudos;
    }
    
}
