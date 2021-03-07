package jqmicrosistemas.abacus.service

import jqmicrosistemas.abacus.database.Sql
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ClienteService {
    @Autowired
    Sql sql

    List getClientes(Long idempresa, String params) {
        String query = "select * from t_clientes where f_idempresa=${idempresa}"
        return sql.executeQueryAsList(query)
    }

    Map getClienteById(Long f_idrecord, Long idempresa) {
        Map rs = sql.executeQueryAsMap("select * from t_clientes where f_idempresa = ${idempresa} and f_idrecord = ${f_idrecord}")
        List fotos = []
        List fotosAsB64 = []
        rs['direcciones'] = sql.executeQueryAsList("select * from t_direccion_envio_clientes where f_idcliente = ${f_idrecord}")
        fotos = sql.executeQueryAsList("select encode(f_foto, 'base64') as f_foto from t_clientes_fotos where f_idcliente = ${f_idrecord}")

        fotos.each { row ->
            fotosAsB64.add(row.f_foto)
        }

        rs['fotos'] = fotosAsB64

        return rs
    }


    void setCliente(Map cliente, Long idempresa) {
        Map rs = [:]
        String query = ""
        List direcciones = cliente.get('direcciones', [])
        List fotos = cliente.get('fotos', [])

        String fechaField = cliente.f_fecha != null ? " f_fecha, " : ""
        String fechaValue = cliente.f_fecha != null ? " to_timestamp(${cliente.f_fecha}/1000)::date, " : ""

        String fechaYearField = cliente.f_fecha_year != null ? " f_fecha_year, " : ""
        String fechaYearValue = cliente.f_fecha_year != null ? " to_timestamp(${cliente.f_fecha_year}/1000)::date, " : ""

        if (cliente.get('f_idrecord',0) == 0) {

            query = "WITH t AS (INSERT INTO \n" +
                    "  public.t_clientes\n" +
                    "(\n" +
                    "  f_idempresa,\n" +
                    "  f_nombre,\n" +
                    "  f_apellido,\n" +
                    "  f_sucursal,\n" +
                    "  f_balance,\n" +
                    "  f_cedula,\n" +
                    "  \n" + fechaField +
                    "  f_limite_credito,\n" +
                    "  f_facturarcredito,\n" +
                    "  f_dias_credito,\n" +
                    "  f_celular,\n" +
                    "  f_direccion1,\n" +
                    "  f_direccion2,\n" +
                    "  f_provincia,\n" +
                    "  f_zipcode,\n" +
                    "  f_direccion_envio,\n" + fechaYearField +
                    "  f_empresa,\n" +
                    "  f_mensaje,\n" +
                    "  f_idzona,\n" +
                    "  f_tipo_cliente,\n" +
                    "  f_forma_envio,\n" +
                    "  f_exento_impuestos,\n" +
                    "  f_tipo_moneda,\n" +
                    "  f_descripcion,\n" +
                    "  f_contacto,\n" +
                    "  f_email,\n" +
                    "  f_ncf_defecto,\n" +
                    "  f_porciento_descuento\n" +
                    ")\n" +
                    "VALUES (\n" +
                    "  ${idempresa},\n" +
                    "  '${cliente.f_nombre}',\n" +
                    "  '${cliente.f_apellido}',\n" +
                    "  ${cliente.f_sucursal},\n" +
                    "  ${cliente.f_balance ?: 0},\n" +
                    "  '${cliente.f_cedula}',\n" + fechaValue +
                    "  ${cliente.f_limite_credito ?: 0},\n" +
                    "  ${cliente.f_facturarcredito.toString().toBoolean()},\n" +
                    "  ${cliente.f_dias_credito ?: 0},\n" +
                    "  '${cliente.f_celular}',\n" +
                    "  '${cliente.f_direccion1}',\n" +
                    "  '${cliente.f_direccion2}',\n" +
                    "  '${cliente.f_provincia}',\n" +
                    "  '${cliente.f_zipcode}',\n" +
                    "  '${cliente.f_direccion_envio}',\n" + fechaYearValue +
                    "  '${cliente.f_empresa}',\n" +
                    "  '${cliente.f_mensaje}',\n" +
                    "  ${cliente.f_idzona ?: 0},\n" +
                    "  ${cliente.f_tipo_cliente ?: 0},\n" +
                    "  '${cliente.f_forma_envio}',\n" +
                    "  ${cliente.f_exento_impuestos.toString().toBoolean()},\n" +
                    "  ${cliente.f_tipo_moneda ?: 0},\n" +
                    "  '${cliente.f_descripcion}',\n" +
                    "  '${cliente.f_contacto}',\n" +
                    "  '${cliente.f_email}',\n" +
                    "  ${cliente.f_ncf_defecto ?: 0},\n" +
                    "  ${cliente.f_porciento_descuento ?: 0}\n" +
                    ") RETURNING *) SELECT * FROM t;";
        } else {

            fechaField += cliente.f_fecha != null ? " = " : ""
            fechaValue += cliente.f_fecha != null ? ", " : ""


            fechaYearField += cliente.f_fecha_year != null ? " = " : ""
            fechaYearValue += cliente.f_fecha_year != null ? ", " : ""

            query = " WITH t AS ( UPDATE \n" +
                    "  public.t_clientes \n" +
                    "SET \n" +
                    "  f_nombre = '${cliente.f_nombre}',\n" +
                    "  f_apellido = '${cliente.f_apellido}',\n" +
                    "  f_sucursal = ${cliente.f_sucursal ?: 0},\n" +
                    "  f_balance = ${cliente.f_balance ?: 0},\n" +
                    "  f_cedula = '${cliente.f_cedula}',\n" +
                    "  ${fechaField} ${fechaValue}\n" +
                    "  f_limite_credito = ${cliente.f_limite_credito ?: 0},\n" +
                    "  f_facturarcredito = ${cliente.f_facturarcredito.toString().toBoolean()},\n" +
                    "  f_dias_credito = ${cliente.f_dias_credito ?: 0},\n" +
                    "  f_celular = '${cliente.f_celular}',\n" +
                    "  f_direccion1 = '${cliente.f_direccion1}',\n" +
                    "  f_direccion2 = '${cliente.f_direccion2}',\n" +
                    "  f_provincia = '${cliente.f_provincia}',\n" +
                    "  f_zipcode = '${cliente.f_zipcode}',\n" +
                    "  f_direccion_envio = '${cliente.f_direccion_envio}',\n" +
                    "  ${fechaYearField} ${fechaYearValue}\n" +
                    "  f_empresa = '${cliente.f_mensaje}',\n" +
                    "  f_mensaje = '${cliente.f_mensaje}',\n" +
                    "  f_idzona = ${cliente.f_tipo_cliente ?: 0},\n" +
                    "  f_tipo_cliente =  ${cliente.f_tipo_cliente ?: 0},\n" +
                    "  f_forma_envio = '${cliente.f_forma_envio}',\n" +
                    "  f_exento_impuestos = ${cliente.f_exento_impuestos.toString().toBoolean()},\n" +
                    "  f_tipo_moneda = ${cliente.f_tipo_moneda},\n" +
                    "  f_descripcion = '${cliente.f_descripcion}',\n" +
                    "  f_contacto = '${cliente.f_contacto}',\n" +
                    "  f_email = '${cliente.f_email}',\n" +
                    "  f_ncf_defecto = ${cliente.f_ncf_defecto ?: 0},\n" +
                    "  f_porciento_descuento = ${cliente.f_porciento_descuento}\n" +
                    "WHERE \n" +
                    "  f_idrecord = ${cliente.f_idrecord} RETURNING *) SELECT * FROM t;\n" +
                    ";"
        }
        rs = sql.executeQueryAsMap(query)

        if (direcciones.size() > 0) {
            this.setDireccionesCliente(direcciones, rs.f_idrecord.toString().toLong(), idempresa)
        }

        if (fotos.size() > 0) {
            this.setFotoCliente(fotos, rs.f_idrecord.toString().toLong(), idempresa)
        }

    }

    void setDireccionesCliente(List direcciones, Long idcliente, Long idempresa) {

        sql.executeQueryInsertUpdate("delete from t_direccion_envio_clientes where f_idcliente = ${idcliente}")

        direcciones.each { row ->
            String query = "INSERT INTO \n" +
                    "  public.t_direccion_envio_clientes\n" +
                    "(\n" +
                    "  f_idcliente,\n" +
                    "  f_direccion1,\n" +
                    "  f_direccion2,\n" +
                    "  f_provincia,\n" +
                    "  f_municipio,\n" +
                    "  f_sector,\n" +
                    "  f_zip,\n" +
                    "  f_comentario,\n" +
                    "  f_defecto,\n" +
                    "  f_idempresa\n" +
                    ")\n" +
                    "VALUES (\n" +
                    "  ${idcliente},\n" +
                    "  '${row.f_direccion1}',\n" +
                    "  '${row.f_direccion2}',\n" +
                    "  '${row.f_provincia}',\n" +
                    "  '${row.f_municipio}',\n" +
                    "  '${row.f_sector}',\n" +
                    "  '${row.f_zip}',\n" +
                    "  '${row.f_comentario}',\n" +
                    "  ${row.f_activar},\n" +
                    "  ${idempresa}\n" +
                    ");"
            sql.executeQueryInsertUpdate(query)
        }
    }

    void setFotoCliente(List fotos, Long idcliente, Long idempresa) {

        sql.executeQueryInsertUpdate("delete from t_clientes_fotos where f_idcliente = ${idcliente}")

        fotos.each { row ->
            String query = "INSERT INTO \n" +
                    "  public.t_clientes_fotos\n" +
                    "(\n" +
                    "  f_idcliente,\n" +
                    "  f_foto,\n" +
                    "  f_idempresa,\n" +
                    "  f_nombre\n" +
                    ")\n" +
                    "VALUES (\n" +
                    "  ${idcliente},\n" +
                    "  DECODE('${row}','base64'),\n" +
                    "  ${idempresa},\n" +
                    "  ''\n" +
                    ");"


            sql.executeQueryInsertUpdate(query)
        }
    }


}
