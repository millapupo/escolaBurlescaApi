create table aulas(

    id bigint not null auto_increment,
    professora_id bigint not null,
    aluna_id bigint not null,
    data datetime not null,

    primary key(id),
    constraint fk_aulas_professora_id foreign key(professora_id) references professoras(id),
    constraint fk_aulas_aluna_id foreign key(aluna_id) references alunas(id)

);