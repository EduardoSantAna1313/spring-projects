/**
 *
 */
package br.com.edu.start.controller;

import static br.com.edu.start.message.AppMessages.SUCCESSFULLY_SAVED;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.edu.start.AppException;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Eduardo
 */
@Getter
@Setter
public class ApiResponse extends ResponseEntity<String> {

    private String message;

    public ApiResponse(final String body, final HttpStatus status) {
        super(body, status);
    }

    public static ApiResponse success(final Object data) {
        final Response response = new Response(SUCCESSFULLY_SAVED, HttpStatus.OK.value());
        response.setData(data);
        return new ApiResponse(response.toString(), HttpStatus.OK);
    }

    public static ApiResponse error(final AppException error) {
        final Response response = new Response(error);

        return new ApiResponse(response.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
