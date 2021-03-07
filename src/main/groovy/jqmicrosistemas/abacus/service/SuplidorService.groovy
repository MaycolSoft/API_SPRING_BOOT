package jqmicrosistemas.abacus.service

import jqmicrosistemas.abacus.database.Sql
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class SuplidorService {

    @Autowired
    Sql sql

    List getSuplidores(Long idempresa, String params) {
        String query = "select * from t_suplidores where f_idempresa=${idempresa}"
        return sql.executeQueryAsList(query)
    }

    def setSuplidor(Map data, Long idempresa) {
        String query = ""

        if (data.get("f_idrecord", 0) > 0) {

            query = "UPDATE \n" +
                    "  public.t_suplidores \n" +
                    "SET \n" +
                    "  f_nombre = '${data.f_nombre}',\n" +
                    "  f_vendedor = '${data.f_vendedor}',\n" +
                    "  f_direccion = '${data.f_direccion}',\n" +
                    "  f_fax = '${data.f_fax}',\n" +
                    "  f_telefono = '${data.f_telefono}',\n" +
                    "  f_email = '${data.f_email}',\n" +
                    "  f_rnc = '${data.f_rnc}',\n" +
                    "  f_balance = ${data.f_balance},\n" +
                    "  f_pais = '${data.f_pais}',\n" +
                    "  f_web = '${data.f_web}',\n" +
                    "  f_cuenta_contable = '${data.f_cuenta_contable.toString()}',\n" +
                    "  f_es_formal = ${data.f_es_formal.toString().toBoolean()},\n" +
                    "  f_porcentaje_retencion = ${data.f_porcentaje_retencion}\n" +
                    "WHERE \n" +
                    "  f_idrecord = ${data.f_idrecord}\n" +
                    ";"

        } else {
            query = "INSERT INTO \n" +
                    "  public.t_suplidores\n" +
                    "(\n" +
                    "  f_idempresa,\n" +
                    "  f_nombre,\n" +
                    "  f_vendedor,\n" +
                    "  f_direccion,\n" +
                    "  f_fax,\n" +
                    "  f_telefono,\n" +
                    "  f_email,\n" +
                    "  f_rnc,\n" +
                    "  f_balance,\n" +
                    "  f_pais,\n" +
                    "  f_web,\n" +
                    "  f_cuenta_contable,\n" +
                    "  f_es_formal,\n" +
                    "  f_porcentaje_retencion\n" +
                    ")\n" +
                    "VALUES (\n" +
                    "  ${idempresa},\n" +
                    "  '${data.f_nombre}',\n" +
                    "  '${data.f_vendedor}',\n" +
                    "  '${data.f_direccion}',\n" +
                    "  '${data.f_fax}',\n" +
                    "  '${data.f_telefono}',\n" +
                    "  '${data.f_email}',\n" +
                    "  '${data.f_rnc}',\n" +
                    "  ${data.f_balance},\n" +
                    "  '${data.f_pais}',\n" +
                    "  '${data.f_web}',\n" +
                    "  '${data.f_cuenta_contable}',\n" +
                    "  ${data.f_es_formal.toString().toBoolean()},\n" +
                    "  ${data.f_porcentaje_retencion}\n" +
                    ");"
        }
        sql.executeQueryInsertUpdate(query)

    }
    def getSuplidor(Long idempresa, Long f_idrecord) {
        return sql.executeQueryAsMap("SELECT \n" +
                "  f_idrecord,\n" +
                "  f_idempresa,\n" +
                "  f_idsuplidor,\n" +
                "  f_nombre,\n" +
                "  f_vendedor,\n" +
                "  f_direccion,\n" +
                "  f_fax,\n" +
                "  f_telefono,\n" +
                "  f_email,\n" +
                "  f_rnc,\n" +
                "  f_balance,\n" +
                "  f_pais,\n" +
                "  f_web,\n" +
                "  f_cuenta_contable,\n" +
                "  f_es_formal,\n" +
                "  f_porcentaje_retencion,\n" +
                "  f_fecha_ingreso\n" +
                "FROM \n" +
                "  public.t_suplidores where f_idrecord = ${f_idrecord} and f_idempresa = ${idempresa}");
    }


    List getCuentasContables(Long idempresa) {
        return sql.executeQueryAsList("SELECT \n" +
                "  f_idrecord,\n" +
                "  f_idempresa,\n" +
                "  f_no_cuenta,\n" +
                "  f_descripcion,\n" +
                "  f_cuenta_control,\n" +
                "  f_naturalezacuenta,\n" +
                "  f_tienesubcuentas,\n" +
                "  f_grupo_general,\n" +
                "  f_view_estado_situacion,\n" +
                "  f_ver_estado_financiero,\n" +
                "  f_ver_flujo_caja,\n" +
                "  f_view_estado_cuenta,\n" +
                "  f_view_balance,\n" +
                "  f_activa\n" +
                "FROM \n" +
                "  cnt.t_cuentas_contables where f_idempresa=${idempresa}");
    }
}
