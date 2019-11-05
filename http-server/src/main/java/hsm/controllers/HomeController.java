package hsm.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/test" , method = RequestMethod.POST, produces = {"application/json"})
    public Object test1(@RequestBody hsm.models.TestModel o ) {
        return o;
    }
}
