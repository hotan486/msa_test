package io.javabrains.moviedataservice.resource;

import io.javabrains.moviedataservice.models.Rating;
import io.javabrains.moviedataservice.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){
        return new Rating(movieId,4);
    }

    @RequestMapping("users/{userId}")
    //public List<Rating>  getUserRating(@PathVariable("userId") String userId){
    public UserRating  getUserRating(@PathVariable("userId") String userId){
        List<Rating> ratings = Arrays.asList(
                new Rating("1234",4),
                new Rating("4567",6)
        );

        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);
        return userRating;
        //return ratings;


    }
}
