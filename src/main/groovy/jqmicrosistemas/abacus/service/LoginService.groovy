package jqmicrosistemas.abacus.service


import jqmicrosistemas.abacus.database.Sql
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class LoginService {

    @Autowired
    Sql sql

    Map autenticate(String username, String password , Long idempresa) {
        String query = "select   f_idrecord,\n" +
                "  f_idempresa,\n" +
                "  f_username,\n" +
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
                "  f_desactiva_solo_caja from t_usuarios where f_idempresa = ${idempresa} and f_username = '${username}' and f_password = '${password.md5()}' and f_activo = true and f_web_user = true"
        Map usuario = sql.executeQueryAsMap(query)

        if (!usuario.isEmpty()) {
            String token = usuario.f_idrecord.toString() + usuario.f_username.toString()

            usuario['f_token'] = sql.executeQueryAsMap("INSERT INTO \n" +
                    "  web.t_login\n" +
                    "(\n" +
                    "  f_usuario,\n" +
                    "  f_token,\n" +
                    "  f_fecha,\n" +
                    "  f_idempresa\n" +
                    ")\n" +
                    "VALUES (\n" +
                    "  ${usuario.f_idrecord},\n" +
                    "  MD5('${token}' || CURRENT_TIMESTAMP::text),\n" +
                    "  current_date,\n" +
                    "  ${usuario.f_idempresa}\n" +
                    ") returning f_token;")?.f_token?.toString()
            usuario['menu'] = getUserMenu(usuario.f_idrecord as Long)
        }
        return usuario
    }

    List getUserMenu(Long idusuario) {
        String query = "select m.f_id as id,\n" +
                "        m.f_descripcion as title,\n" +
                "        m.f_padre as \"parentId\",\n" +
                "        CASE\n" +
                "          WHEN (select count(*) from cfg.t_opciones_menu sm where sm.f_padre = m.f_id) <> 0 THEN TRUE\n" +
                "          ELSE FALSE\n" +
                "        END AS \"hasSubMenu\",\n" +
                "        Null        as target,\n" +
                "        COALESCE(m.f_url_web, '') as \"routerLink\",\n" +
                "        Null      as href,\n" +
                "        COALESCE(m.f_icon_web, '') as icon\n" +
                " from cfg.t_opciones_menu m\n" +
                "      inner join cfg.t_permisos_usuario p on m.f_id = p.f_idopcion\n" +
                " where p.f_idusuario = ${idusuario} \n" +
                " order by m.f_padre,\n" +
                "          m.f_orden";

        def data = sql.executeQueryAsList(query);
        println(data);

        return data;
    }

    Long getIdEmpresa(String token) {
        String query = "SELECT \n" +
                "  f_idempresa\n" +
                "FROM \n" +
                "  web.t_login l where l.f_activo = true and l.f_token = '${token}'"
        return sql.executeQueryAsMap(query)?.f_idempresa as Long
    }



}
