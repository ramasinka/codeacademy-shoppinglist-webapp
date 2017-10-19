package lt.codeacademy.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private long id;
    private String email;
    private String name;
    private List<String> roleNames;
}


