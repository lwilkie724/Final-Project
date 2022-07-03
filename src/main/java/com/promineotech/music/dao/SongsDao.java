package com.promineotech.music.dao;


import java.util.Optional;
import com.promineotech.music.entity.Songs;

public interface SongsDao {

 


  Songs saveSongs(String songName, int album);


  Optional<String> fetchSongName( String songName);


  Optional<Integer> fetchAlbum(int album);









 



  









}
