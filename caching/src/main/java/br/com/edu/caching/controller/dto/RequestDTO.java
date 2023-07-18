/* (C)2023 */
package br.com.edu.caching.controller.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDTO {

    @JsonAlias("client_id")
    private String clientId;
}
