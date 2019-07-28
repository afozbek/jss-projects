package com.obss.movietracker.springwebservice.Model;

import com.obss.movietracker.springwebservice.Model.Types.Genre;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "movies")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    @Column
    private String name;

    @Column
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date releaseDate;

    @Column
    private double rating;

    @Enumerated(EnumType.STRING)
    @Column
    private Genre genre;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "directorId")
    private DirectorEntity director;

    public MovieEntity() {
    }


    public MovieEntity(String name, Date releaseDate, double rating, Genre genre, DirectorEntity director) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.genre = genre;
        this.director = director;
    }

    @Override
    public String toString() {
        return "MovieEntity{" +
                "id=" + movieId +
                ", name='" + name + '\'' +
                ", releaseDate=" + releaseDate +
                ", rating=" + rating +
                ", genre='" + genre + '\'' +
                ", director=" + director +
                '}';
    }

    public Genre getGenreType() {
        return genre;
    }

    public void setGenreType(Genre genreType) {
        this.genre = genreType;
    }

    public DirectorEntity getDirector() {
        return director;
    }

    public void setDirector(DirectorEntity director) {
        this.director = director;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
