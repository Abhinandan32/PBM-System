CREATE TABLE usr (
  id BIGINT PRIMARY KEY,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  role VARCHAR(32) NOT NULL CHECK (role IN ('BIDDER', 'PREFABRICATOR'))
);

CREATE TABLE control_cabinet (
  id BIGINT PRIMARY KEY,
  real_time BIGINT NOT NULL,
  esitmated_time BIGINT NOT NULL,
  valuation_cost BIGINT NOT NULL,
  adjusted_cost BIGINT NOT NULL,
  x_dimension BIGINT NOT NULL,
  y_dimension BIGINT NOT NULL,
  amperes BIGINT NOT NULL,
  device_amount BIGINT NOT NULL,
  plc_input BIGINT NOT NULL,
  plc_output BIGINT NOT NULL,
  drive_amount BIGINT NOT NULL,
  inventer_amount BIGINT NOT NULL,
  safety BOOLEAN NOT NULL
);

CREATE TABLE offer (
  id BIGINT PRIMARY KEY,
  offerer_id BIGINT NOT NULL REFERENCES usr(id),
  date DATE NOT NULL
);

CREATE TABLE offer_control_cabinet (
  offer_id BIGINT NOT NULL REFERENCES offer(id) ON DELETE CASCADE,
  control_cabinet_id BIGINT NOT NULL REFERENCES control_cabinet(id) ON DELETE CASCADE,
  PRIMARY KEY (offer_id, control_cabinet_id)
);