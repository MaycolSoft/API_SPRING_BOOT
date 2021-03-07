package jqmicrosistemas.abacus.controller

import jqmicrosistemas.abacus.service.LoginService
import jqmicrosistemas.abacus.service.UtilidadesService
import jqmicrosistemas.abacus.utilidades.CustomRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController {

    @Autowired
    UtilidadesService utilidadesService

    @Autowired
    LoginService loginService

    @RequestMapping(value="/home/get_data_chart", method = RequestMethod.POST)
    def getDataToChart(@RequestParam(name = "data", required = false, defaultValue = "") String data) {
        CustomRequest request = new CustomRequest(data)
        request.f_data['data_chart'] = utilidadesService.getDataToChart(loginService.getIdEmpresa(request.f_key))
        request.f_data['data_chart_sucursal'] = utilidadesService.getSalesBySucursal(loginService.getIdEmpresa(request.f_key))

        if (request.f_data.isEmpty()) {
            request.f_key = "-1"
        }

        return request
    }


}
