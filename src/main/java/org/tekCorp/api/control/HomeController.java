package org.tekCorp.api.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Inspiron on 15/06/2015.
 */
@RestController
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "Welcome at Home";
    }
}
