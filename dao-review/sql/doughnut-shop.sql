CREATE TABLE IF NOT EXISTS doughnut (
  id SERIAL,
  name VARCHAR(255) NOT NULL,
  price_in_cents INTEGER NOT NULL DEFAULT 100,
  inventory_count INTEGER NOT NULL DEFAULT 0,
  filling_id INTEGER NULL,
  CONSTRAINT pk_doughnut PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS topping (
  id SERIAL,
  name VARCHAR(255) NOT NULL,
  CONSTRAINT pk_topping PRIMARY KEY (id) 
);

CREATE TABLE IF NOT EXISTS filling (
  id SERIAL,
  name VARCHAR(255) NOT NULL,
  CONSTRAINT pk_filling PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS doughnut_topping (
  doughnut_id INTEGER NOT NULL,
  topping_id INTEGER NOT NULL,
  CONSTRAINT pk_doughnut_topping PRIMARY KEY(doughnut_id, topping_id)
);

ALTER TABLE doughnut ADD CONSTRAINT fk_doughnut_filling FOREIGN KEY (filling_id) REFERENCES filling (id);
ALTER TABLE doughnut_topping ADD CONSTRAINT fk_doughnut_topping_doughnut FOREIGN KEY (doughnut_id) REFERENCES doughnut (id);
ALTER TABLE doughnut_topping ADD CONSTRAINT fk_doughnut_topping_topping FOREIGN KEY (topping_id) REFERENCES topping (id);

