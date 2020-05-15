--Sección Accounts
insert into Person values (1, 'andres baranda 625', 'Quilmes', 'Pepe', 'Perez', '011-2222-3333');
insert into Person values (2, 'Maipú 444', 'Bernal', 'Pato', 'Gonzales', '011-3333-4444');
insert into Person values (3, 'Av. Mitre', 'Quilmes', 'Juan', 'Garcia', '011-3333-4444');
insert into Person values (4, 'Av Cordoba', 'Capital Federal', 'Pedro', 'Gomez', '011-3333-4444');
insert into Person values (5, 'Calle 44', 'Tigre', 'Luis', 'Galvez', '011-3333-4444');
insert into Person values (6, 'Ramon Franco', 'Avellaneda', 'Roberto', 'Smith', '011-3333-4444');

--Sección Users
insert into User values (1, 'emailUser1@gmail.com', 'contraseña1', '123e4530-e89b-12d3-a430-556642440000', 'PepePer01', 1);
insert into User values (2, 'emailUser2@gmail.com', 'contraseña2', '123e4540-e89b-12d3-a440-556642440000', 'PGonzales01', 2);
insert into User values (3, 'emailUser3@gmail.com', 'contraseña3', '123e4550-e89b-12d3-a450-556642440000', 'JGarcia01', 3);
insert into User values (4, 'emailUser4@gmail.com', 'contraseña4', '123e4560-e89b-12d3-a460-556642440000', 'PGomez01', 4);
insert into User values (5, 'emailUser5@gmail.com', 'contraseña5', '123e4570-e89b-12d3-a470-556642440000', 'LuisGonzales01', 5);
insert into User values (6, 'emailUser6@gmail.com', 'contraseña6', '123e4580-e89b-12d3-a480-556642440000', 'Rsmith', 6);

--Sección Animals
insert into Animal values (1,'3 meses', 1, 'Mestizo', 'Gatito macho, blanco y negro. Ojos amarillos', 'alto 20cm x 30cm ancho');
insert into Animal values (2,'2 meses', 2, 'Coquer', 'Cachorra coquer, sin collar, pelo marrón y ojos negros', 'alto 15cm x 20cm ancho');
insert into Animal values (3,'5 meses', 0, 'Pato', 'Pato común, todo blanco, patas naranjas', 'aproximadamente Alto 40cm');
insert into Animal values (4,'1 año', 1, 'Pastor Belga', 'Pelo largo, Hembra, con una mancha abajo del pecho', 'aproximadamente Alto 1 metro ');
insert into Animal values (5,'10 meses', 2, 'Pitbull', 'Marron, con algunas machas blancas en el lomo, macho', 'aproximadamente Alto 60cm');
insert into Animal values (6,'5 años', 0, 'Siames', 'Hembra, ojos celestes claro', 'aproximadamente Alto 40cm');
insert into Animal values (7,'3 años', 0, 'Guacamayo', 'Color amarillo y celeste, le falta una pluma abajo del ala derecha', 'aproximadamente Alto 40cm');


--Sección Publications
insert into Publication values (1, 'location1', 'Bernal - Maipú 327', 'Fue encontrado por esos alrededores', 0, 0, 1, 1);
insert into Publication values (2, 'location2', 'Berazategui - Av. Mitre', 'Se la vió por última vez cerca de la UAI', 0, 1, 2, 2);
insert into Publication values (3, 'location3', 'Quilmes - Av. Mitre', 'Se lo encontró en la estacion de servicio de calle Bransen', 0, 0, 3, 3);
insert into Publication values (4, 'location4', 'Reconquista - CABA', 'Se la vió por última vez cerca de Avenida Cordoba', 0, 1, 4, 4);
insert into Publication values (5, 'location5', 'Avellaneda - Ramon Franco', 'Se lo rescató en estacion de tren Wilde', 0, 0, 5, 5);
insert into Publication values (6, 'location6', 'Palermo - Arenales', 'Se la vió por última vez por el barrio', 0, 1, 6, 6);
insert into Publication values (7, 'location7', 'Florencio Varela - Avenida del Trabajo', 'Fue rescatado cerca de la Universidad Jauretche', 0, 0, 7, 2);


--Sección tabla intermedia PUBLICATION_PHOTOS
insert into PUBLICATION_PHOTOS values (1, 'https://www.elmundodelgato.com/fotos/78/1219_P1211772.JPG');
insert into PUBLICATION_PHOTOS values (1, 'https://s3-eu-west-1.amazonaws.com/barkibu-blog/blog+images/como-saber-que-raza-es-mi-gato/gato-tuxis2.png');
insert into PUBLICATION_PHOTOS values (1, 'https://i.pinimg.com/originals/2e/95/13/2e9513de4ee17692a1f78985b139d1f4.jpg');
insert into PUBLICATION_PHOTOS values (1, 'https://cdn.pixabay.com/photo/2018/11/27/21/21/cat-3842408_960_720.jpg');

insert into PUBLICATION_PHOTOS values (2, 'https://misanimales.com/wp-content/uploads/2015/12/cocker-spaniel-americano.jpg');
insert into PUBLICATION_PHOTOS values (2, 'https://3.bp.blogspot.com/-yb6LhqETeMw/UUUSiFQjZMI/AAAAAAAAAB4/rwxx--e21bo/s1600/cachorra+cocker.jpg');

insert into PUBLICATION_PHOTOS values (3, 'https://cdn.pixabay.com/photo/2018/08/15/21/20/mallard-3609130_960_720.jpg');

insert into PUBLICATION_PHOTOS values (4, 'https://cdn.pixabay.com/photo/2016/03/20/15/37/dog-1268813_960_720.jpg');
insert into PUBLICATION_PHOTOS values (4, 'https://cdn.pixabay.com/photo/2016/03/20/15/33/dog-1268794_960_720.jpg');

insert into PUBLICATION_PHOTOS values (5, 'https://cdn.pixabay.com/photo/2014/06/08/21/59/american-staffordshire-terrier-365109_960_720.jpg');
insert into PUBLICATION_PHOTOS values (5, 'https://cdn.pixabay.com/photo/2018/08/19/10/57/american-staffordshire-terrier-3616318_960_720.jpg');

insert into PUBLICATION_PHOTOS values (6, 'https://cdn.pixabay.com/photo/2017/07/22/18/25/cat-2529563_960_720.jpg');
insert into PUBLICATION_PHOTOS values (6, 'https://cdn.pixabay.com/photo/2017/02/15/12/12/cat-2068462_960_720.jpg');

insert into PUBLICATION_PHOTOS values (7, 'https://cdn.pixabay.com/photo/2018/08/12/16/59/ara-3601194_960_720.jpg');