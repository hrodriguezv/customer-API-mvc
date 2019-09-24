insert into distributor (name, email, address, date_created)
values('Panama Luxery Cars', 'panamaluxerycars@panama.com', 'Av. Panama City #24, Panama.', NOW());

insert into customer (name, last_name, username, password, email, address, status, date_created, distributor_id)
values('Jose', 'Perez', 'jperez', '12345', 'jperez@gmail.com', 'C/Don Pedro #45, San Juan, Panama.', 'ENABLED', NOW(), 1);

insert into customer (name, last_name, username, password, email, address, status, date_created, distributor_id)
values('Carlos Amado', 'Matos Novas', 'camatos', '12345', 'camatos@gmail.com', 'C/Ave. 27 de Febrero, Santo Cerros, Panama.', 'ENABLED', NOW(), 1);

insert into customer (name, last_name, username, password, email, address, status, date_created, distributor_id)
values('Cristina Maria', 'Soto Mendez', 'cmariasmendez', '12345', 'jcmariasmendez@gmail.com', 'Ave. Canal Montas, Distrino Nacional, Panama.', 'ENABLED', NOW(), 1);