-- This script was generated by a beta version of the ERD tool in pgAdmin 4.
-- Please log an issue at https://redmine.postgresql.org/projects/pgadmin4/issues/new if you find any bugs, including reproduction steps.
BEGIN;


CREATE TABLE IF NOT EXISTS public.contato
(
    user_id uuid NOT NULL,
    data_nascimento date,
    endereco character varying(255) COLLATE pg_catalog."default",
    nome_completo character varying(255) COLLATE pg_catalog."default",
    telefone character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT contato_pkey PRIMARY KEY (user_id)
);

CREATE TABLE IF NOT EXISTS public.equipamento
(
    id_equipamento bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    detalhes character varying(255) COLLATE pg_catalog."default",
    marca character varying(255) COLLATE pg_catalog."default",
    modelo character varying(255) COLLATE pg_catalog."default",
    numero_serie character varying(255) COLLATE pg_catalog."default",
    patrimonio character varying(6) COLLATE pg_catalog."default" NOT NULL,
    tipo_equipamento character varying(255) COLLATE pg_catalog."default" NOT NULL,
    setor_id bigint,
    CONSTRAINT equipamento_pkey PRIMARY KEY (id_equipamento),
    CONSTRAINT uk_5j0fo8o49oc6015xatjs1vmh7 UNIQUE (patrimonio)
);

CREATE TABLE IF NOT EXISTS public.ordem_servico
(
    id_ordem_servico uuid NOT NULL,
    data_final timestamp without time zone,
    data_inicial timestamp without time zone NOT NULL,
    descricao_problema character varying(255) COLLATE pg_catalog."default" NOT NULL,
    diagnostico character varying(255) COLLATE pg_catalog."default",
    observacao character varying(255) COLLATE pg_catalog."default",
    situacao character varying(255) COLLATE pg_catalog."default" NOT NULL,
    equipamento_id bigint,
    setor_id_setor bigint,
    CONSTRAINT ordem_servico_pkey PRIMARY KEY (id_ordem_servico)
);

CREATE TABLE IF NOT EXISTS public.ordem_servico_servicos
(
    ordem_servico_id_ordem_servico uuid NOT NULL,
    servicos_id_servico bigint NOT NULL,
    CONSTRAINT uk_4foymvqckewaqcu1nx3nkp832 UNIQUE (servicos_id_servico)
);

CREATE TABLE IF NOT EXISTS public.ordemservico_suporte
(
    ordemservico_id uuid NOT NULL,
    suporte_id bigint NOT NULL
);

CREATE TABLE IF NOT EXISTS public.refreshtoken
(
    id uuid NOT NULL,
    expiry_date timestamp without time zone NOT NULL,
    token character varying(255) COLLATE pg_catalog."default" NOT NULL,
    user_user_id uuid,
    CONSTRAINT refreshtoken_pkey PRIMARY KEY (id),
    CONSTRAINT uk_or156wbneyk8noo4jstv55ii3 UNIQUE (token)
);

