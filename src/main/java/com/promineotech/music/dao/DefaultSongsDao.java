package com.promineotech.music.dao;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.promineotech.music.entity.Songs;

@Component
public class DefaultSongsDao implements SongsDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
public Songs saveSongs(String songName, int album) {
    SqlParams params = generateInsertSql(songName, album);

    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(params.sql, params.source, keyHolder);

    int id = keyHolder.getKey().intValue();
    
    //@formatter:off
    return Songs.builder()
        .id(id)
        .songName(songName)
        .album(album)
        .build();
    //@formatter:on
  }


  private SqlParams generateInsertSql(String songName, int album) {
  //@formatter:off
    String sql = ""
        + "SELECT * ("
        + "song_name, album"
        + ") VALUES("
        + ":song_name, :album"
        + ")";
    //@formatter:off
    
    SqlParams params = new SqlParams();
    
    params.sql = sql;
    params.source.addValue("song_name", songName);
    params.source.addValue("album", album);
    
    return params;
  }
  
  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }

  @Override
  public Optional<String> fetchSongName(String songName) {
    return Optional.of(songName);
  }


  @Override
  public Optional<Integer> fetchAlbum(int album) {
       return Optional.of(album);
  }




 
  

}
