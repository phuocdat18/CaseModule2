package model;


public class User {
    private int id;
    private String username;
    private String password;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private String money;
    private Role role;

    public User(String username, String password, Role role) {
    }

    public User(int id, String username, String password, String name, String phoneNumber, String email, String address, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.role = role;
    }

    public User(String raw) {
        String [] strings = raw.split(",");
        this.id = Integer.parseInt(strings[0]);
        this.username = strings[1];
        this.password = strings[2];
        this.name = strings[3];
        this.phoneNumber = strings[4];
        this.email = strings[5];
        this.address = strings[6];
        this.role = Role.valueOf(strings[7]);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return id + "," + username + "," + password + "," + name + "," + phoneNumber + "," + email + "," + address + "," + role;
    }
}
