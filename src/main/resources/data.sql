--Sección Accounts
insert into Account values (1, 'andres baranda 625', 'Quilmes', 'Pepe', 'Perez', '011-2222-3333');
insert into Account values (2, 'Maipú 444', 'Bernal', 'Pato', 'Gonzales', '011-3333-4444');


--Sección Users
insert into User values (1, 'emailUser1@gmail.com', 'PepePer01', 1);
insert into User values (2, 'emailUser2@gmail.com', 'PGonzales01', 2);


--Sección Animals
insert into Animal values (1,'3 meses', 1, 'Mestizo', 'Gatito macho, blanco y negro. Ojos amarillos', 'alto 20cm x 30cm ancho');
insert into Animal values (2,'2 meses', 2, 'Coquer', 'Cachorra coquer, sin collar, pelo marrón y ojos negros', 'alto 15cm x 20cm ancho');
insert into Animal values (3,'5 meses', 0, 'Pato', 'Pato común, todo blanco, patas naranjas', 'aproximadamente Alto 40cm');


--Sección Publications
insert into Publication values (1, 'location1', 'Bernal - Maipú 327', 'Se lo vió por última vez en esos alrededores', 0, 0, 1, 1);
insert into Publication values (2, 'location2', 'Berazategui - Av. Mitre', 'Se la vió por última vez cerca de la UAI', 0, 1, 2, 2);


--Sección tabla intermedia PUBLICATION_PHOTOS
insert into PUBLICATION_PHOTOS values (1, 'https://www.elmundodelgato.com/fotos/78/1219_P1211772.JPG');
insert into PUBLICATION_PHOTOS values (1, 'https://s3-eu-west-1.amazonaws.com/barkibu-blog/blog+images/como-saber-que-raza-es-mi-gato/gato-tuxis2.png');
insert into PUBLICATION_PHOTOS values (1, 'https://i.pinimg.com/originals/2e/95/13/2e9513de4ee17692a1f78985b139d1f4.jpg');

insert into PUBLICATION_PHOTOS values (2, 'https://misanimales.com/wp-content/uploads/2015/12/cocker-spaniel-americano.jpg');
insert into PUBLICATION_PHOTOS values (2, 'https://3.bp.blogspot.com/-yb6LhqETeMw/UUUSiFQjZMI/AAAAAAAAAB4/rwxx--e21bo/s1600/cachorra+cocker.jpg');


