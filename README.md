# rjkscore
Parte Backend de nuestro TFG rjkscore

## Configuración

La aplicación necesita una clave secreta para firmar y validar los JWT. Antes de
ejecutar el servicio debes definir la variable de entorno `JWT_SECRET_KEY` con el
valor que desees utilizar como clave.

```bash
export JWT_SECRET_KEY=mi_clave_secreta
```

Con esta variable presente se podrán generar y validar tokens correctamente.
