DROP TABLE IF EXISTS "user";

CREATE FUNCTION random_uuid() RETURNS UUID AS $$
BEGIN
RETURN md5(random()::text || clock_timestamp()::text)::cstring;
END;
$$
LANGUAGE PLPGSQL;



CREATE TABLE team
(
  id   UUID default random_uuid(),
  name CHARACTER VARYING(255) NOT NULL,
  CONSTRAINT team_pkey PRIMARY KEY (id)
);


CREATE TABLE "user"
(
  id         UUID DEFAULT random_uuid(),
  email      CHARACTER VARYING(255) NOT NULL UNIQUE,
  password   CHARACTER VARYING(255) NOT NULL,
  group_type CHARACTER VARYING(255) NOT NULL DEFAULT 'USER',
  team_id    CHARACTER VARYING(255) NOT NULL,
  position   CHARACTER VARYING(255),
  CONSTRAINT user_pkey PRIMARY KEY (id)
);

CREATE TABLE equipment_group
(
  id   UUID default random_uuid(),
  name CHARACTER VARYING(255) NOT NULL UNIQUE,
  CONSTRAINT equipment_group_pkey PRIMARY KEY (id)
);


CREATE TABLE equipment
(
  id                                UUID DEFAULT random_uuid(),
  serial_number                     CHARACTER VARYING(500) NOT NULL UNIQUE,
  model                             CHARACTER VARYING(500) NOT NULL,
  equipment_group_id                UUID,
  checklist_jamcloud_enrollment     CHARACTER VARYING(500),
  checklist_confirmation_of_receipt CHARACTER VARYING(500),
  purchase_timestamp                TIMESTAMP,
  qr_code                           TEXT,
  invoice                           CHARACTER VARYING(500),
  price                             DOUBLE PRECISION,
  CONSTRAINT equipment_pkey PRIMARY KEY (id)
);

CREATE TABLE equipment_ownership
(
  id                   UUID DEFAULT random_uuid(),
  user_id              UUID,
  equipment_id         UUID,
  assignment_timestamp timestamp,
  dismission_timestamp timestamp,
  CONSTRAINT equipment_ownership_pkey PRIMARY KEY (id)
);

CREATE TABLE repair
(
  id           UUID DEFAULT random_uuid(),
  equipment_id UUID,
  description  text,
  price        DOUBLE PRECISION,
  CONSTRAINT repair_pkey PRIMARY KEY (id)
);

CREATE TABLE repair_attachment
(
  id   UUID DEFAULT random_uuid(),
  type CHARACTER VARYING(500),
  link CHARACTER VARYING(500),
  CONSTRAINT repair_attachment_pkey PRIMARY KEY (id)
);