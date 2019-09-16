package io.javabrains.moviecatelogservice.resources;

import io.javabrains.moviecatelogservice.models.CatalogItem;
import io.javabrains.moviecatelogservice.models.Movie;
import io.javabrains.moviecatelogservice.models.Rating;
import io.javabrains.moviecatelogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private WebClient.Builder webClientBuilder;

            @RequestMapping("/{userId}")
            public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){



                //RestTemplate restTemplate = new RestTemplate();
                //Movie movie = restTemplate.getForObject("http://localhost:8081/movies/foo", Movie.class);

                UserRating ratings = restTemplate.getForObject("http://movie-data-servie/ratingsdata/users/" + userId, UserRating.class);

                return ratings.getUserRating().stream().map(rating -> {
                    Movie movie = restTemplate.getForObject("http://movie-info-servie/movies/" + rating.getMovieId(), Movie.class);

//            Movie movie = webClientBuilder.build()
//                    .get()
//                    .uri("http://localhost:8081/movies/" + rating.getMovieId())
//                    .retrieve()
//                    .bodyToMono(Movie.class)
//                    .block();

            return new CatalogItem(movie.getName(),"Test",4);
        }).collect(Collectors.toList());

//        return  Collections.singletonList(
//                new CatalogItem("Transformers","Test",4)
//        );

        //CatalogItem catalogItem = new CatalogItem("Transformers", "Test", 4);
        //List<CatalogItem> catalogItems = null;
        //catalogItems.add(0, catalogItem);
        //return catalogItems;
    }
}
