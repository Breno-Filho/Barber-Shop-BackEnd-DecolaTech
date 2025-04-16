package br.com.dio.barbershopui.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.springframework.http.ResponseEntity;

import java.time.OffsetDateTime;

public record ProblemResponse(
        @JsonProperty("status") Integer status,
        @JsonProperty("timestamp") OffsetDateTime timestamp,
        @JsonProperty("message") String message) {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Integer status;
        private OffsetDateTime timestamp;
        private String message;

        public Builder status(Integer status) {
            this.status = status;
            return this;
        }

        public Builder timestamp(OffsetDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public ProblemResponse build() {
            return new ProblemResponse(status, timestamp, message);
        }
    }
}