#language: es

  Característica: Obtener listado de usuarios del servicio
    Como usuario del sistema
    Quiero obtener el listado de usuarios retornado por el servicio
    Para validar la existencia de ciertos usuarios

  Escenario: Obtener listado de usuarios del servicio
    Dado que Jisela quiere consultar el listado de usuarios, usando el parámetro de consulta
    |page|2|
    Cuando se obtiene el código de respuesta 200
    Y se obtiene el listado de usuarios de la respuesta del servicio
    Entonces Jisela debería ver que los siguientes usuarios existen en el listado de respuesta
    |id|email                     |firstName|lastName|avatar                                                               |
    |11|george.edwards@reqres.in  |George   |Edwards |https://s3.amazonaws.com/uifaces/faces/twitter/mrmoiree/128.jpg      |
    | 8|lindsay.ferguson@reqres.in|Lindsay  |Ferguson|https://s3.amazonaws.com/uifaces/faces/twitter/araa3185/128.jpg      |
    |12|rachel.howell@reqres.in   |Rachel   |Howell  |https://s3.amazonaws.com/uifaces/faces/twitter/hebertialmeida/128.jpg|