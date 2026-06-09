package org.charrier.beesercitazione.dto.request;

public record AddUserResponse(
        String username,
        String ip,
        String msg
) {
}
