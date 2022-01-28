package com.cs544.video.rating.userservice.repository;

import com.cs544.video.rating.userservice.model.UserRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRatingRepository extends JpaRepository<UserRating, Long> {
}
