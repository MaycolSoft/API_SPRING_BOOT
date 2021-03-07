package jqmicrosistemas.abacus.controller

import jqmicrosistemas.abacus.service.LoginService
import jqmicrosistemas.abacus.utilidades.CustomRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class LoginController {

    @Autowired
    LoginService loginService

    @RequestMapping(value="/login/autenticate", method = RequestMethod.POST)
    def autenticate(@RequestParam(name = "data", required = false, defaultValue = "") String data) {
        CustomRequest request = new CustomRequest(data)
        request.f_data = loginService.autenticate(request.f_data?.f_username?.toString(),request.f_data?.f_password?.toString(),request.f_data?.f_idempresa?.toString()?.toLong())

        if (request.f_data.isEmpty()) {
            request.f_key = "-1"
        }

        return request
    }

}
