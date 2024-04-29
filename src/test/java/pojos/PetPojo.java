package pojos;

import java.util.HashMap;
import java.util.Map;

public class PetPojo {
    private int id;
    private String name;
    private String status;  // Available statuses: available, pending, sold

    public PetPojo() {
    }

    public PetPojo(int id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // toString method for easy printing and logging
    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public static class JsonPlaceHolderTestData {

        // With this method, we can create test data in the test class without creating a new map.

        public static Map<String, Object> expectedDataMap(Integer userId, String title, Boolean completed) {

            Map<String, Object> expectedData = new HashMap<>();
            expectedData.put("userId", userId);
            expectedData.put("title", title);
            expectedData.put("completed", completed);

            return expectedData;

        }


    }
}
