package dao;

import java.util.List;
import java.util.Map;

import entities.Album;

public interface AlbumDao {
	boolean updatePriceOfAlbum(String id, double newPrice);
	List<Album> listAlbumByGenre(String genreName);
	Map<String, Long> getNumberOfAlbumByGenre();
	
}
