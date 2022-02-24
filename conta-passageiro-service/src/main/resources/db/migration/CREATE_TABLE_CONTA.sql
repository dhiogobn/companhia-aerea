create table conta_passageiro_service(
	idConta int(10) AUTO_INCREMENT primary key,
	login varchar(20),
	senha varchar(20),
	nomeDeUsuario varchar(50),
	dataCriacaoConta date
)