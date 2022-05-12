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
public class MapController {

    private final MapService mapService;

    @RequestMapping("/address/{initialAddress}/{finalAddress}")
    public ModelAndView addressForm(ModelMap modelMap,
                                    @PathVariable(value = "initialAddress") String initialAddress,
                                    @PathVariable(value = "finalAddress") String finalAddress) throws URISyntaxException {
        modelMap.addAttribute("geoJsonDirections",
                mapService.getDirections(initialAddress,finalAddress));

        return new ModelAndView("map");
    }
}
