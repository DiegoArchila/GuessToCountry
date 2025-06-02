¡Claro! A continuación, te presento un ejemplo de archivo `README.md` para tu proyecto [GuessToCountry](https://github.com/DiegoArchila/GuessToCountry/tree/dev). Este archivo está estructurado para proporcionar una descripción clara del proyecto, sus características, instrucciones de instalación y uso, y otros detalles relevantes.

---

````markdown
# 🎌 GuessToCountry

**GuessToCountry** es un juego interactivo desarrollado en JavaFX que desafía a los jugadores a identificar países a partir de sus banderas. Ideal para quienes desean mejorar sus conocimientos de geografía de una manera divertida y educativa.

## 🚀 Características

- **Interfaz intuitiva**: Diseñada con JavaFX para una experiencia de usuario fluida.
- **Preguntas aleatorias**: Selección aleatoria de banderas para cada ronda.
- **Opciones múltiples**: Cuatro opciones por pregunta, una correcta y tres distractores.
- **Temporizador**: 30 segundos por pregunta; si el tiempo expira, se considera incorrecta.
- **Sistema de puntuación**:
  - Respuesta correcta: +100 puntos.
  - Respuesta incorrecta o sin respuesta: -150 puntos.
- **Progreso del juego**: Indicadores de número de pregunta, puntuación actual y tiempo restante.

## 🖥️ Tecnologías utilizadas

- **Java 17**
- **JavaFX 17**
- **FXML** para la definición de la interfaz de usuario.
- **CSS** para estilos personalizados.
- **Maven** como herramienta de construcción y gestión de dependencias.

## 📦 Instalación y ejecución

1. **Clona el repositorio**:

   ```bash
   git clone https://github.com/DiegoArchila/GuessToCountry.git
   cd GuessToCountry
````

2. **Construye el proyecto con Maven**:

   ```bash
   mvn clean install
   ```

3. **Ejecuta la aplicación**:

   ```bash
   mvn javafx:run
   ```

   Asegúrate de tener Java 17 y Maven instalados en tu sistema.

## 🧩 Estructura del proyecto

* `src/main/java/com/diarchila/guessthecountry/controllers/`: Controladores de la aplicación.
* `src/main/java/com/diarchila/guessthecountry/models/`: Modelos de datos, como la clase `Country`.
* `src/main/java/com/diarchila/guessthecountry/services/`: Servicios auxiliares, como `CountryServices`.
* `src/main/resources/views/`: Archivos FXML para las vistas.
* `src/main/resources/styles/`: Archivos CSS para estilos personalizados.

## 🎨 Personalización de estilos

Los estilos de la interfaz se definen en `guessTheCountry.css`. Puedes personalizar los estilos de los botones, etiquetas y otros elementos según tus preferencias.

Ejemplo de estilo para etiquetas informativas:

```css
.info-label {
    -fx-font-size: 15px;
    -fx-font-weight: bold;
    -fx-text-fill: white;
    -fx-background-color: #2c3e50;
    -fx-padding: 6 14;
    -fx-background-radius: 12;
    -fx-border-radius: 12;
    -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.25), 5, 0, 0, 2);
}
```

## 📸 Capturas de pantalla

*Incluye aquí capturas de pantalla de la aplicación en funcionamiento para ilustrar la interfaz y funcionalidad.*

## 🤝 Contribuciones

¡Las contribuciones son bienvenidas! Si deseas mejorar el juego, corregir errores o agregar nuevas características, por favor:

1. Haz un fork del repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios y haz commit (`git commit -am 'Agrega nueva funcionalidad'`).
4. Haz push a la rama (`git push origin feature/nueva-funcionalidad`).
5. Abre un Pull Request.

## 📄 Licencia

Este proyecto está licenciado bajo la [MIT License](LICENSE).

## 📬 Contacto

Desarrollado por **Diego Archila**.

* GitHub: [@DiegoArchila](https://github.com/DiegoArchila)
* Correo electrónico: [diego.archila@example.com](mailto:diego.archila@example.com)

---

¡Gracias por visitar este proyecto! Si te gusta, no olvides darle una estrella ⭐ y compartirlo.

```

---

Este archivo `README.md` proporciona una visión completa del proyecto, facilitando a otros desarrolladores y usuarios entender, instalar y contribuir al juego. Puedes adaptarlo según las necesidades específicas de tu proyecto y preferencias personales.
::contentReference[oaicite:0]{index=0}
 
```
