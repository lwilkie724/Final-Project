package com.promineotech.music.entity;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Albums {
 @JsonIgnore
  private int id;
 @NotNull
  private String albumName;
 @NotNull
 private int artist;
}
