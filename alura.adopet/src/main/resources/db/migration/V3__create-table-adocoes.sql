CREATE TABLE adocoes (
    id BIGINT NOT NULL IDENTITY(1,1),
    tutor_id BIGINT NOT NULL,
    pet_id BIGINT NOT NULL,
    status VARCHAR(50) NOT NULL,
    motivo VARCHAR(100) NOT NULL,
    justificativa VARCHAR(100),
    CONSTRAINT PK_adocoes PRIMARY KEY (id),
    CONSTRAINT fk_adocoes_tutor_id FOREIGN KEY (tutor_id) REFERENCES tutores (id),
    CONSTRAINT fk_adocoes_pet_id FOREIGN KEY (pet_id) REFERENCES pets (id)
);
