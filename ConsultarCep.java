package consulta;

	import java.net.URI;
	import java.net.http.HttpClient;
	import java.net.http.HttpRequest;
	import java.net.http.HttpResponse;

	// Aluno: Misael Witalo Fereira da Silva
	// RA: 0025369
	// Consumo da API ViaCEP em Java
	
public class ConsultarCep {
		
	public static void main(String[] args) {

			String cep = "70089000";
			String url = "https://viacep.com.br/ws/" + cep + "/json/";
			
			try {
				HttpClient client = HttpClient.newHttpClient();
				
				HttpRequest request = HttpRequest.newBuilder()
						.uri(URI.create(url))
						.GET()
						.build();
				
				HttpResponse<String> response = client.send(
						request,
						HttpResponse.BodyHandlers.ofString()
						);
				System.out.println(response.body());

			} catch (Exception e) {
				System.out.println("Erro ao consultar o CEP: " + e.getMessage());
			}
		}
	}
