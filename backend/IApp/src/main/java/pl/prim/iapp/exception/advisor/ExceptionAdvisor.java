package pl.prim.iapp.exception.advisor;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.prim.iapp.exception.ex.*;

import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
public class ExceptionAdvisor {

    @ExceptionHandler(value = {InvalidInputEx.class})
    public ResponseEntity<ErrorResponse> handleInvalidInputException(@NotNull InvalidInputEx ex) {
        log.error("InvalidInputException: {} ", ex.getMessage());

        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ErrorResponse errorResponse = createErrorResponse(ex.getMessage(), httpStatus);

        return new ResponseEntity<>(errorResponse, httpStatus);
    }

    @ExceptionHandler(value = {ForbiddenEx.class})
    public ResponseEntity<ErrorResponse> handleForbiddenException(@NotNull ForbiddenEx ex) {
        log.error("ForbiddenException: {} ", ex.getMessage());
        HttpStatus httpStatus = HttpStatus.FORBIDDEN;
        ErrorResponse errorResponse = createErrorResponse(ex.getMessage(), httpStatus);

        return new ResponseEntity<>(errorResponse, httpStatus);
    }

    @ExceptionHandler(value = {EntityAlreadyExistsEx.class})
    public ResponseEntity<ErrorResponse> handleAlreadyExistsException(@NotNull EntityAlreadyExistsEx ex) {
        log.error("EntityAlreadyExistsException: {} ", ex.getMessage());

        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ErrorResponse errorResponse = createErrorResponse(ex.getMessage(), httpStatus);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {EntityNotFoundEx.class})
    public ResponseEntity<ErrorResponse> handleEntityNotFoundException(@NotNull EntityNotFoundEx ex) {
        log.error("EntityNotFoundException: {} ", ex.getMessage());

        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ErrorResponse errorResponse = createErrorResponse(ex.getMessage(), httpStatus);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {BadRequestEx.class})
    public ResponseEntity<ErrorResponse> handleBadRequestException(@NotNull BadRequestEx ex) {
        log.error("BadRequestException: {} ", ex.getMessage());

        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ErrorResponse errorResponse = createErrorResponse(ex.getMessage(), httpStatus);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    private ErrorResponse createErrorResponse(String message, HttpStatus httpStatus) {
        return ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .statusCode(httpStatus.value())
                .httpStatus(httpStatus)
                .error(message)
                .build();
    }

}
