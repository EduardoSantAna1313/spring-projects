package br.com.edu.start.controller;

import org.springframework.http.HttpStatus;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.edu.start.AppException;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Eduardo
 */
@Getter
@Setter
public class Response {

    private String message;

    private Object data;

    private Integer code;

    public Response(final String message, final Integer code) {
        super();
        this.message = message;
        this.code = code;
    }

    public Response(final AppException error) {
        this.message = error.getMessage();
        this.code = HttpStatus.INTERNAL_SERVER_ERROR.value();
    }

    @Override
    public String toString() {
        final Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }

}
