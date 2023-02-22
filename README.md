# Wordle

Un wordle es un juego de adivinanzas en el que intentas adivinar una palabra y cada intento obtienes pistas sobre la palabra oculta.

## Cómo jugar

Para comenzar, ejecute el archivo `Wordle.java`. El programa le pedirá que ingrese una palabra de diferentes longitudes dependiendo de la dificultad que el usuario haya escogido en el archivo applicaction.properties bajo la carpeta main/resources, el usuario puede escoger entre 3 niveles de dificultad:Facil, con una palabra a adivinar de 3 letras de longitud y 20 intentos;
medio, con una palabra a adivinar de 5 letras y 10 intentos; y dificil, con una palabra a adivinar de 8 letras y 5 intentos.

![plot](./images/home.png)

Después de cada intento, recibirá una lista de letras que adivinó correctamente y en qué posición. También recibirá una lista de letras que no están en la palabra.
![plot](./images/intento1.png)

Si adivinas la palabra en el numero de intentos acorde a la dificultad o menos, ¡ganas el juego! De lo contrario, pierdes.

![plot](./images/victoria.png)

![plot](./images/derrota.png)

En la pantalla de victoria puedes usar el buscador que aparece en la pantalla de victoria para ver los intentos realizados previamente.

![plot](./images/hitorial1.png)
![plot](./images/hitorial2.png)

## Cómo funciona el código

El programa está escrito en Java y usa el framework Spring para manejar la lógica de negocio.

La clase `PalabraPorLetras` representa una letra a adivinar y su posición. La clase `IPalabraRepo` define la interfaz para un repositorio de palabras y la clase `PalabraRepo` implementa esta interfaz utilizando una lista de palabras predefinidas.

La clase `PalabrasService` maneja la lógica principal del juego. Utiliza el repositorio de palabras para verificar las adivinanzas del usuario y mantiene un registro de intentos anteriores.

## Cómo probar el código

El código incluye un conjunto de pruebas unitarias escritas utilizando JUnit 5. Estas pruebas verifican el comportamiento de la clase `PalabrasService` en una variedad de situaciones.

Para ejecutar las pruebas, simplemente ejecute el archivo `PalabrasServiceTest.java`. Para poder comprobar los tests has de tener la dependencia de JUnit instalada en el equipo.


## Autores

Este proyecto fue desarrollado por [Javier Burillo](https://github.com/SaijaxS).
![plot](./images/logo.png)
