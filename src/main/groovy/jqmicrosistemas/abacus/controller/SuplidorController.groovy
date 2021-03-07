package jqmicrosistemas.abacus.controller

import jqmicrosistemas.abacus.service.LoginService
import jqmicrosistemas.abacus.service.SuplidorService
import jqmicrosistemas.abacus.service.UtilidadesService
import jqmicrosistemas.abacus.utilidades.CustomRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class SuplidorController {


    @Autowired
    LoginService loginService

    @Autowired
    UtilidadesService utilidadesService

    @Autowired
    SuplidorService suplidorService

    @RequestMapping(value="/suplidores/get_suplidores", method = RequestMethod.POST)
    def getSuplidores(@RequestParam(name = "data", required = false, defaultValue = "") String data) {
        CustomRequest request = new CustomRequest(data)
        request.f_data['suplidores'] = suplidorService.getSuplidores(loginService.getIdEmpresa(request.f_key), request.f_data.params as String)
        return request
    }

    @RequestMapping(value="/suplidores/get_suplidor", method = RequestMethod.POST)
    def getSuplidor(@RequestParam(name = "data", required = false, defaultValue = "") String data) {
        CustomRequest request = new CustomRequest(data)
        request.f_data = suplidorService.getSuplidor(loginService.getIdEmpresa(request.f_key), request.f_data.f_idrecord as Long)
        return request
    }

    @RequestMapping(value="/suplidores/set_suplidores", method = RequestMethod.POST)
    def setSuplidor(@RequestParam(name ="data", required = false, defaultValue ="") String data) {
        CustomRequest request = new CustomRequest(data)
        suplidorService.setSuplidor(request.f_data, loginService.getIdEmpresa(request.f_key))
        request.f_key = "1"
        return request
    }

    @RequestMapping(value="/suplidores/get_cuenta_contable", method = RequestMethod.POST)
    def getCuentaContable(@RequestParam(name ="data", required = false, defaultValue ="") String data) {
        CustomRequest request = new CustomRequest(data)
         request.f_data['cuentas'] = suplidorService.getCuentasContables(loginService.getIdEmpresa(request.f_key))
        request.f_key = "1"
        return request
    }

}
