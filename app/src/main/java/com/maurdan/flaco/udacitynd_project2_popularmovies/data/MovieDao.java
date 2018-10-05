package com.maurdan.flaco.udacitynd_project2_popularmovies.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.maurdan.flaco.udacitynd_project2_popularmovies.model.Movie;

import java.util.List;

@Dao
public interface MovieDao {

    @Query("SELECT * FROM movie")
    List<Movie> loadAll();

    @Query("SELECT * FROM movie WHERE id = :id")
    Movie loadMovie(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long addMovie(Movie movie);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long addMovies(Movie... movies);

    @Update
    void updateMovie(Movie movie);

    @Update
    void updateMovies(Movie... movies);

    @Delete
    void deleteMovie(Movie movie);

    @Delete
    void deleteMovies(Movie... movies);

}
