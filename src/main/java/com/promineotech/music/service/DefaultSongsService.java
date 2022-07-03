package com.promineotech.music.service;


import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.music.dao.SongsDao;
import com.promineotech.music.entity.Songs;

@Service

public class DefaultSongsService implements SongsService {

  @Autowired
  private SongsDao songsDao;
  
  @Transactional
  @Override
  public Songs createSongs(Songs song) {
    String songName = getSongName(song);
    int album = getAlbum(song);
       
    return songsDao.saveSongs(songName, album);    
  
  }

  private int getAlbum(Songs song) {
    return songsDao.fetchAlbum(song.getAlbum())
        .orElseThrow(() -> new NoSuchElementException(
            "The album " + song.getAlbum() + " was not found"));
  }

  private String getSongName(Songs song) {
    return songsDao.fetchSongName(song.getSongName())
        .orElseThrow(() -> new NoSuchElementException(
            "The song" + song.getSongName() + " was not found"));
  }


  
   
}
