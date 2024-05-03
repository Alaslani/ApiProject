package pojos;

public class CreateUserResponse {
    private CURDpojo user;
    private String token;

    // Getters and setters

    public CURDpojo getUser() {
        return user;
    }

    public void setUser(CURDpojo user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}