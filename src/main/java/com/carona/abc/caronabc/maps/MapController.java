package com.carona.abc.caronabc.maps;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.net.URISyntaxException;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/map")
public class MapController {

    private final MapService mapService;

    @GetMapping("/coordinates")
    public String generateCoordinates(@RequestParam String address) throws URISyntaxException {
        return mapService.getGeolocation(address);
    }

    @GetMapping("/geojson")
    public String generateGeoJson(@RequestParam String initialAddress,
                                  @RequestParam String finalAddress) throws URISyntaxException {
        return mapService.getDirections(initialAddress,finalAddress);
    }

    @GetMapping("/address")
    public ModelAndView addressForm(ModelMap modelMap) {
        modelMap.addAttribute("mapDAO", new MapDAO());
        return new ModelAndView("address");
    }

    @PostMapping("/address")
    public ModelAndView updateMapDirections(@ModelAttribute MapDAO mapDAO, ModelMap modelMap) throws URISyntaxException {
        modelMap.addAttribute("geoJsonDirections",
                mapService.getDirections(mapDAO.getInitialAddress(),mapDAO.getFinalAddress()));
        return new ModelAndView("map");
    }
}
