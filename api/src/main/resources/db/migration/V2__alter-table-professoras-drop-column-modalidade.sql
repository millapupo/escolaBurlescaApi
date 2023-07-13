alter table professoras drop column modalidades;

create table professoras_modalidades(
    professora_id bigint not null,
    modalidade varchar(255) not null,

    primary key (professora_id, modalidade),
    constraint fk_professora_modalidade foreign key (professora_id) references professoras (id)
);
