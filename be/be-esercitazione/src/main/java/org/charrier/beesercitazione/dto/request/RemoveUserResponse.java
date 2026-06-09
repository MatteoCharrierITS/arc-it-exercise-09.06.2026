package org.charrier.beesercitazione.dto.request;

public record RemoveUserResponse(
        String username,
        String ip,
        String msg
) {
}
