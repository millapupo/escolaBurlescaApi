  create table professoras(

      id bigint not null auto_increment,
      nome varchar(100) not null,
      email varchar(100) not null unique,
      telefone varchar(10) not null unique,
      modalidades varchar(200) not null,

      primary key(id)

  );