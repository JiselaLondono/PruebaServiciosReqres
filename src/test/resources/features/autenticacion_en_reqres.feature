#language: es

Característica: Obtener token para ingresar al aplicativo
  Como usuario del sistema
  Quiero obtener el token de acceso
  Para una autenticación exitosa al sistema


  Escenario: Obtener token de ingreso al aplicativo reqres
    Dado que Jisela quiere autenticarse en el aplicativo reqres con el correo eve.holt@reqres.in y la clave cityslicka
    Cuando se obtiene el código de respuesta 200
    Entonces Jisela debería obtener el token QpwL5tke4Pnpja7X4
