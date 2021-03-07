package jqmicrosistemas.abacus.service

import jqmicrosistemas.abacus.database.Sql
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class SucursalService {


    @Autowired
    Sql sql


    List getSucursalesNombreAndID(Long idEmpresa) {
        String query =" SELECT \n" +
                "  f_idsucursal as id,\n" +
                "  f_nombresucursal as nombre\n" +
                "FROM \n" +
                "  t_sucursal where f_idempresa = ${idEmpresa};";

        def data = sql.executeQueryAsList(query);
//        println(data);
        return data;
    }

}