CREATE TABLE IF NOT EXISTS public.roles
(
    id uuid NOT NULL,
    name character varying(20) COLLATE pg_catalog."default",
    CONSTRAINT roles_pkey PRIMARY KEY (id),
    CONSTRAINT uk_ofx66keruapi6vyqpv6f2or37 UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS public.secretaria
(
    id_secretaria bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    secretaria character varying(255) COLLATE pg_catalog."default",
    secretario character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT secretaria_pkey PRIMARY KEY (id_secretaria),
    CONSTRAINT uk_25h0hgam2lxbp49b5ib51agb4 UNIQUE (secretaria)
);

CREATE TABLE IF NOT EXISTS public.servico
(
    id_servico bigint NOT NULL,
    data_servico date NOT NULL,
    descricao_servico character varying(255) COLLATE pg_catalog."default" NOT NULL,
    ordem_servico_id uuid,
    CONSTRAINT servico_pkey PRIMARY KEY (id_servico)
);

CREATE TABLE IF NOT EXISTS public.setor
(
    id_setor bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    responsavel character varying(255) COLLATE pg_catalog."default",
    setor character varying(255) COLLATE pg_catalog."default" NOT NULL,
    secretaria_id bigint NOT NULL,
    CONSTRAINT setor_pkey PRIMARY KEY (id_setor),
    CONSTRAINT uk_3u1tpx1tpfnnru2x3mq0jelkw UNIQUE (setor)
);

CREATE TABLE IF NOT EXISTS public.suporte
(
    id_suporte bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    empresa character varying(255) COLLATE pg_catalog."default",
    nome character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT suporte_pkey PRIMARY KEY (id_suporte),
    CONSTRAINT uk_nr57ih75ttbyq030vst2pmtwt UNIQUE (nome)
);

CREATE TABLE IF NOT EXISTS public.user_roles
(
    user_id uuid NOT NULL,
    role_id uuid NOT NULL
);

CREATE TABLE IF NOT EXISTS public.users
(
    user_id uuid NOT NULL,
    email character varying(50) COLLATE pg_catalog."default",
    password character varying(120) COLLATE pg_catalog."default",
    username character varying(20) COLLATE pg_catalog."default",
    CONSTRAINT users_pkey PRIMARY KEY (user_id),
    CONSTRAINT uk6dotkott2kjsp8vw4d0m25fb7 UNIQUE (email),
    CONSTRAINT ukr43af9ap4edm43mmtq01oddj6 UNIQUE (username)
);

ALTER TABLE IF EXISTS public.contato
    ADD CONSTRAINT fksguaaq1yxk7n6so0odou5uj25 FOREIGN KEY (user_id)
    REFERENCES public.users (user_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;
CREATE INDEX IF NOT EXISTS contato_pkey
    ON public.contato(user_id);


ALTER TABLE IF EXISTS public.equipamento
    ADD CONSTRAINT fk74xde53v4q83otd6ahxcy8ul3 FOREIGN KEY (setor_id)
    REFERENCES public.setor (id_setor) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.ordem_servico
    ADD CONSTRAINT fkk0vi5ptiqi5fe9xl9yrexa8ua FOREIGN KEY (equipamento_id)
    REFERENCES public.equipamento (id_equipamento) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.ordem_servico
    ADD CONSTRAINT fkrwflg1136etg8n06ncsobg4qy FOREIGN KEY (setor_id_setor)
    REFERENCES public.setor (id_setor) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.ordem_servico_servicos
    ADD CONSTRAINT fk8sbdhv1ylj8m54jd21b9g7igo FOREIGN KEY (servicos_id_servico)
    REFERENCES public.servico (id_servico) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;
CREATE INDEX IF NOT EXISTS uk_4foymvqckewaqcu1nx3nkp832
    ON public.ordem_servico_servicos(servicos_id_servico);


ALTER TABLE IF EXISTS public.ordem_servico_servicos
    ADD CONSTRAINT fkl80mdqw4112g4f83s5ltqb015 FOREIGN KEY (ordem_servico_id_ordem_servico)
    REFERENCES public.ordem_servico (id_ordem_servico) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.ordemservico_suporte
    ADD CONSTRAINT fkb85buuk0s12itjipmxsmqyget FOREIGN KEY (ordemservico_id)
    REFERENCES public.ordem_servico (id_ordem_servico) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.ordemservico_suporte
    ADD CONSTRAINT fke282h06264d24h9grn31odhro FOREIGN KEY (suporte_id)
    REFERENCES public.suporte (id_suporte) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.refreshtoken
    ADD CONSTRAINT fkao70jnmqfy4dmntwpvv142ayh FOREIGN KEY (user_user_id)
    REFERENCES public.users (user_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.servico
    ADD CONSTRAINT fk9pcno8j0hfg9f3waib49ln36b FOREIGN KEY (ordem_servico_id)
    REFERENCES public.ordem_servico (id_ordem_servico) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.setor
    ADD CONSTRAINT fkt31ekdj4hj36bqqwms396hggb FOREIGN KEY (secretaria_id)
    REFERENCES public.secretaria (id_secretaria) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.user_roles
    ADD CONSTRAINT fkh8ciramu9cc9q3qcqiv4ue8a6 FOREIGN KEY (role_id)
    REFERENCES public.roles (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;


ALTER TABLE IF EXISTS public.user_roles
    ADD CONSTRAINT fkhfh9dx7w3ubf1co1vdev94g3f FOREIGN KEY (user_id)
    REFERENCES public.users (user_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

END;