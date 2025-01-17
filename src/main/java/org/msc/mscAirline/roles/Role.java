package org.msc.mscAirline.roles;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import org.msc.mscAirline.users.User;

import java.util.Set;

@Data
@Entity
@Table(name = "roles")
public class Role {

    @Id
    private Long id;
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    Set<User> users;

    public String getName() {
        return name;
    }
}
