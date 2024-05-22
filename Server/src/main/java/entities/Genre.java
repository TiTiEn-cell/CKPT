package entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "genres")
public class Genre {
	@Id
	@Column(name = "genre_id")
	private String id;
	private String name;
	private String description;
	
	@ToString.Exclude
	@OneToMany(mappedBy = "genre")
	private Set<Album> albums;

	public Genre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Genre(String id, String name, String description, Set<Album> albums) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.albums = albums;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}

	@Override
	public String toString() {
		return "Genre [id=" + id + ", name=" + name + ", description=" + description + ", albums=" + albums + "]";
	}
	
	
}
