package me.defian.bootapplication.dto;

import lombok.*;
import me.defian.bootapplication.entity.Team;

@Data
@Builder
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberCreateRequestDto {

    private int age;
    private String name;
    private Long teamId;
}

