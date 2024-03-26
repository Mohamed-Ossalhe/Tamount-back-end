package ma.tamount.backend.models.requests;

import ma.tamount.backend.models.responses.LocationResponse;

import java.sql.Timestamp;

public record SearchRequest(
        LocationResponse departure,
        LocationResponse arrival,
        Timestamp departureTime,
        Integer seats
) {
}
