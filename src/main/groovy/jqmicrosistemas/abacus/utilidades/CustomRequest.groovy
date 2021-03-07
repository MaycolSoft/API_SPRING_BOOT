package jqmicrosistemas.abacus.utilidades

import groovy.json.JsonSlurper

class CustomRequest {
    Map f_data
    String f_key


    CustomRequest(String base64) {
        String rs = new String(base64.decodeBase64())
        Map response
        JsonSlurper parser = new JsonSlurper()
        response = parser.parseText(rs)

        this.f_data = response.f_data ?: [:]
        this.f_key = response.f_key ?: "1"
    }

}
