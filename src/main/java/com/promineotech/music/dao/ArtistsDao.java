package com.promineotech.music.dao;

import java.util.Optional;
import com.promineotech.music.entity.Artists;


public interface ArtistsDao {

  Artists saveArtists(String artistName);

  Optional<String> fetchArtists(String artistName);

}
