package su.vistar.sample.dto.regular;

import lombok.*;

import org.hibernate.validator.constraints.NotEmpty;
import su.vistar.sample.validators.annotations.PasswordMatches;
import su.vistar.sample.validators.annotations.ValidEmail;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@PasswordMatches
public class UserDto {

    @NonNull
    @NotNull
    @NotEmpty
    private String firstName;

    @NonNull
    @NotNull
    @NotEmpty
    private String lastName;
    
    @NonNull
    @NotNull
    @NotEmpty
    @ValidEmail
    private String email;

    @NotNull
    @NotEmpty
    private String password;
    private String matchingPassword;


    private String photo;

    @NonNull
    @NotNull
    private RoleDto role;

}
