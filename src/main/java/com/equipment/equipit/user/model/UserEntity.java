package com.equipment.equipit.user.model;

import com.equipment.equipit.team.model.TeamEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "\"user\"")
public class UserEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(unique = true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "group_type")
    private GroupType groupType;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private TeamEntity team;

    private String position;

    public UserEntity(String email, String password, GroupType groupType, TeamEntity team, String position) {
        this.email = email;
        this.password = password;
        this.groupType = groupType;
        this.team = team;
        this.position = position;
    }
}
