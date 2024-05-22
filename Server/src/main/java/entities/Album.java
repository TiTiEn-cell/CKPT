package entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "albums")
public class Album {
	@Id
	@Column(name = "album_id")
	private String id;
	private String title;
	private double price;
	private int yearOfRelease;
	private String downloadLink;
	
	@ManyToOne
	@JoinColumn(name = "genre_id")
	private Genre genre;
	
	@ManyToMany
	@JoinTable(name = "albums_artists", 
				joinColumns = {@JoinColumn(name = "album_id")}, 
				inverseJoinColumns = {@JoinColumn(name = "artist_id")})
	private Set<Artist> artists;
	
	@ManyToMany
	@JoinTable(name = "albums_songs", 
				joinColumns = {@JoinColumn(name= "album_id")},
				inverseJoinColumns = {@JoinColumn(name = "song_id")})
	private Set<Song> songs;
	
	

	public Album() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Album(String id, String title, double price, int yearOfRelease, String downloadLink, Genre genre,
			Set<Artist> artists, Set<Song> songs) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.yearOfRelease = yearOfRelease;
		this.downloadLink = downloadLink;
		this.genre = genre;
		this.artists = artists;
		this.songs = songs;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getYearOfRelease() {
		return yearOfRelease;
	}

	public void setYearOfRelease(int yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}

	public String getDownloadLink() {
		return downloadLink;
	}

	public void setDownloadLink(String downloadLink) {
		this.downloadLink = downloadLink;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Set<Artist> getArtists() {
		return artists;
	}

	public void setArtists(Set<Artist> artists) {
		this.artists = artists;
	}

	public Set<Song> getSongs() {
		return songs;
	}

	public void setSongs(Set<Song> songs) {
		this.songs = songs;
	}

	@Override
	public String toString() {
		return "Album [id=" + id + ", title=" + title + ", price=" + price + ", yearOfRelease=" + yearOfRelease
				+ ", downloadLink=" + downloadLink + ", genre=" + genre + ", artists=" + artists + ", songs=" + songs
				+ "]";
	}
	
	
}
