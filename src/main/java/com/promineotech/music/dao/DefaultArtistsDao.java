package com.promineotech.music.dao;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import com.promineotech.music.entity.Artists;

@Component
public class DefaultArtistsDao implements ArtistsDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public Artists saveArtists(String artistName) {
    SqlParams params = generateInsertSql(artistName);

    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(params.sql, params.source, keyHolder);

    int id = keyHolder.getKey().intValue();
    
    //@formatter:off
    return Artists.builder()
        .id(id)
        .artistName(artistName)
        .build();
    //@formatter:on
  }


  private SqlParams generateInsertSql(String artistName) {
  //@formatter:off
    String sql = ""
        + "INSERT INTO artists ("
        + "artist_name"
        + ") VALUES ("
        + ":artist_name"
        + ")";
    //@formatter:off
    
    SqlParams params = new SqlParams();
    
    params.sql = sql;
    params.source.addValue("artist_name", artistName);
   
    
    return params;
  }
  
  class SqlParams {
    String sql;
    MapSqlParameterSource source = new MapSqlParameterSource();
  }

  @Override
  public Optional<String> fetchArtists(String artistName) {
    return Optional.of(artistName);
  }

}
