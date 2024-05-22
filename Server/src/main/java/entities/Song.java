package entities;

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
@AllArgsConstructor
@NoArgsConstructor
@ToString	
@Table(name = "songs")
public class Song {
	@Id
	@Column(name = "song_id")
	private String id;
	private String name;
	private String runtime;
	private String lyric;
	public Song() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Song(String id, String name, String runtime, String lyric) {
		super();
		this.id = id;
		this.name = name;
		this.runtime = runtime;
		this.lyric = lyric;
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
	public String getRuntime() {
		return runtime;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	public String getLyric() {
		return lyric;
	}
	public void setLyric(String lyric) {
		this.lyric = lyric;
	}
	@Override
	public String toString() {
		return "Song [id=" + id + ", name=" + name + ", runtime=" + runtime + ", lyric=" + lyric + "]";
	}
	
	
}
