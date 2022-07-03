package com.promineotech.music.dao;


import java.util.Optional;
import com.promineotech.music.entity.Albums;

public interface AlbumsDao {





  Optional<String> fetchAlbumName(String albumName);

  Optional<Integer> fetchArtist(int artist);

  Albums saveAlbums(String albumName, int artist);





 
}
