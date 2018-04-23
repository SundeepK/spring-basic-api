package com.sundeepk.spring.basic.api.controller;

import com.sundeepk.spring.basic.api.domain.error.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Component
@ControllerAdvice
public class ExceptionHandlerController {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler
    @ResponseStatus(value=HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse requestHandlingNoHandlerFound(HttpServletRequest request, final NoHandlerFoundException ex) {
        return new ErrorResponse("Not found");
    }

    @ExceptionHandler(HttpStatusCodeException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleHttpStatusCodeException(HttpServletRequest request, HttpStatusCodeException e) {
        String errorReponse = e.getResponseBodyAsString();
        logger.warn("Internal error url={} with response {}", getRequestUrl(request), errorReponse, e);
        return new ErrorResponse(errorReponse);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(HttpServletRequest request, Exception e) {
        String requestUrl = getRequestUrl(request);
        logger.error("Caught unhandled exception from url={}", requestUrl, e);
        return new ErrorResponse(e.getMessage());
    }

    private static String getRequestUrl(HttpServletRequest request) {
        return request.getRequestURL().toString();
    }

}