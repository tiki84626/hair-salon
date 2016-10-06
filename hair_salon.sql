--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.4
-- Dumped by pg_dump version 9.5.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner:
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner:
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: clients; Type: TABLE; Schema: public; Owner:
--

CREATE TABLE clients (
    id integer NOT NULL,
    name character varying,
    email character varying,
    phonenumber character varying,
    appointment date,
    stylistid integer
);


ALTER TABLE clients OWNER TO t1k1;

--
-- Name: clients_id_seq; Type: SEQUENCE; Schema: public; Owner: t1k1
--

CREATE SEQUENCE clients_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE clients_id_seq OWNER TO t1k1;

--
-- Name: clients_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: t1k1
--

ALTER SEQUENCE clients_id_seq OWNED BY clients.id;


--
-- Name: hair_salons; Type: TABLE; Schema: public; Owner: t1k1
--

CREATE TABLE hair_salons (
    id integer NOT NULL,
    name character varying,
    location character varying,
    website character varying,
    description character varying
);


ALTER TABLE hair_salons OWNER TO t1k1;

--
-- Name: hair_salons_id_seq; Type: SEQUENCE; Schema: public; Owner: t1k1
--

CREATE SEQUENCE hair_salons_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE hair_salons_id_seq OWNER TO t1k1;

--
-- Name: hair_salons_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: t1k1
--

ALTER SEQUENCE hair_salons_id_seq OWNED BY hair_salons.id;


--
-- Name: stylists; Type: TABLE; Schema: public; Owner: t1k1
--

CREATE TABLE stylists (
    id integer NOT NULL,
    name character varying,
    email character varying,
    phonenumber character varying,
    hairsalonid integer
);


ALTER TABLE stylists OWNER TO t1k1;

--
-- Name: stylists_id_seq; Type: SEQUENCE; Schema: public; Owner: t1k1
--

CREATE SEQUENCE stylists_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE stylists_id_seq OWNER TO t1k1;

--
-- Name: stylists_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: t1k1
--

ALTER SEQUENCE stylists_id_seq OWNED BY stylists.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: t1k1
--

ALTER TABLE ONLY clients ALTER COLUMN id SET DEFAULT nextval('clients_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: t1k1
--

ALTER TABLE ONLY hair_salons ALTER COLUMN id SET DEFAULT nextval('hair_salons_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: t1k1
--

ALTER TABLE ONLY stylists ALTER COLUMN id SET DEFAULT nextval('stylists_id_seq'::regclass);


--
-- Data for Name: clients; Type: TABLE DATA; Schema: public; Owner: t1k1
--

COPY clients (id, name, email, phonenumber, appointment, stylistid) FROM stdin;
\.


--
-- Name: clients_id_seq; Type: SEQUENCE SET; Schema: public; Owner: t1k1
--

SELECT pg_catalog.setval('clients_id_seq', 1, false);


--
-- Data for Name: hair_salons; Type: TABLE DATA; Schema: public; Owner: t1k1
--

COPY hair_salons (id, name, location, website, description) FROM stdin;
\.


--
-- Name: hair_salons_id_seq; Type: SEQUENCE SET; Schema: public; Owner: t1k1
--

SELECT pg_catalog.setval('hair_salons_id_seq', 1, false);


--
-- Data for Name: stylists; Type: TABLE DATA; Schema: public; Owner: t1k1
--

COPY stylists (id, name, email, phonenumber, hairsalonid) FROM stdin;
\.


--
-- Name: stylists_id_seq; Type: SEQUENCE SET; Schema: public; Owner: t1k1
--

SELECT pg_catalog.setval('stylists_id_seq', 1, false);


--
-- Name: clients_pkey; Type: CONSTRAINT; Schema: public; Owner: t1k1
--

ALTER TABLE ONLY clients
    ADD CONSTRAINT clients_pkey PRIMARY KEY (id);


--
-- Name: hair_salons_pkey; Type: CONSTRAINT; Schema: public; Owner: t1k1
--

ALTER TABLE ONLY hair_salons
    ADD CONSTRAINT hair_salons_pkey PRIMARY KEY (id);


--
-- Name: stylists_pkey; Type: CONSTRAINT; Schema: public; Owner: t1k1
--

ALTER TABLE ONLY stylists
    ADD CONSTRAINT stylists_pkey PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: t1k1
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM t1k1;
GRANT ALL ON SCHEMA public TO t1k1;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--
