/*
 * Copyright 2019-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.bremersee.dccon.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import java.io.Serializable;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The windows/samba SID. Well known (system) SIDs are listed
 * <a href="https://support.microsoft.com/en-us/help/243330/well-known-security-identifiers-in-windows-operating-systems">here</a>.
 *
 * @author Christian Bremer
 */
@Schema(description = "The SID of the entity.")
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Sid implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty(value = "value", required = true)
  private String value = null;

  @JsonProperty(value = "systemEntity")
  private Boolean systemEntity;

  /**
   * Instantiates a new SID.
   *
   * @param value the value
   * @param systemEntity the system entity
   */
  @SuppressWarnings("unused")
  @Builder(toBuilder = true)
  public Sid(String value, Boolean systemEntity) {
    setValue(value);
    setSystemEntity(systemEntity);
  }

  /**
   * Gets value.
   *
   * @return the value
   */
  @Schema(
      description = "The SID of the entity.",
      accessMode = AccessMode.READ_ONLY)
  public String getValue() {
    return value;
  }

  /**
   * Sets value.
   *
   * @param value the value
   */
  public void setValue(String value) {
    this.value = value;
  }

  /**
   * Gets system entity.
   *
   * @return the system entity
   */
  @Schema(
      description = "Tells whether the entity is a system entity or not.",
      accessMode = AccessMode.READ_ONLY)
  public Boolean getSystemEntity() {
    return systemEntity;
  }

  /**
   * Sets system entity.
   *
   * @param systemEntity the system entity
   */
  public void setSystemEntity(Boolean systemEntity) {
    this.systemEntity = systemEntity;
  }

}
