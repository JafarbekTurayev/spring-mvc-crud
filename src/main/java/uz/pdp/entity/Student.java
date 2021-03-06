package uz.pdp.entity;

import lombok.*;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
@Component
public class Student {
    int id;
    String name;
    String email;
    int  groups_id;
}
