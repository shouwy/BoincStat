package org.tekCorp.api.control;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shouwy on 03/07/2015.
 */
@RestController
@RequestMapping(value="/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsersController {
}
