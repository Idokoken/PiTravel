package ndgroups.PiTravel.controller;

import ndgroups.PiTravel.service.Interface.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("%{api.prefix}/flights")
public class FlightController {
    @Autowired
    private IFlightService flightService;
}
