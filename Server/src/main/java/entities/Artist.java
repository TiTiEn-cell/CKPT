package entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "artists")
public class Artist {
	@Id
	@Column(name = "artist_id")
	private String id;
	private String name;
	private LocalDate birthDate;
	private String url;
	public Artist() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Artist(String id, String name, LocalDate birthDate, String url) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.url = url;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Artist [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", url=" + url + "]";
	}
	
	
}
