package com.carona.abc.caronabc.maps;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@Service
public class MapService {

    private String apiKey = "5b3ce3597851110001cf624822f9170a3be2483e8681d85f65f928ce";

    Client client = ClientBuilder.newClient();

    public String getGeolocation(@NotNull String address) throws URISyntaxException {
        StringBuilder url = new StringBuilder();
        url.append("https://api.openrouteservice.org/geocode/search?api_key=")
                .append(apiKey)
                .append("&text=")
                .append(address)
                .append("&boundary.country=BR");
        URI uri = new URI(url.toString().replace(" ","%20"));

        String response = client.target(uri)
                .request(MediaType.TEXT_PLAIN_TYPE)
                .header("Accept", "application/json, application/geo+json, application/gpx+xml, img/png; charset=utf-8")
                .get()
                .readEntity(String.class);

        String coordinates = "";
        for (int i = response.indexOf("coordinates") + 14; i < response.length(); i++) {
            if (response.charAt(i) == ']') {
                break;
            }
            coordinates += response.charAt(i);
        }
        log.info("Coordinates for '{}': {}", address, coordinates);
        return coordinates;
    }

    public String getDirections(String initialAddress, String finalAddress) throws URISyntaxException {
        StringBuilder url = new StringBuilder();
        url.append("https://api.openrouteservice.org/v2/directions/driving-car?api_key=")
                .append(apiKey)
                .append("&start=")
                .append(getGeolocation(initialAddress))
                .append("&end=")
                .append(getGeolocation(finalAddress));
        URI uri = new URI(url.toString().replace(" ","%20"));

        String response = client.target(uri)
                .request(MediaType.TEXT_PLAIN_TYPE)
                .header("Accept", "application/json, application/geo+json, application/gpx+xml, img/png; charset=utf-8")
                .get()
                .readEntity(String.class);
        return response;
    }
}
