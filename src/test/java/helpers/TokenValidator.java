package helpers;

import org.junit.jupiter.api.Assertions;

public class TokenValidator {

    public static void validateApiKey(String apiKey) {
        Assertions.assertNotNull(apiKey, "API Key cannot be null");
        Assertions.assertFalse(apiKey.isEmpty(), "API Key cannot be empty");
        Assertions.assertFalse(apiKey.trim().isEmpty(), "API Key cannot contain only whitespace");
        Assertions.assertTrue(apiKey.length() >= 20,
                "API Key must be at least 20 characters long (actual: " + apiKey.length() + ")");
        Assertions.assertTrue(apiKey.matches("^[a-zA-Z0-9_-]+$"),
                "API Key must contain only alphanumeric characters, underscore, or hyphen");
    }
}