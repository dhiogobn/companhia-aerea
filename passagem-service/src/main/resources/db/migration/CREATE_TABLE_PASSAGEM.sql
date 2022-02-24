create table passagem_service(
	id int(10) AUTO_INCREMENT primary key,
	login varchar(20) not null,
	cpf varchar(50) not null,
	dataDeCompra date not null,
	dataDoEmbarque date not null,
	valor numeric(10, 2) not null
)