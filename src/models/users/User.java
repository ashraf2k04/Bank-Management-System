package models.users;

public abstract class User {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private String dob;

    public User() {
    }

    public User(String id,
                String firstName,
                String lastName,
                String email,
                String password,
                String address,
                String dob) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.dob = dob;
    }

    public boolean validateLogin(String enteredPassword) {

        return password.equals(enteredPassword);

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {

        return "ID          : " + id +
                "\nName        : " + firstName + " " + lastName +
                "\nEmail       : " + email +
                "\nDOB         : " + dob +
                "\nAddress     : " + address;
    }

}