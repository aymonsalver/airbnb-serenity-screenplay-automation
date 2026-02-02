#language: es
Característica: Buscar y reservar un alojamiento en la pagina Airbnb

  Como usuario de Airbnb
  Quiero buscar y reservar un alojamiento con diferentes criterios
  Para poder planificar mis viajes de manera eficiente

  Antecedentes:
    Dado que el usuario se encuentra en la pagina de Airbnb

  @ReservaPorFechaExacta
  Escenario: Buscar y reservar un alojamiento por fecha exacta
    Cuando el usuario busca un alojamiento en "Medellín, Antioquia"
    Y el usuario selecciona las fechas "20/12/2024" a "25/12/2024"
    Y el usuario selecciona en los huespedes 2 adultos y 1 niño
    Y el usuario filtra los alojamientos
    Y el usuario selecciona el primer alojamiento de la lista
    Y el usuario reserva el alojamiento
    Entonces el usuario deberia ver el resumen de la reserva


  @ReservaPorMeses
  Escenario: Buscar y reservar un alojamiento por meses de viaje
    Cuando el usuario busca un alojamiento en "Medellín, Antioquia"
    Y el usuario selecciona 6 meses de viaje
    Y el usuario selecciona en los huespedes 2 adultos y 1 niño
    Y el usuario filtra los alojamientos
    Y el usuario selecciona el primer alojamiento de la lista
    Y el usuario reserva el alojamiento
    Entonces el usuario deberia ver el resumen de la reserva


  @ReservaPorFechaFlexible
  Escenario: Buscar y reservar un alojamiento por fecha flexible
    Cuando el usuario busca un alojamiento en "Medellín, Antioquia"
    Y  el usuario selecciona en las fechas flexibles "Fin de semana"
    Y el usuario selecciona en los huespedes 2 adultos y 1 niño
    Y el usuario filtra los alojamientos
    Y el usuario selecciona el primer alojamiento de la lista
    Y el usuario reserva el alojamiento
    Entonces el usuario deberia ver el resumen de la reserva

