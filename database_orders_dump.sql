--
-- PostgreSQL database dump
--

-- Dumped from database version 17.4
-- Dumped by pg_dump version 17.4

-- Started on 2025-04-10 08:56:18

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 218 (class 1259 OID 16429)
-- Name: orders; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.orders (
    id integer NOT NULL,
    user_id integer NOT NULL,
    product_name character varying(100) NOT NULL,
    amount numeric(10,2) NOT NULL,
    status character varying(20) DEFAULT 'PENDING'::character varying,
    created_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);


ALTER TABLE public.orders OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16428)
-- Name: orders_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.orders_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.orders_id_seq OWNER TO postgres;

--
-- TOC entry 4853 (class 0 OID 0)
-- Dependencies: 217
-- Name: orders_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.orders_id_seq OWNED BY public.orders.id;


--
-- TOC entry 4695 (class 2604 OID 16432)
-- Name: orders id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders ALTER COLUMN id SET DEFAULT nextval('public.orders_id_seq'::regclass);


--
-- TOC entry 4847 (class 0 OID 16429)
-- Dependencies: 218
-- Data for Name: orders; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.orders (id, user_id, product_name, amount, status, created_at, updated_at) FROM stdin;
1	1	Wireless Mouse	25.99	PENDING	2025-04-09 07:25:31.025551	2025-04-09 07:25:31.025551
2	2	Mechanical Keyboard	89.50	SHIPPED	2025-04-09 07:25:31.025551	2025-04-09 07:25:31.025551
3	3	USB-C Cable	12.00	DELIVERED	2025-04-09 07:25:31.025551	2025-04-09 07:25:31.025551
4	4	Laptop Stand	42.75	CANCELLED	2025-04-09 07:25:31.025551	2025-04-09 07:25:31.025551
5	5	Bluetooth Speaker	59.99	PENDING	2025-04-09 07:25:31.025551	2025-04-09 07:25:31.025551
6	6	Webcam	39.95	SHIPPED	2025-04-09 07:25:31.025551	2025-04-09 07:25:31.025551
7	7	External SSD	120.00	DELIVERED	2025-04-09 07:25:31.025551	2025-04-09 07:25:31.025551
8	8	Gaming Monitor	299.99	PENDING	2025-04-09 07:25:31.025551	2025-04-09 07:25:31.025551
9	9	Phone Charger	18.25	DELIVERED	2025-04-09 07:25:31.025551	2025-04-09 07:25:31.025551
10	10	Smart Watch	159.49	SHIPPED	2025-04-09 07:25:31.025551	2025-04-09 07:25:31.025551
11	1	Desk Lamp	34.90	PENDING	2025-04-09 07:25:31.025551	2025-04-09 07:25:31.025551
12	2	Wireless Earbuds	79.99	DELIVERED	2025-04-09 07:25:31.025551	2025-04-09 07:25:31.025551
13	3	HDMI Cable	9.99	DELIVERED	2025-04-09 07:25:31.025551	2025-04-09 07:25:31.025551
14	4	Graphic Tablet	129.00	CANCELLED	2025-04-09 07:25:31.025551	2025-04-09 07:25:31.025551
15	5	Portable Fan	21.85	PENDING	2025-04-09 07:25:31.025551	2025-04-09 07:25:31.025551
16	6	Fitness Tracker	64.99	SHIPPED	2025-04-09 07:25:31.025551	2025-04-09 07:25:31.025551
17	7	Gaming Mouse Pad	19.99	DELIVERED	2025-04-09 07:25:31.025551	2025-04-09 07:25:31.025551
18	8	Laptop Bag	45.00	PENDING	2025-04-09 07:25:31.025551	2025-04-09 07:25:31.025551
19	9	Phone Case	14.75	DELIVERED	2025-04-09 07:25:31.025551	2025-04-09 07:25:31.025551
20	10	VR Headset	349.00	SHIPPED	2025-04-09 07:25:31.025551	2025-04-09 07:25:31.025551
21	1	Router	89.00	PENDING	2025-04-09 07:25:31.025551	2025-04-09 07:25:31.025551
22	2	Noise Cancelling Headphones	199.99	DELIVERED	2025-04-09 07:25:31.025551	2025-04-09 07:25:31.025551
23	3	Microphone	55.00	SHIPPED	2025-04-09 07:25:31.025551	2025-04-09 07:25:31.025551
24	4	Office Chair	210.49	CANCELLED	2025-04-09 07:25:31.025551	2025-04-09 07:25:31.025551
25	5	Keyboard Wrist Rest	15.99	DELIVERED	2025-04-09 07:25:31.025551	2025-04-09 07:25:31.025551
26	6	USB Hub	24.99	PENDING	2025-04-09 07:25:31.025551	2025-04-09 07:25:31.025551
27	7	Flash Drive 128GB	17.50	DELIVERED	2025-04-09 07:25:31.025551	2025-04-09 07:25:31.025551
28	8	Smartphone Tripod	28.90	SHIPPED	2025-04-09 07:25:31.025551	2025-04-09 07:25:31.025551
29	9	Drawing Stylus	33.33	PENDING	2025-04-09 07:25:31.025551	2025-04-09 07:25:31.025551
30	10	Ergonomic Mouse	49.95	DELIVERED	2025-04-09 07:25:31.025551	2025-04-09 07:25:31.025551
\.


--
-- TOC entry 4854 (class 0 OID 0)
-- Dependencies: 217
-- Name: orders_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.orders_id_seq', 30, true);


--
-- TOC entry 4700 (class 2606 OID 16436)
-- Name: orders orders_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);


-- Completed on 2025-04-10 08:56:19

--
-- PostgreSQL database dump complete
--

