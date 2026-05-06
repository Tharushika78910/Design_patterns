
import java.io.IOException;

public class ApiFacadeApp {

    public static void main(String[] args) {
        ApiFacade apiFacade = new JsonApiFacade();

        try {
            String joke = apiFacade.getAttributeValueFromJson(
                    "https://api.chucknorris.io/jokes/random",
                    "value"
            );

            System.out.println("Chuck Norris joke:");
            System.out.println(joke);

            String baseCurrency = apiFacade.getAttributeValueFromJson(
                    "https://api.fxratesapi.com/latest",
                    "base"
            );

            System.out.println();
            System.out.println("FX Rates API base currency:");
            System.out.println(baseCurrency);

        } catch (IllegalArgumentException e) {
            System.out.println("Attribute error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("API error: " + e.getMessage());
        }

        demonstrateErrors(apiFacade);
    }

    private static void demonstrateErrors(ApiFacade apiFacade) {
        try {
            apiFacade.getAttributeValueFromJson(
                    "https://api.chucknorris.io/jokes/random",
                    "not_existing_attribute"
            );
        } catch (IllegalArgumentException e) {
            System.out.println();
            System.out.println("Correctly handled missing attribute:");
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            apiFacade.getAttributeValueFromJson(
                    "invalid-url",
                    "value"
            );
        } catch (IOException e) {
            System.out.println();
            System.out.println("Correctly handled invalid URL:");
            System.out.println(e.getMessage());
        }
    }
}