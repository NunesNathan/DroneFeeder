package com.futuereh.dronefeeder.exception;

import com.futuereh.dronefeeder.exception.exceptions.BadRequestDelivery;
import com.futuereh.dronefeeder.exception.exceptions.BadRequestDrone;
import com.futuereh.dronefeeder.exception.exceptions.BadRequestStatus;
import com.futuereh.dronefeeder.exception.exceptions.BadRequestType;
import com.futuereh.dronefeeder.exception.exceptions.DataError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {
  @ExceptionHandler({BadRequestDrone.class, BadRequestDelivery.class,
          BadRequestStatus.class, BadRequestType.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public DataError handleRecursoExistente(RuntimeException e) {
    return new DataError(e.getMessage());
  }
}
