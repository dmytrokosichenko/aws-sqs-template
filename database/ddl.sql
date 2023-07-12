-- Table: public.events


DROP TABLE IF EXISTS public.events;

CREATE TABLE IF NOT EXISTS public.events
(
    id bigint NOT NULL,
    date date,
    title character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT events_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.events
    OWNER to root;


DROP TABLE IF EXISTS public.users;

CREATE TABLE IF NOT EXISTS public.users
(
    id bigint NOT NULL DEFAULT nextval('users_id_seq'::regclass),
    name character varying(255) COLLATE pg_catalog."default",
    email character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT users_pkey PRIMARY KEY (id),
    CONSTRAINT users_email_key UNIQUE (email),
    CONSTRAINT users_name_key UNIQUE (name)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.users
    OWNER to root;
	

DROP TABLE IF EXISTS public.tickets;

CREATE TABLE IF NOT EXISTS public.tickets
(
    id bigint NOT NULL,
    category character varying(255) COLLATE pg_catalog."default",
    event_id bigint,
    place integer NOT NULL,
    price integer,
    user_id bigint,
    userid bigint,
    CONSTRAINT tickets_pkey PRIMARY KEY (id),
    CONSTRAINT fk3utafe14rupaypjocldjaj4ol FOREIGN KEY (event_id)
        REFERENCES public.events (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk50yxlfpjboqn8lk8ooldw438k FOREIGN KEY (userid)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT tickets_category_check CHECK (category::text = ANY (ARRAY['STANDARD'::character varying, 'PREMIUM'::character varying, 'BAR'::character varying]::text[]))
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tickets
    OWNER to root;
	

DROP TABLE IF EXISTS public.user_accounts;

CREATE TABLE IF NOT EXISTS public.user_accounts
(
    id bigint NOT NULL,
    balance integer,
    userid bigint,
    user_id bigint NOT NULL,
    CONSTRAINT user_accounts_pkey PRIMARY KEY (id),
    CONSTRAINT fkeu175seh3s7swirv0s1ugieyu FOREIGN KEY (user_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.user_accounts
    OWNER to root;