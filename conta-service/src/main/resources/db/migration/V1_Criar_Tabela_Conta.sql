create table conta(
	id int(10) AUTO_INCREMENT primary key,
    conta int(10) not null,
    titular varchar(100)not null,
    agencia int(4) not null,
    saldo numeric(10, 2) not null
)ENGINE=InnoDB DEFAULT CHARSET=latin1;