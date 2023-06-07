package com.codersdesks.committee.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceResponse<T> {
    private HttpStatus status;
    private String message;
    private T body;
    private List<Error> errors;

    public ServiceResponse(ResponseBuilder<T> builder) {
        this.body = builder.body;
        this.message = builder.message;
        this.errors = builder.errors;
        this.status = builder.status;
    }

    public static ResponseBuilder builder() {
        return new ServiceResponse.ResponseBuilder();
    }

    public static final class ResponseBuilder<T> {
        private HttpStatus status;
        private String message;
        private T body;
        private List<Error> errors;

        public ResponseBuilder status(HttpStatus status) {
            this.status = status;
            return this;
        }

        public ResponseBuilder body(T t) {
            this.body = t;
            return this;
        }

        public ResponseBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ResponseBuilder errors(List<Error> errors) {
            this.errors = errors;
            return this;
        }

        public ServiceResponse build() {
            return new ServiceResponse(this);
        }
    }
}
