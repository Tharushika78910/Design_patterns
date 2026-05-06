
import java.io.IOException;

public interface ApiFacade {
    String getAttributeValueFromJson(String urlString, String attributeName)
            throws IllegalArgumentException, IOException;
}