DROP TABLE IF EXISTS "client_table";
DROP SEQUENCE IF EXISTS client_id_seq;
CREATE SEQUENCE client_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

CREATE TABLE "client_table" (
    "id" bigint DEFAULT nextval('client_id_seq') NOT NULL,
    "name" text,
    "age" integer,
    CONSTRAINT "client_pkey" PRIMARY KEY ("id")
);

INSERT INTO "client_table" ("id", "name", "age") VALUES
(1,	'Abigail Rose',	80),
(2,	'Adam Parker',	36),
(3,	'Adeline Rivers',	49),
(4,	'Aiden Knight',	87),
(5,	'Alexa Stone',	34),
(6,	'Alexander Chase',	22),
(7,	'Alexandria Blake',	43),
(8,	'Allison Ford',	56),
(9,	'Amelia Reed',	63),
(10,	'Andrew Knight',	77),
(11,	'Annabelle Scott',	68),
(12,	'Anthony Green',	70),
(13,	'Ariana Cole',	84),
(14,	'Ashton Stone',	28),
(15,	'Audrey Morgan',	48),
(16,	'Ava Barnes',	81),
(17,	'Benjamin Parker',	25),
(18,	'Bethany Grey',	38),
(19,	'Blake Walker',	67),
(20,	'Bradley Evans',	69),
(21,	'Brianna Flynn',	54),
(22,	'Brooke Stevens',	79),
(23,	'Caleb Davis',	72),
(24,	'Cameron Riley',	66),
(25,	'Caroline King',	46),
(26,	'Carter Scott',	57),
(27,	'Casey Edwards',	75),
(28,	'Cassandra Hill',	74),
(29,	'Charlotte Hayes',	45),
(30,	'Chelsea Jones',	58);

DROP TABLE IF EXISTS "debt_table";
DROP SEQUENCE IF EXISTS debt_id_seq;
CREATE SEQUENCE debt_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

CREATE TABLE "debt_table" (
    "id" bigint DEFAULT nextval('debt_id_seq') NOT NULL,
    "pay_code" text NOT NULL,
    "title" text,
    "client_id" bigint,
    CONSTRAINT "debt_pkey" PRIMARY KEY ("id")
);

INSERT INTO "debt_table" ("id", "pay_code", "title", "client_id") VALUES
(1, '978-1-2345-6789-0',	'The Shadow in the Attic',	1),
(2, '978-1-2345-6789-1',	'Beyond the Horizon',	2),
(3, '978-1-2345-6789-2',	'The Last Ember',	3),
(4, '978-1-2345-6789-3',	'The Forgotten Key',	4),
(5, '978-1-2345-6789-4',	'The Silence in the Woods',	5),
(6, '978-1-2345-6789-5',	'In the Eye of the Storm',	6),
(7, '978-1-2345-6789-6',	'The Seventh Sense',	7),
(8, '978-1-2345-6789-7',	'The Secret of the Stars',	8),
(9, '978-1-2345-6789-8',	'The Forgotten Ones',	9),
(10, '978-1-2345-6789-9',	'The Lost Heirloom',	10),
(11, '978-1-2345-6780-0',	'The Whispering Tree',	11),
(12, '978-1-2345-6780-1',	'The Last Harvest',	12),
(13, '978-1-2345-6780-2',	'The Darkened Path',	13),
(14, '978-1-2345-6780-3',	'The Forgotten City',	14),
(15, '978-1-2345-6780-4',	'The Crystal Key',	15),
(16, '978-1-2345-6780-5',	'The Seventh Scroll',	16),
(17, '978-1-2345-6780-6',	'The Witching Hour',	17),
(18, '978-1-2345-6780-7',	'The Darkening Skies',	18),
(19, '978-1-2345-6780-8',	'The Cursed Mirror',	19),
(20, '978-1-2345-6780-9',	'The Ghost in the Mirror',	20),
(21, '978-1-2345-6781-0',	'The Chosen One',	21),
(22, '978-1-2345-6781-1',	'The Enchanted Forest',	22),
(23, '978-1-2345-6781-2',	'The Hidden Truth',	23),
(24, '978-1-2345-6781-3',	'The Silver Lining',	24),
(25, '978-1-2345-6781-4',	'The Burning Sands',	25),
(26, '978-1-2345-6781-5',	'The Final Countdown',	26),
(27, '978-1-2345-6781-6',	'The Lost Civilization',	27),
(28, '978-1-2345-6781-7',	'The Dead of Night',	28),
(29, '978-1-2345-6781-8',	'The Forgotten Castle',	29),
(30, '978-1-2345-6781-9',	'The Crimson Rose',	30);