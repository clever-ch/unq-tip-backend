--Sección Persons
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


-----------------------------------------------------------------------------------------------------------------------------------------------------------
--Sección Publication Found
insert into Publication values (1, 'location1', 'Bernal - Maipú 327', 'Fue encontrado por esos alrededores', 0, 0, 1, 1);
insert into Publication values (3, 'location3', 'Quilmes - Av. Mitre', 'Se lo encontró en la estacion de servicio de calle Bransen', 0, 0, 3, 3);
insert into Publication values (5, 'location5', 'Avellaneda - Ramon Franco', 'Se lo rescató en estacion de tren Wilde', 0, 0, 5, 5);
insert into Publication values (7, 'location7', 'Florencio Varela - Avenida del Trabajo', 'Fue rescatado cerca de la Universidad Jauretche', 0, 0, 7, 2);


--Sección Publication Lost
insert into Publication values (2, 'location2', 'Berazategui - Av. Mitre', 'Se la vió por última vez cerca de la UAI', 0, 1, 2, 2);
insert into Publication values (4, 'location4', 'Reconquista - CABA', 'Se la vió por última vez cerca de Avenida Cordoba', 0, 1, 4, 4);
insert into Publication values (6, 'location6', 'Palermo - Arenales', 'Se la vió por última vez por el barrio', 0, 1, 6, 6);
-----------------------------------------------------------------------------------------------------------------------------------------------------------

--Sección tabla intermedia PUBLICATION_PHOTOS
insert into PUBLICATION_PHOTOS values (1, 'https://firebasestorage.googleapis.com/v0/b/tip-sospets.appspot.com/o/img-publication-found%2F1219_P1211772.JPG?alt=media&token=eab029d1-4bd5-4554-9f54-1d01a47723df');
insert into PUBLICATION_PHOTOS values (1, 'https://firebasestorage.googleapis.com/v0/b/tip-sospets.appspot.com/o/img-publication-found%2F2e9513de4ee17692a1f78985b139d1f4.jpg?alt=media&token=51f3e7aa-ca90-412b-b957-78bc6f11f0cc');
insert into PUBLICATION_PHOTOS values (1, 'https://firebasestorage.googleapis.com/v0/b/tip-sospets.appspot.com/o/img-publication-found%2Fcat-3842408_960_720.jpg?alt=media&token=8649668b-2e95-46f0-8745-37ec5cb1b5ea');
insert into PUBLICATION_PHOTOS values (1, 'https://firebasestorage.googleapis.com/v0/b/tip-sospets.appspot.com/o/img-publication-found%2Fgato-tuxis2.png?alt=media&token=05375998-a274-4ce2-bf97-20780afd5b57');


insert into PUBLICATION_PHOTOS values (2, 'https://firebasestorage.googleapis.com/v0/b/tip-sospets.appspot.com/o/img-publication-lost%2Fcocker-spaniel-americano.jpg?alt=media&token=8027bfb6-4b2b-4bf7-aa5b-bdcbd1e20910');
insert into PUBLICATION_PHOTOS values (2, 'https://firebasestorage.googleapis.com/v0/b/tip-sospets.appspot.com/o/img-publication-lost%2Fcachorra%20cocker.jpg?alt=media&token=34f32f09-e380-4509-9ea4-ab952367eb03');


insert into PUBLICATION_PHOTOS values (3, 'https://firebasestorage.googleapis.com/v0/b/tip-sospets.appspot.com/o/img-publication-found%2Fmallard-3609130_960_720.jpg?alt=media&token=d17247d8-a35d-4660-986a-83ae0bf1d1b6');


insert into PUBLICATION_PHOTOS values (4, 'https://firebasestorage.googleapis.com/v0/b/tip-sospets.appspot.com/o/img-publication-lost%2Fdog-1268813_960_720.jpg?alt=media&token=28d6211b-5d78-4afe-931d-9174d7b88079');
insert into PUBLICATION_PHOTOS values (4, 'https://firebasestorage.googleapis.com/v0/b/tip-sospets.appspot.com/o/img-publication-lost%2Fdog-1268794_960_720.webp.jpg?alt=media&token=e85175ce-55e9-45f6-b67d-055684fa0a72');


insert into PUBLICATION_PHOTOS values (5, 'https://firebasestorage.googleapis.com/v0/b/tip-sospets.appspot.com/o/img-publication-found%2Famerican-staffordshire-terrier-365109_960_720.jpg?alt=media&token=c9572082-1b21-48a9-a11f-f8648e3ca90a');
insert into PUBLICATION_PHOTOS values (5, 'https://firebasestorage.googleapis.com/v0/b/tip-sospets.appspot.com/o/img-publication-found%2Famerican-staffordshire-terrier-3616318_960_720.jpg?alt=media&token=024d0265-2df7-425d-96e5-b394e94f12e6');


insert into PUBLICATION_PHOTOS values (6, 'https://firebasestorage.googleapis.com/v0/b/tip-sospets.appspot.com/o/img-publication-lost%2Fcat-2529563_960_720.jpg?alt=media&token=67f8fecd-9407-48a8-84e2-f26eb032ff11');
insert into PUBLICATION_PHOTOS values (6, 'https://firebasestorage.googleapis.com/v0/b/tip-sospets.appspot.com/o/img-publication-lost%2Fcat-2068462_960_720.jpg?alt=media&token=ce0b16d9-1c64-44c9-987d-8cada6e7b0b8');


insert into PUBLICATION_PHOTOS values (7, 'https://firebasestorage.googleapis.com/v0/b/tip-sospets.appspot.com/o/img-publication-found%2Fara-3601194_960_720.jpg?alt=media&token=6ca8a03e-a8c8-4c5f-b451-fba95a9c0451');
-----------------------------------------------------------------------------------------------------------------------------------------------------------

--Sección Servicios de Cuidado
 insert into CARE values (1, 'Servicio de Cuidado de mascotas por Hora By PepePer01', 1, 0, 6, 1);
 insert into CARE values (2, 'Servicio de Cuidado de mascotas por Día By PGomez01', 1, 1, 1, 4);
 
 
--Sección Servicios de Tranporte
 insert into TRANSPORT values (1, 'Servicio de Transporte de mascotas por Hora By PGonzales01', 1, 0, 2, 2);
 insert into TRANSPORT values (2, 'Servicio de Transporte de mascotas por Día By LuisGonzales01', 1, 1, 3, 5);
 insert into TRANSPORT values (3, 'Servicio de Transporte de mascotas por Día By PepePer01', 1, 1, 3, 1);
 
 
 --Sección Servicios de Tránsito
 insert into TRANSIT values (1, 'Servicio de Tránsito de mascotas por Día By JGarcia01', 1, 1, 4, 3);
 insert into TRANSIT values (2, 'Servicio de Tránsito de mascotas por Semana By Rsmith', 1, 2, 2, 6);
 insert into TRANSIT values (3, 'Servicio de Tránsito de mascotas por Semana By PepePer01', 1, 2, 2, 1);
 -----------------------------------------------------------------------------------------------------------------------------------------------------------
