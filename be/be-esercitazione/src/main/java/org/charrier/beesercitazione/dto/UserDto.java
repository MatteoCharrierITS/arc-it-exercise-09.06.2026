package org.charrier.beesercitazione.dto;

public record UserDto(
        Integer id,
        String username,
        String ip
) {
    
    public String getUsername()
    {
        return username;
    }
    
    public String getIp()
    {
        return ip;
    }
}
