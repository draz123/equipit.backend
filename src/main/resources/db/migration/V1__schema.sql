DROP TABLE IF EXISTS "user";


CREATE FUNCTION random_uuid() RETURNS UUID AS $$
BEGIN
RETURN md5(random()::text || clock_timestamp()::text)::cstring;
END;
$$
LANGUAGE PLPGSQL;


CREATE TABLE "user" (
                      id         UUID default random_uuid(),
                      email      CHARACTER VARYING(255) NOT NULL UNIQUE,
                      password   CHARACTER VARYING(255) NOT NULL,
                      group_type CHARACTER VARYING(255) NOT NULL DEFAULT 'USER',
                      CONSTRAINT user_pkey PRIMARY KEY (id)
);
