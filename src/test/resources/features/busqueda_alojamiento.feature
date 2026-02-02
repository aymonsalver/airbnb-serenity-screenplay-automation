Feature: Busqueda y extraccion de detalles de alojamiento en Airbnb

  Como usuario de Airbnb
  Quiero buscar alojamientos con filtros específicos
  Para encontrar opciones que se ajusten a mis necesidades y extraer sus detalles

  @BusquedaYExtraccionDetalles
  Scenario: Buscar alojamiento en un destino con filtros personalizados y extraer detalles
    Given que el usuario esta en la pagina principal de Airbnb
    When ingresa "Medellín, Antioquia" como destino
    And selecciona su tiempo de estadia desde la fecha actual hasta 7 dias despues
    And selecciona en los huespedes 2 adultos, 1 nino y 1 mascota
    And aplica filtros de comodidades para "Lavadora", "Wifi" y "Cocina" y ajusta el precio maximo a 1000000 antes de hacer clic en Mostrar
    Then deberia ver una lista de alojamientos que cumplen con esos filtros
    When selecciona el primer resultado
    Then deberia visualizarse los detalles en un archivo de excel

