package com.promineotech.music.service;

import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.promineotech.music.dao.AlbumsDao;
import com.promineotech.music.entity.Albums;

@Component
public class DefaultAlbumsService implements AlbumsService {

  @Autowired
  private AlbumsDao albumsDao;
  
  @Override
  public Albums createAlbums(Albums album) {
    String albumName = getAlbumName(album);
    int artist = getArtist(album);
    
    
    return albumsDao.saveAlbums(albumName, artist);
  }


  private int getArtist(Albums album) {
    return albumsDao.fetchArtist(album.getArtist())
        .orElseThrow(() -> new NoSuchElementException(
            "The artist corresponding with the album " + album.getArtist() + " was not found"));
  }


  private String getAlbumName(Albums album) {
    
    return albumsDao.fetchAlbumName(album.getAlbumName())
        .orElseThrow(() -> new NoSuchElementException(
            "Album with the title " + album.getAlbumName() + " was not found"));
  }

  




  
  

}
