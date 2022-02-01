package com.cs544.video.rating.userservice.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long userId;
    @NotBlank
    private String userName;
    private String userAddress;

    @OneToMany
    @JoinColumn(name="userId")
    private List<UserWatchList> userWatchListList;
}
