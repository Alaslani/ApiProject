package pojos;

import java.util.List;

public class GoRestPojo1 {
    private List<DataItem> data;
    private Meta meta;
    private String name;
    private String email;
    private String gender;
    private String status; // Add this field

    public void setData(List<DataItem> data) {
        this.data = data;
    }

    public List<DataItem> getData() {
        return data;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setStatus(String status) { // Add this setter
        this.status = status;
    }

    public String getStatus() { // Add this getter
        return status;
    }

    @Override
    public String toString() {
        return "GoRestPojo1{" +
                "data=" + data +
                ", meta=" + meta +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", status='" + status + '\'' + // Add this line
                '}';
    }
}
