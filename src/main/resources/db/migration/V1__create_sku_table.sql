CREATE TABLE sku (
    id           BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    sku_code     VARCHAR(64) NOT NULL UNIQUE,
    name         VARCHAR(255) NOT NULL,
    description  TEXT,
    created_at   TIMESTAMPTZ NOT NULL DEFAULT now(),
    updated_at   TIMESTAMPTZ NOT NULL DEFAULT now(),

    CONSTRAINT   sku_code_not_blank CHECK (length(trim(sku_code)) > 0),
    CONSTRAINT   sku_name_not_blank CHECK (length(trim(name)) > 0)
);