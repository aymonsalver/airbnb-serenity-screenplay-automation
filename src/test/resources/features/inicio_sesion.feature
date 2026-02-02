#language: es
Característica: Iniciar sesion en la pagina Airbnb

  Como usuario de Airbnb
  Quiero iniciar sesión en mi cuenta
  Para acceder a las funcionalidades personalizadas de la plataforma

  Antecedentes:
    Dado que el usuario se encuentra en la pagina de Airbnb

  @InicioSesionExitoso
  Escenario: Inicio de sesión exitoso con credenciales válidas
    Cuando el usuario selecciona el apartado para iniciar sesión
    Y el usuario accede al menu de inicio de sesión y selecciona la opción de iniciar sesión con correo electrónico
    Y el usuario ingresa un correo electrónico registrado
    Y el usuario ingresa una contraseña válida e inicia sesión dando clic en el botón "Iniciar sesión"
    Entonces el usuario debería ser redirigido a su cuenta y ver su nombre de usuario en la esquina superior derecha //TODO: validar mensaje de error


  @InicioSesionRedirigidoARegistro
    Escenario: Intento de inicio de sesión con correo no registrado
      Cuando el usuario selecciona el apartado para iniciar sesión
      Y el usuario accede al menu de inicio de sesión y selecciona la opción de iniciar sesión con correo electrónico
      Y el usuario ingresa un correo electrónico no registrado
      Entonces el usuario debería ver un mensaje de error indicando que las credenciales son incorrectas //TODO: validar mensaje de error


  @InicioSesionFallido
    Escenario: Intento de inicio de sesión con contraseña incorrecta
      Cuando el usuario selecciona el apartado para iniciar sesión
      Y el usuario accede al menu de inicio de sesión y selecciona la opción de iniciar sesión con correo electrónico
      Y el usuario ingresa un correo electrónico registrado
      Y el usuario ingresa una contraseña incorrecta e intenta iniciar sesión dando clic en el botón "Iniciar sesión"
      Entonces el usuario debería ver un mensaje de error indicando que las credenciales son incorrectas //TODO: validar mensaje de error

