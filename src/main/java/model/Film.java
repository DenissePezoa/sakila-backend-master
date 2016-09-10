package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the film database table.
 * 
 */
@Entity
@Table(name="film") 
@NamedQuery(name="Film.findAll", query="SELECT f FROM Film f")
public class Film implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="film_id", unique=true, nullable=false)
	private int filmId;

	@Column(name="title", nullable=false, length=255)
	private String title;

	@Column(name="description", nullable=false, length=1000)
	private String description;

	@Column(name="release_year", nullable=false)
	private int release_year;
	
	@Column(name="original_language_id", nullable=true)
	private int original_language_id;
	
	@Column(name="rental_duration", nullable=false)
	private int rental_duration;
	
	@Column(name="rental_rate", nullable=false)
	private float rental_rate;
	
	@Column(name="length", nullable=false)
	private int length;
	
	@Column(name="replacement_cost", nullable=false)
	private float replacement_cost;
	
	@Column(name="rating", nullable=false)
	private String rating;
	
	@Column(name="special_features", nullable=false)
	private String special_features;
	
	@Column(name="last_update", nullable=false)
	private Timestamp lastUpdate;
	
	@OneToMany(mappedBy="film")
	private List<FilmActor> actors; //lista de todo lo que tiene relacion con el actor
	
	public Film() {
	}

	List<FilmActor> getActors() {
		return actors;
	}

	void setActors(List<FilmActor> actors) {
		this.actors = actors;
	}
	
	
	//obtiene actor
	public List<Actor> obtenerActor(){
		List<Actor> a = new ArrayList<Actor>();
		
	for(FilmActor ACtor : this.actors){
			a.add(ACtor.getActor());
		}
		return a;
	}
	
	
	
			
	public int getFilmId() {
		return this.filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}
	
	public String getFilmTitle() {
		return this.title;
	}

	public void setFilmTitle(String title) {
		this.title = title;
	}
	
	public String getFilmDescription() {
		return this.description;
	}

	public void setFilmDescription(String description) {
		this.description = description;
	}
	
	public int getFilmRelease_year() {
		return this.release_year;
	}

	public void setFilmRelease_year(int release_year) {
		this.release_year = release_year;
	}
	
	public int getFilmOriginal_language_id() {
		return this.original_language_id;
	}

	public void setFilmOriginal_language_id(int original_language_id) {
		this.original_language_id = original_language_id;
	}
	
	public int getFilmRental_duration() {
		return this.rental_duration;
	}

	public void setFilmRental_duration(int rental_duration) {
		this.rental_duration = rental_duration;
	}
	
	public float getFilmRental_rate() {
		return this.rental_rate;
	}

	public void setFilmRental_rate(float rental_rate) {
		this.rental_rate = rental_rate;
	}
	
	public int getFilmLength() {
		return this.rental_duration;
	}

	public void setFilmLength(int length) {
		this.length = length;
	}
	
	public float getFilmReplacement_cost() {
		return this.replacement_cost;
	}

	public void setFilmReplacement_cost(float replacement_cost) {
		this.replacement_cost = replacement_cost;
	}
	
	public String getFilmRating() {
		return this.rating;
	}

	public void setFilmRating(String rating) {
		this.rating = rating;
	}
	
	public String getFilmSpecial_features() {
		return this.special_features;
	}

	public void setFilmSpecial_features(String special_features) {
		this.special_features = special_features;
	}
	
	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
}