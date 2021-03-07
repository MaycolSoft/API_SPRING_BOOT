package jqmicrosistemas.abacus.service

import jqmicrosistemas.abacus.database.Sql
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UtilidadesService {

    @Autowired
    Sql sql

    List getDataToChart(Long idempresa) {
        String query = "SELECT \n" +
                "  COALESCE(SUM(c.f_monto),0) as value,\n" +
                "  'Venta al contado' as name\n" +
                "FROM \n" +
                "  inv.t_factura_contado c where c.f_idempresa = ${idempresa} and c.f_fecha = current_date\n" +
                "union \n" +
                "SELECT \n" +
                "  COALESCE(SUM(c.f_monto),0) as value,\n" +
                "  'Venta a credito' as name\n" +
                "FROM \n" +
                "  inv.t_factura_credito c where c.f_idempresa = ${idempresa} and c.f_fecha = current_date\n" +
                "union\n" +
                "SELECT \n" +
                "  COALESCE(SUM(c.f_monto),0) as value,\n" +
                "  'Cobros' as name\n" +
                "FROM \n" +
                "  cxcp.t_aplicaciones c where c.f_idempresa = ${idempresa} and c.f_fecha = current_date"
        return sql.executeQueryAsList(query)
    }

    List getSalesBySucursal(Long idempresa) {
        String query = "SELECT SUM(m.f_monto) AS value,\n" +
                "       s.f_nombresucursal as name\n" +
                "FROM inv.t_factura_contado m\n" +
                "     inner join t_sucursal s on m.f_idsucursal = s.f_idsucursal\n" +
                "where m.f_idempresa = ${idempresa} \n" +
                "group by s.f_nombresucursal \n" +
                "order by value DESC"
        return sql.executeQueryAsList(query)
    }


    List getSucursales(Long idempresa) {
        String query = "SELECT \n" +
                "  f_idrecord,\n" +
                "  f_nombresucursal\n" +
                "FROM \n" +
                "  public.t_sucursal where f_idempresa = ${idempresa};"
        return sql.executeQueryAsList(query)
    }


    List getZonas(Long idempresa) {
        String query = "SELECT \n" +
                "  f_idrecord,\n" +
                "  f_descripcion\n" +
                "FROM \n" +
                "  public.t_zonas where f_idempresa = ${idempresa};"
        return sql.executeQueryAsList(query)
    }

    List getNCFList(Long idempresa) {
        String query = "SELECT \n" +
                "  f_idrecord,\n" +
                "  f_descripcion\n" +
                "FROM \n" +
                "  public.t_ncf where f_idempresa = ${idempresa} and f_visible = true"
        return sql.executeQueryAsList(query)
    }

    List getTipoCliente(Long idempresa) {
        String query = "SELECT \n" +
                "  f_idrecord,\n" +
                "  f_idempresa,\n" +
                "  f_descripcion\n" +
                "FROM \n" +
                "  public.t_tipo_clientes where f_idempresa = ${idempresa}"
        return sql.executeQueryAsList(query)
    }

    List getMonedas(Long idempresa) {
        String query = "  SELECT \n" +
                "  f_idrecord,\n" +
                "  f_idempresa,\n" +
                "  f_descripcion\n" +
                "FROM \n" +
                "  public.t_moneda where f_idempresa=${idempresa}"
        return sql.executeQueryAsList(query)
    }
}
