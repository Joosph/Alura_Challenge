Currency Converter App - README

Este archivo README proporciona información sobre la aplicación de conversión de divisas, cómo se escribió el código, cómo funciona y qué se utilizó en cada línea.

1. Estructura del proyecto:
   - El proyecto se estructura en una clase principal `CurrencyConverterApp` que extiende la clase `Application` de JavaFX.
   - Se utiliza el patrón de diseño Model-View-Controller (MVC) para separar la lógica de la interfaz gráfica.

2. Interfaz gráfica:
   - La interfaz gráfica se crea utilizando JavaFX.
   - Se utiliza un GridPane para organizar los controles y establecer el diseño.
   - Se añaden controles como ComboBox, TextField, Label y Button para la interacción con el usuario.

3. Obtención de datos de divisas:
   - Se utiliza una API externa para obtener los datos de los precios de las divisas.
   - En este caso, se utiliza la API de ExchangeRate-API (https://www.exchangerate-api.com) para obtener las tasas de cambio.
   - La URL utilizada es "https://api.exchangerate-api.com/v4/latest/USD" que proporciona los precios de las divisas en relación al dólar estadounidense (USD).

4. Implementación de la conversión de divisas:
   - Al presionar el botón "Convert", se recoge la divisa seleccionada y el monto ingresado por el usuario.
   - Se realiza una solicitud HTTP a la API para obtener los precios actualizados de las divisas.
   - Los datos se analizan utilizando la biblioteca JSONObject para extraer las tasas de cambio.
   - Se realiza la conversión multiplicando el monto ingresado por la tasa de cambio de la divisa seleccionada.
   - El resultado se muestra en la etiqueta "resultLabel".

5. Uso de clases y componentes de JavaFX:
   - Se utiliza la clase `Application` como punto de entrada para la aplicación JavaFX.
   - Se utiliza el GridPane para organizar los controles en una cuadrícula.
   - Se utiliza ComboBox para seleccionar la divisa.
   - Se utiliza TextField para ingresar el monto.
   - Se utiliza Label para mostrar el resultado.
   - Se utiliza Button para activar la conversión.

6. Ejecución de la aplicación:
   - La aplicación se ejecuta llamando al método `launch` en la clase `CurrencyConverterApp`.
   - Se muestra una ventana con la interfaz gráfica de la aplicación.
   - El usuario puede seleccionar una divisa, ingresar un monto y presionar el botón "Convert" para obtener el resultado de la conversión.

Espero que esta descripción detallada del código te ayude a comprender cómo se escribió la aplicación de conversión de divisas, cómo funciona y qué se utilizó en cada línea.
