package alurastickers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

	public void cria(InputStream inputStream, String nomeArquivo) throws IOException {
		
		//InputStream inputStream = new FileInputStream("entrada/filme.jpg");
		//InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.").openStream();
		BufferedImage imagemOriginal = ImageIO.read(inputStream);

		int largura = imagemOriginal.getWidth();
		int altura = imagemOriginal.getHeight();
		int novaAltura = altura + 200;
		//int novaAltura = altura + 40;

		BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

		Graphics2D graphics = novaImagem.createGraphics();
		graphics.drawImage(imagemOriginal, 0, 0, null);

		Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
		//Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 12);
		graphics.setColor(Color.yellow);
		graphics.setFont(fonte);

		graphics.drawString("TOPZERA", 100, novaAltura - 100);
		//graphics.drawString("TOPZERA", 10, novaAltura - 20);

		ImageIO.write(novaImagem, "png", new File("saida/" + nomeArquivo));

	}

}
