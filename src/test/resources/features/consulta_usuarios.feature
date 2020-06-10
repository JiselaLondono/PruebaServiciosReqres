#language: es

  Característica: prueba de consumo de servicio
    como admin
    quiero abc
    para aaa


  Escenario: Obtener información de usuarios enviando número de página como parámetro de consulta
    Dado que Jisela quiere consultar el listado de usuarios, usando el parámetro de consulta
    |page |2|
    Cuando Jisela obtiene el código de respuesta 200 y recuerda el listado de usuarios
    Entonces Jisela debería ver que los siguientes usuarios existen en el listado de respuesta
    |id|email|firstName|lastName|avatar|
    |11|george.edwards@reqres.in|George|Edwards|https://s3.amazonaws.com/uifaces/faces/twitter/mrmoiree/128.jpg|
    | 8|lindsay.ferguson@reqres.in|Lindsay|Ferguson|https://s3.amazonaws.com/uifaces/faces/twitter/araa3185/128.jpg|
    |12|rachel.howell@reqres.in|Rachel|Howell|https://s3.amazonaws.com/uifaces/faces/twitter/hebertialmeida/128.jpg|