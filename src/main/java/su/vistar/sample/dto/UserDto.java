package su.vistar.sample.dto;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;
import su.vistar.sample.domain.Gender;
import su.vistar.sample.domain.Role;
import su.vistar.sample.domain.User;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Data
@AllArgsConstructor
public class UserDto {

    private Integer id;

    @NonNull
    private String email;

    @NonNull
    private String password;


    @NonNull
    private String name;

    @NonNull
    private Role role;

    private Gender gender;

    private Short age;

    private String photo;

    public UserDto(@NonNull User user) {
        this.setId(user.getId());
        this.setEmail(user.getEmail());
        this.setPassword(user.getPassword());
        this.setName(user.getName());
        this.setAge(user.getAge());
        this.setGender(user.getGender());
        this.setRole(user.getRole());
        this.setPhoto(user.getPhoto());
    }


}
