
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonApiFacade implements ApiFacade {

    @Override
    public String getAttributeValueFromJson(String urlString, String attributeName)
            throws IllegalArgumentException, IOException {

        String json = getJsonFromApi(urlString);

        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(json);

            Object value = jsonObject.get(attributeName);

            if (value == null) {
                throw new IllegalArgumentException(
                        "Attribute not found: " + attributeName
                );
            }

            return value.toString();

        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new IOException("Failed to parse JSON response", e);
        }
    }

    private String getJsonFromApi(String urlString) throws IOException {
        HttpURLConnection connection = null;

        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int statusCode = connection.getResponseCode();

            if (statusCode < 200 || statusCode >= 300) {
                throw new IOException("HTTP request failed with status code: " + statusCode);
            }

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {

                StringBuilder content = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    content.append(line);
                }

                return content.toString();
            }

        } catch (IOException e) {
            throw new IOException("Failed to retrieve data from API", e);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}