CREATE TABLE usr (
  id BIGINT PRIMARY KEY,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  role VARCHAR(32) NOT NULL CHECK (role IN ('BIDDER', 'PREFABRICATOR'))
);

CREATE TABLE project (
  id BIGINT PRIMARY KEY,
  beginning_date DATE NOT NULL,
  name VARCHAR(255) NOT NULL
);

CREATE TABLE control_cabinet (
  id BIGINT PRIMARY KEY,
  real_time BIGINT NOT NULL,
  esitmated_time BIGINT NOT NULL,
  valuation_cost BIGINT NOT NULL,
  adjusted_cost BIGINT NOT NULL,
  current BIGINT NOT NULL,
  device_amount BIGINT NOT NULL,
  plc_input BIGINT NOT NULL,
  plc_output BIGINT NOT NULL,
  drive_amount BIGINT NOT NULL,
  protection_amount BIGINT NOT NULL,
  contactors_amount BIGINT NOT NULL,
  is_archive BOOLEAN NOT NULL,
  not_used_in_model BOOLEAN NOT NULL,
  to_valuation BOOLEAN NOT NULL,
  offerer_id BIGINT NOT NULL REFERENCES usr(id),
  project_id BIGINT NOT NULL REFERENCES project(id)
);

-- CREATE TABLE offer_control_cabinet (
--   offer_id BIGINT NOT NULL REFERENCES project(id) ON DELETE CASCADE,
--   control_cabinet_id BIGINT NOT NULL REFERENCES control_cabinet(id) ON DELETE CASCADE,
--   PRIMARY KEY (offer_id, control_cabinet_id)
-- );