package utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pojos.CURDpojo;

public class ObjectMapperUtilsCURD {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> T convertJsonToJava(String json, Class<T> cls) {
        try {
            return mapper.readValue(json, cls);
        } catch (JsonProcessingException e) {
            // Log the error message and stack trace
            System.err.println("Failed to convert JSON to Java object: " + e.getMessage());
            e.printStackTrace();

            // Throw a custom exception with a more specific error message
            throw new RuntimeException("Failed to convert JSON to Java object. Check if the response is valid JSON.", e);
        }
    }

    public static String convertJavaToJson(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            // Log the error message and stack trace
            System.err.println("Failed to convert Java object to JSON: " + e.getMessage());
            e.printStackTrace();

            // Throw a custom exception with a more specific error message
            throw new RuntimeException("Failed to convert Java object to JSON.", e);
        }
    }

    public static String getFirstName(Object obj) {
        try {
            return mapper.convertValue(obj, CURDpojo.class).getFirstName();
        } catch (IllegalArgumentException e) {
            // Log the error message and stack trace
            System.err.println("Failed to get firstName: " + e.getMessage());
            e.printStackTrace();

            // Throw a custom exception with a more specific error message
            throw new RuntimeException("Failed to get firstName from the object.", e);
        }
    }

    public static String getLastName(Object obj) {
        try {
            return mapper.convertValue(obj, CURDpojo.class).getLastName();
        } catch (IllegalArgumentException e) {
            // Log the error message and stack trace
            System.err.println("Failed to get lastName: " + e.getMessage());
            e.printStackTrace();

            // Throw a custom exception with a more specific error message
            throw new RuntimeException("Failed to get lastName from the object.", e);
        }
    }

    public static String getEmail(Object obj) {
        try {
            return mapper.convertValue(obj, CURDpojo.class).getEmail();
        } catch (IllegalArgumentException e) {
            // Log the error message and stack trace
            System.err.println("Failed to get email: " + e.getMessage());
            e.printStackTrace();

            // Throw a custom exception with a more specific error message
            throw new RuntimeException("Failed to get email from the object.", e);
        }
    }
}