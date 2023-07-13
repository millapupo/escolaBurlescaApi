alter table alunas drop column modalidades;

create table alunas_modalidades(
    aluna_id bigint not null,
    modalidade varchar(255) not null,

    primary key (aluna_id, modalidade),
    constraint fk_aluna_modalidade foreign key (aluna_id) references alunas (id)
);
