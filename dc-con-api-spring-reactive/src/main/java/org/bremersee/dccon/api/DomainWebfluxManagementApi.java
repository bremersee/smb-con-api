/*
 * Copyright 2019 the original author or authors.
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

package org.bremersee.dccon.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.bremersee.dccon.model.Password;
import org.bremersee.dccon.model.PasswordInformation;
import org.bremersee.exception.model.RestApiException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reactor.core.publisher.Mono;

/**
 * The domain management api.
 *
 * @author Christian Bremer
 */
@Api(value = "DomainManagement")
@Validated
public interface DomainWebfluxManagementApi {

  /**
   * Get password information.
   *
   * @return the password information
   */
  @ApiOperation(
      value = "Get password information.",
      nickname = "getPasswordInformation",
      notes = "Get password information.",
      response = PasswordInformation.class,
      tags = {"domain-management-controller"})
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "The password information.",
          response = PasswordInformation.class),
      @ApiResponse(code = 500, message = "Fatal server error.",
          response = RestApiException.class)
  })
  @RequestMapping(
      value = "/api/domain/password-information",
      produces = {"application/json"},
      method = RequestMethod.GET)
  Mono<PasswordInformation> getPasswordInformation();

  /**
   * Gets random password.
   *
   * @return the random password
   */
  @ApiOperation(
      value = "Get a random password.",
      nickname = "getRandomPassword",
      notes = "Get a random password.",
      response = Password.class,
      tags = {"domain-management-controller"})
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "The random password.",
          response = Password.class),
      @ApiResponse(code = 500, message = "Fatal server error.",
          response = RestApiException.class)
  })
  @RequestMapping(
      value = "/api/domain/random-password",
      produces = {"application/json"},
      method = RequestMethod.GET)
  Mono<Password> getRandomPassword();

}