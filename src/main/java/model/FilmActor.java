package model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="film_actor")
@NamedQuery(name="FilmActor.findAll", query="SELECT af FROM FilmActor af")
@IdClass(FilmActorById.class)
public class FilmActor implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="actor_id", unique=true, nullable=false)
	private int actorId;
	
	@Id
	@Column(name="film_id", unique=true, nullable=false)
	private int filmId;
	
	@Column(name="last_update", nullable=false)
	private Timestamp lastUpdate;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="actor_id", referencedColumnName = "actor_id")
	private Actor actor;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="film_id", referencedColumnName = "film_id")
	private Film film;
	
	public FilmActor() {
	}
	
	public int getActorId() {
		return this.actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}
	
	public int getFilmId() {
		return this.filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}
	
	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	public Film getFilm() {
		return film;
	} 

	public void setFilm(Film film) {
		this.film = film;
	}
	
	
}