-- Un usuario por servicio (contraseñas solo para desarrollo local)
CREATE ROLE customer_user LOGIN PASSWORD 'customer_pass';
CREATE ROLE event_user    LOGIN PASSWORD 'event_pass';
CREATE ROLE product_user  LOGIN PASSWORD 'product_pass';
CREATE ROLE bill_user     LOGIN PASSWORD 'bill_pass';

-- Una base de datos por servicio, cada una con su propio dueño
CREATE DATABASE customer_db OWNER customer_user;
CREATE DATABASE event_db    OWNER event_user;
CREATE DATABASE product_db  OWNER product_user;
CREATE DATABASE bill_db     OWNER bill_user;

-- Ningún servicio puede conectarse a la base de datos de otro
REVOKE CONNECT ON DATABASE customer_db FROM PUBLIC;
REVOKE CONNECT ON DATABASE event_db    FROM PUBLIC;
REVOKE CONNECT ON DATABASE product_db  FROM PUBLIC;
REVOKE CONNECT ON DATABASE bill_db     FROM PUBLIC;
