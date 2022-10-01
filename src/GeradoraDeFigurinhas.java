import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {


    public void cria(InputStream inputStream, String nomeArquivo, String texto) throws Exception {

        // leitura da imagem
        BufferedImage original = ImageIO.read(inputStream);


        // cria nova imagem em memória com transparência e com tamanho novo
        int largura = original.getWidth();
        int altura = original.getHeight();
        int novaAltura = altura + (altura / 5);

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        
        // copiar a imagem original para o nova imagem
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(original, 0, 0, null);


        // configurar a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, largura / 10);
        FontMetrics medidasFonte = graphics.getFontMetrics(fonte);
        int posX = (largura - medidasFonte.stringWidth(texto)) / 2;
        int posY = novaAltura - (novaAltura / 16);

        graphics.setFont(fonte);
        graphics.setColor(Color.YELLOW);


        // escrever uma frase na nova imagem
        graphics.drawString(texto, posX, posY);

        // escrever nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File("saida/" + nomeArquivo));

    }

}