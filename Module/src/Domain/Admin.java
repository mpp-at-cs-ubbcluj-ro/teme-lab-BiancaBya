package Domain;

public class Admin extends Entity<Integer>{

    private String email;
    private String password;

    public Admin(Integer integer, String email, String password) {
        super(integer);
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
