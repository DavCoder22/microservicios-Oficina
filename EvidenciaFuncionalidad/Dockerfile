# Usa la imagen oficial de MySQL
FROM mysql:8.0

# Establece las variables de entorno para la configuración de MySQL
ENV MYSQL_ROOT_PASSWORD=13673115
ENV MYSQL_DATABASE=oficina

# Copia los scripts SQL al directorio de inicialización de MySQL en el contenedor
COPY ./oficina_recurso.sql /docker-entrypoint-initdb.d/
COPY ./oficina_empleado.sql /docker-entrypoint-initdb.d/
COPY ./oficina_departamento.sql /docker-entrypoint-initdb.d/
COPY ./oficina_routines.sql /docker-entrypoint-initdb.d/

# Exponer el puerto 3306 para conectar a MySQL
EXPOSE 3306
