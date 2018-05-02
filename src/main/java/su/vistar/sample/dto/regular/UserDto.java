package su.vistar.sample.dto.regular;

import lombok.*;
import su.vistar.sample.domain.GenderEntity;
import su.vistar.sample.domain.RoleEntity;
import su.vistar.sample.domain.UserEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @NonNull
    private Integer id;

    @NonNull
    private String name;

    @NonNull
    private Short age;

    @NonNull
    private String email;

    @NonNull
    private String password;

    private String photo;

    @NonNull
    private RoleDto role;

    @NonNull
    private GenderDto gender;

}
