package jqmicrosistemas.abacus.controller

import jqmicrosistemas.abacus.controllers.TSucursalJpaController
import jqmicrosistemas.abacus.controllers.TUsuariosJpaController
import jqmicrosistemas.abacus.model.TUsuarios
import jqmicrosistemas.abacus.service.LoginService
import jqmicrosistemas.abacus.service.SucursalService
import jqmicrosistemas.abacus.service.UsuarioService
import jqmicrosistemas.abacus.utilidades.CustomRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping(value = "/usuario", method = RequestMethod.POST)
class UsuarioController {


    @Autowired
    TUsuariosJpaController tUsuariosJpaController

    @Autowired
    SucursalService sucursalService


    @Autowired
    LoginService loginService

    @Autowired
    UsuarioService usuarioService

    @PostMapping("/get_usuarios")
    def getUsuarios(@RequestParam(name = "data", required = false, defaultValue = "") String data){

        CustomRequest request = new CustomRequest(data);

        //ID EMPRESA
//        println(loginService.getIdEmpresa(request.f_key))
//        println(tUsuariosJpaController.findByFEmpresa("1000"));


        request.f_data['usuario'] = tUsuariosJpaController.findByFEmpresa(loginService.getIdEmpresa(request.f_key) as Integer);
        request.f_data['status'] = "200"
        request.f_data['message'] = "Datos Obtenidos"

        return request
    }


    @PostMapping("/get_usuario")
    def getUsuario(@RequestParam(name = "data", required = false, defaultValue = "") String data) {

        CustomRequest request = new CustomRequest(data)


        //es vacio lo que mandan para f_data
        if(!request.f_data) {

            request.f_data['status'] = "500"
            request.f_data['message'] = "Parametros No Aceptados"
            request.f_data['usuario'] = []
            request.f_data['sucursales'] = []

            return request;
        }


        request.f_data['usuario'] = tUsuariosJpaController.findByFIdrecord(request.f_data['f_idrecord'] as Integer).first()
        request.f_data['sucursales'] = sucursalService.getSucursalesNombreAndID( loginService.getIdEmpresa(request.f_key) )

//        request.f_data['permisos_padre'] = usuarioService.getPermisos(request.f_data['f_idrecord'] as Long)
//        request.f_data['permisos_hijos'] = usuarioService.getPermisos(request.f_data['f_idrecord'] as Long)

        request.f_data['status'] = "200"
        request.f_data['message'] = "Datos Obtenidos"

//        println(request.f_data['sucursales']);

        return request

    }


    @RequestMapping(value="/set_usuario", method = RequestMethod.POST)
    def setUsuario(@RequestParam(name = "data", required = false, defaultValue = "") String data) {

        CustomRequest request = new CustomRequest(data)

        println("Data llegade desde Set USUARIOS frm usuarios")
        println(request.f_data)

        Integer id_empresa = loginService.getIdEmpresa(request.f_key) as Integer;

        TUsuarios tUsuarios = new TUsuarios(
                fUsername: request.f_data['fusername'] as String,
                fNombre: request.f_data['fnombre'] as String,
                fApellido: request.f_data['fapellido'] as String,
                fPassword: request.f_data['fpassword'] as String,
                fEmail: request.f_data['femail'] as String,
                fIdsucursal: request.f_data['fsucursal'] as Integer,
                fActivo: request.f_data['factivo'] as Boolean,
                fSuperUser: request.f_data['fsuperUser'] as Boolean,
                fDesactivaSoloCaja: request.f_data['fdesactivaSoloCaja'] as Boolean,
                fCajero: request.f_data['fcajero'] as Boolean,
                fTelefono: request.f_data['ftelefono'] as String,
                fIdtipo: request.f_data['fidtipo'] as Integer,
                fWebUser: request.f_data['fwebUser'] as Boolean,
                fIdidioma: request.f_data['fididioma'] as Integer,
                fCamarero: request.f_data['fcamarero'] as Boolean,
                fIdrecord: request.f_data['f_idrecord'] as Integer,
                fIdempresa: id_empresa
        )

        Integer id_record = request.f_data['f_idrecord'];


        if(id_record == 0){
            tUsuarios.setFIdrecord(null);
            request.f_data['message'] = tUsuariosJpaController.create(tUsuarios)
            //return user created
        }else{
            request.f_data['message'] = tUsuariosJpaController.edit(tUsuarios)
            //return user updated
        }

        request.f_data['usuario'] ='true';

        return request

    }

    @PostMapping("/get_permisos")
    def getPermisos(@RequestParam(name = "data", required = false, defaultValue = "") String data) {

        CustomRequest request = new CustomRequest(data)

        //es vacio lo que mandan para f_data
        if(!request.f_data) {

            request.f_data['status'] = "500"
            request.f_data['message'] = "Parametros No Aceptados"
            request.f_data['permisos'] = []

            return request;
        }


        request.f_data['permisos'] = usuarioService.getPermisos(request.f_data['f_idrecord'] as Long);
//        request.f_data['message'] ="Modificacion Exitosa";

        return request;
    }

}
