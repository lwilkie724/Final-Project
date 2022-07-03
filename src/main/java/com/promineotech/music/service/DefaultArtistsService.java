package com.promineotech.music.service;

import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.music.dao.ArtistsDao;
import com.promineotech.music.entity.Artists;

@Service
public class DefaultArtistsService implements ArtistsService{

  @Autowired
  private ArtistsDao artistsDao;
  
  @Transactional
  @Override
  public Artists createArtists(Artists artistName) {
    String artist = getArtists(artistName);

    return artistsDao.saveArtists(artist);
  }

  private String getArtists(Artists artistName) {
    return artistsDao.fetchArtists(artistName.getArtistName())
        .orElseThrow(() -> new NoSuchElementException(
            "Artist with the name of " + artistName.getArtistName() + " was not found"));
  }  
}
