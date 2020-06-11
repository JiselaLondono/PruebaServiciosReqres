#language: es

Característica: Obtener información de un usuario
  Como usuario del sistema
  Quiero obtener la información de un usuario retornado por el servicio
  Para validar su existencia


  Escenario: Obtener información de un usuario por medio de su id
    Dado que Jisela quiere consultar un usuario, usando el id 2
    Cuando se obtiene el código de respuesta 200
    Y se obtiene el usuario de la respuesta del servicio
    Entonces Jisela debería ver que el siguiente usuario existe en la respuesta
      |id|email                 |firstName|lastName|avatar                                                            |
      | 2|janet.weaver@reqres.in|Janet    |Weaver  |https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg|
