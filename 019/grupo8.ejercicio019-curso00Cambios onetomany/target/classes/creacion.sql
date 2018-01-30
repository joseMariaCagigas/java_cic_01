CREATE SCHEMA `todo` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE nota (
	id INT NOT NULL,
	id_usuario INT,
	id_url INT,
	contenido TEXT,
	esta_hecho BIT,
	PRIMARY KEY (id)
);
