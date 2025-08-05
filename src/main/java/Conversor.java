import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {

    public Moedas escolheReal() {
        return pegarTaxas("BRL");
    }

    public Moedas escolheDolar() {
        return pegarTaxas("USD");
    }

    public Moedas escolheEuro() {
        return pegarTaxas("EUR");
    }

    public Moedas escolheDolarCanadense() {
        return pegarTaxas("CAD");
    }

    private Moedas pegarTaxas(String base) {
        URI uri = URI.create("https://v6.exchangerate-api.com/v6/78aaa6581a7741e874acc955/latest/" + base);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();

        try {
            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            ApiResponse apiResponse = new Gson().fromJson(response.body(), ApiResponse.class);
            return apiResponse.conversion_rates();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar taxas de câmbio: " + e.getMessage());
        }
    }
}
