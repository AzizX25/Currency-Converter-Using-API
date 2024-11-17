package currencyconverter;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public class CurrencyService {

    private static final String API_KEY = "68690826916aef310a6b328a"; // This is a placeholder for the actual API key needed to authenticate requests to the exchange rate API.
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/"; // This is the base URL for the exchange rate API. The base currency will be appended to this URL to form the complete endpoint for fetching exchange rates.

    /**
     * Fetches the exchange rate from one currency to another.
     *
     * @param fromCurrency The base currency code (e.g., "USD").
     * @param toCurrency The target currency code (e.g., "EUR").
     * @return The exchange rate from the base currency to the target currency.
     * @throws IOException If an I/O error occurs when sending or receiving.
     * @throws InterruptedException If the operation is interrupted.
     */
    public static double getExchangeRate(String fromCurrency, String toCurrency) throws IOException, InterruptedException {
        // Construct the complete URL for the API request
        String url = API_URL + fromCurrency + "?access_key=" + API_KEY;

        // Create an instance of HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Build the HttpRequest object with the constructed URL
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        // Send the HTTP request and get the response as a string
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Parse the response body into a JSONObject
        JSONObject json = new JSONObject(response.body());

        // Extract and return the exchange rate for the target currency from the JSON object
        return json.getJSONObject("rates").getDouble(toCurrency);
    }
}

