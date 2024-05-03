package utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class ObjectMapperUtils1 {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T convertJsonToJava(String json, Class<T> cls) throws JsonProcessingException {
        return objectMapper.readValue(json, cls);
    }

    public static <T> List<T> convertJsonToJavaList(String json, Class<T> cls) throws JsonProcessingException {
        Map<String, Object> map = objectMapper.readValue(json, Map.class);
        List<T> data = objectMapper.convertValue(map.get("data"), objectMapper.getTypeFactory().constructCollectionType(List.class, cls));
        return data;
    }
}