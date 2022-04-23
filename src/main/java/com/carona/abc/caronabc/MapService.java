package com.carona.abc.caronabc;

import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
public class MapService {

    private final String apiKey = "5b3ce3597851110001cf624822f9170a3be2483e8681d85f65f928ce";

    Client client = ClientBuilder.newClient();

    public String getGeolocation(@NotNull String address) throws URISyntaxException {
        StringBuilder url = new StringBuilder();
        url.append("https://api.openrouteservice.org/geocode/search?api_key=")
                .append(apiKey)
                .append("&text=")
                .append(address)
                .append("&boundary.country=BR");
        URI uri = new URI(url.toString().replace(" ","%20"));
        log.info("Requested url: {}",uri);

        String response = client.target(uri)
                .request(MediaType.TEXT_PLAIN_TYPE)
                .header("Accept", "application/json, application/geo+json, application/gpx+xml, img/png; charset=utf-8")
                .get()
                .readEntity(String.class);
        log.info("response: {}",response);

        StringBuilder coordinates = new StringBuilder();
        for (int i = response.indexOf("coordinates") + 14; i < response.length(); i++) {
            if (response.charAt(i) == ']') {
                break;
            }
            coordinates.append(response.charAt(i));
        }
        log.info("coordinates: {}", coordinates.toString());
        System.out.println();

        return coordinates.toString();
    }

    public void getDirections(String initialAddress, String finalAddress) throws URISyntaxException {
        StringBuilder url = new StringBuilder();
        url.append("https://api.openrouteservice.org/v2/directions/driving-car?api_key=")
                .append(apiKey)
                .append("&start=")
                .append(getGeolocation(initialAddress))
                .append("&end=")
                .append(getGeolocation(finalAddress));
        URI uri = new URI(url.toString().replace(" ","%20"));
        log.info("Requested url: {}",uri);

        Response response = client.target(uri)
                .request(MediaType.TEXT_PLAIN_TYPE)
                .header("Accept", "application/json, application/geo+json, application/gpx+xml, img/png; charset=utf-8")
                .get();
        log.info("Directions status: {}",response.getStatus());
        log.info("Directions headers: {}",response.getHeaders());
        log.info("Directions body: {}",response.readEntity(String.class));
        //TODO: return something
    }
}
