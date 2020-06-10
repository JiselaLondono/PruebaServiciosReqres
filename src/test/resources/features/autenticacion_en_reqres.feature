#language: es

Característica: obtener token para ingresar al aplicativo
  como aaa
  quiero cba
  para bbb


  Escenario: Obtener token de ingreso al aplicativo reqres
    Dado que Jisela quiere autenticarse en el aplicativo reqres con el correo eve.holt@reqres.in y la clave cityslicka
    Cuando Jisela obtiene el código de respuesta 200
    Entonces Jisela debería obtener el token QpwL5tke4Pnpja7X4
