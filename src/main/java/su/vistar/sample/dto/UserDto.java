package su.vistar.web.dto;

public class UserDto {

    private String email;
    private String password;
    private String name;
    private Integer age;
    private String role;
    private String photo;

    public UserDto(String email, String password, String name, Integer age, String role) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;
        this.role = role;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDto user = (UserDto) o;

        if (!email.equals(user.email)) return false;
        if (!password.equals(user.password)) return false;
        if (!name.equals(user.name)) return false;
        if (age != null ? !age.equals(user.age) : user.age != null) return false;
        if (!role.equals(user.role)) return false;
        return photo != null ? photo.equals(user.photo) : user.photo == null;
    }

    @Override
    public int hashCode() {
        int result = email.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + role.hashCode();
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        return result;
    }
}
