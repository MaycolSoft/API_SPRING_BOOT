package jqmicrosistemas.abacus.service

import grails.converters.JSON
import jqmicrosistemas.abacus.database.Sql
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UsuarioService {
    @Autowired
    Sql sql

    List getUsuarios(Long idempresa, String params) {
        String query = "select * from t_usuarios u where u.f_idempresa=${idempresa}"
        return sql.executeQueryAsList(query)
    }

    Map getUsuario(Long idempresa, Long idrecord) {
        String query = "select   u.f_idrecord,\n" +
                "  u.f_idempresa,\n" +
                "  u.f_username,\n" +
                "  u.f_activo,\n" +
                "  u.f_idtipo,\n" +
                "  u.f_ididioma,\n" +
                "  u.f_camarero,\n" +
                "  u.f_nombre,\n" +
                "  u.f_apellido,\n" +
                "  u.f_email,\n" +
                "  u.f_telefono,\n" +
                "  u.f_idsucursal,\n" +
                "  u.f_super_user,\n" +
                "  u.f_web_user,\n" +
                "  u.f_cajero,\n" +
                "  u.f_desactiva_solo_caja  " +
                "from t_usuarios u where u.f_idempresa=${idempresa} and f_idrecord=${idrecord}"
        return sql.executeQueryAsMap(query)
    }

    boolean setUsuarios(Map data, Long idempresa) {

        String query = ""

        if ((data['f_idrecord'] as Long) > 0) {

            query = "\n" +
                    "UPDATE \n" +
                    "  public.t_usuarios \n" +
                    "SET \n " +
                    "  f_username ='${data.f_username}' ,\n" +
                    "  f_password =  case when length(${data.f_password})>5 then '${data.f_password}' else f_password end \n" +
                    "  f_activo = ?f_activo,\n" +
                    "  f_ididioma = ?f_ididioma,\n" +
                    "  f_nombre = ?f_nombre,\n" +
                    "  f_apellido = ?f_apellido,\n" +
                    "  f_cambio_precio = ?f_cambio_precio,\n" +
                    "  f_abrir_caja = ?f_abrir_caja,\n" +
                    "  f_descuento = ?f_descuento,\n" +
                    "  f_factura_credito = ?f_factura_credito,\n" +
                    "  f_cuadre = ?f_cuadre,\n" +
                    "  f_estado_caja = ?f_estado_caja,\n" +
                    "  f_factura_oficial = ?f_factura_oficial,\n" +
                    "  f_anular_linea = ?f_anular_linea,\n" +
                    "  f_recibo = ?f_recibo,\n" +
                    "  f_porciento_ley = ?f_porciento_ley,\n" +
                    "  f_taxfree = ?f_taxfree,\n" +
                    "  f_email = ?f_email,\n" +
                    "  f_telefono = ?f_telefono,\n" +
                    "  f_anular_factura = ?f_anular_factura,\n" +
                    "  f_tipo_usuario_punto_venta = ?f_tipo_usuario_punto_venta,\n" +
                    "  f_activar_pedidos = ?f_activar_pedidos\n" +
                    " WHERE \n" +
                    "  f_idrecord = ${data.f_idrecord} and  f_idempresa = ${data.idempresa} ;"
        }

        else {
            query = " INSERT INTO \n" +
                    "  public.t_usuarios\n" +
                    "(\n" +
                    "  f_idempresa,\n" +
                    "  f_username,\n" +
                    "  f_password,\n" +
                    "  f_activo,\n" +
                    "  f_idtipo,\n" +
                    "  f_ididioma,\n" +
                    "  f_camarero,\n" +
                    "  f_nombre,\n" +
                    "  f_apellido,\n" +
                    "  f_email,\n" +
                    "  f_telefono,\n" +
                    "  f_idsucursal,\n" +
                    "  f_super_user,\n" +
                    "  f_web_user,\n" +
                    "  f_cajero,\n" +
                    "  f_desactiva_solo_caja\n" +
                    ")\n" +
                    "VALUES (\n" +
                    "  ${idempresa},\n" +
                    "  '${data.f_username}',\n" +
                    "  '${data.f_password}',\n" +
                    "  '${data.activo}',\n" +
                    "  '${data.f_idtipo}',\n" +
                    "  ${data.f_ididioma},\n" +
                    "  ${data.f_camarero},\n" +
                    "  ${data.f_nombre},\n" +
                    "  ${data.f_apellido},\n" +
                    "  ${data.f_email},\n" +
                    "  ${data.f_telefono},\n" +
                    "  ${data.f_idsucursal},\n" +
                    "  ${data.f_super_user},\n" +
                    "  ${data.f_web_user},\n" +
                    "  ${data.f_cajero},\n" +
                    "  ${data.f_desactiva_solo_caja} );"
        }

        println('');
        println(query);

//        sql.executeQueryInsertUpdate(query)



        //Invetigar como validar si el query no return error, sin uso de Try Catch!
        //Invetigar como validar si el query no return error, sin uso de Try Catch!
        //Invetigar como validar si el query no return error, sin uso de Try Catch!
        return true;

    }


    def getPermisos(Long idusuario) {

        String query = "SELECT \n" +
                "  f_idempresa \n" +
                "FROM \n" +
                "  public.t_usuarios where f_idrecord = ${idusuario}";

        def id_empresa = sql.executeQueryAsMap(query);

        String query_permisos ="\n" +
                "        select po.f_id,\n" +
                "                po.f_padre,\n" +
                "                po.f_descripcion,\n" +
                "                (\n" +
                "                        select po.f_id in (\n" +
                "                select p.f_idopcion\n" +
                "        from cfg.t_permisos_usuario as p\n" +
                "        where p.f_idusuario =  ${idusuario} )\n" +
                "\n" +
                "        ) as f_activo\n" +
                "        from cfg.t_opciones_menu po\n" +
                "        where po.f_id IN( " +
                "                SELECT\n" +
                "                em.f_idopcionmenu\n" +
                "                from cfg.t_opciones_menu_empresa em\n" +
                "                where em.f_idempresa = ${id_empresa.f_idempresa}) order by 2 ";

//        println(query_permisos);

        return sql.executeQueryAsList(query_permisos);
    }

}
