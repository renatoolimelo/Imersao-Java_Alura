package alurastickers;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

	public static void main(String[] args) throws IOException, InterruptedException {

		// String url = "https://imdb-api.com/en/API/Top250Movies/k_xqnfc8l9";
		String url = "https://api.mocki.io/v2/549a5d8b/Top250Movies";
		// String url =
		// "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";

		ClienteHttp http = new ClienteHttp();
		String json = http.buscaDados(url);

		// ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();
		ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();

		List<Conteudo> conteudos = extrator.extraiConteudos(json);

		GeradoraDeFigurinhas geradora = new GeradoraDeFigurinhas();

		for (Conteudo conteudo : conteudos) {
		
		

			InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();

			String nomeArquivo = conteudo.getTitulo() + ".png";
		
//			InputStream inputStream = new FileInputStream("entrada/filme.jpg");
//			InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BYmU1NDRjNDgtMzhiMi00NjZmLTg5NGItZDNiZjU5NTU4OTE0XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._").openStream();
//			String nomeArquivo = "figurinha_Crush2" + ".png";

			geradora.cria(inputStream, nomeArquivo);

			System.out.println(conteudo.getTitulo());
			System.out.println(conteudo.getUrlImagem());
			System.out.println();
		}

	}

}
