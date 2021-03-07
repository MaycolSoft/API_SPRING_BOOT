package jqmicrosistemas.abacus.controller

import jqmicrosistemas.abacus.service.ClienteService
import jqmicrosistemas.abacus.service.LoginService
import jqmicrosistemas.abacus.service.UtilidadesService
import jqmicrosistemas.abacus.utilidades.CustomRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ClienteController {

    @Autowired
    ClienteService clienteService

    @Autowired
    LoginService loginService

    @Autowired
    UtilidadesService utilidadesService

    @RequestMapping(value="/cliente/get_clientes", method = RequestMethod.POST)
    def getClientes(@RequestParam(name = "data", required = false, defaultValue = "") String data) {
        CustomRequest request = new CustomRequest(data)
        request.f_data['clientes'] = clienteService.getClientes(loginService.getIdEmpresa(request.f_key), request.f_data.params as String)
        return request
    }

    @RequestMapping(value="/cliente/get_data_combo", method = RequestMethod.POST)
    def getDataCombo(@RequestParam(name = "data", required = false, defaultValue = "") String data) {
        CustomRequest request = new CustomRequest(data)
        request.f_data['tipo_clientes'] = utilidadesService.getTipoCliente(loginService.getIdEmpresa(request.f_key))
        request.f_data['zonas'] = utilidadesService.getZonas(loginService.getIdEmpresa(request.f_key))
        request.f_data['lista_ncf'] = utilidadesService.getNCFList(loginService.getIdEmpresa(request.f_key))
        request.f_data['monedas'] = utilidadesService.getMonedas(loginService.getIdEmpresa(request.f_key))
        request.f_data['sucursales'] = utilidadesService.getSucursales(loginService.getIdEmpresa(request.f_key))
        request.f_key = "1"
        return request
    }

    @RequestMapping(value="/cliente/set_cliente", method = RequestMethod.POST)
    def setCliente(@RequestParam(name="data", required = false, defaultValue = "") String data){
        CustomRequest request = new CustomRequest(data)
        clienteService.setCliente(request.f_data,loginService.getIdEmpresa(request.f_key))
        request.f_key = "1"
        request.f_data = [:]
        return request
    }
    @RequestMapping(value="/cliente/get_cliente", method = RequestMethod.POST)
    def getCliente(@RequestParam(name="data", required = false, defaultValue = "") String data){
        CustomRequest request = new CustomRequest(data)
        request.f_data = clienteService.getClienteById(request.f_data.f_idrecord as Long,loginService.getIdEmpresa(request.f_key))
        request.f_key = "1"
        return request
    }
}
