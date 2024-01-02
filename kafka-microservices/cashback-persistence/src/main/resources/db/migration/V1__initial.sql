DROP TABLE IF EXISTS "cashback";

CREATE TABLE "cashback" (
    "pay_code" text NOT NULL,
    "title" text,
    "client_id" bigint,
    CONSTRAINT "cashBack_pkey" PRIMARY KEY ("pay_code")
);
