INSERT INTO manufacturer (name, code)
VALUES
  ('Audi', 100),
  ('Chevrolet', 101),
  ('Ford', 102),
  ('BMW', 103),
  ('Dodge', 104);

INSERT INTO car (ID, CONDITION, CREATED_AT, BODY, ENGINE, EXTERNAL_COLOR, FUEL_TYPE, MILEAGE, MODEL, MODEL_YEAR, NUMBER_OF_DOORS, PRODUCTION_YEAR, LAT, LON, MODIFIED_AT, MANUFACTURER_CODE)
VALUES
  (1, 'NEW', CURRENT_TIMESTAMP, 'sedan', '3.6L V6', 'white', 'Gasoline', '32280', 'Impala', 2018, 4, 2018, '40.73061', '-73.935242', CURRENT_TIMESTAMP, 101),
  (2, 'NEW', CURRENT_TIMESTAMP, 'suv', '3.6L V6', 'grey', 'Gasoline', '32280', 'Impala', 2018, 4, 2018, '40.73061', '-73.935242', CURRENT_TIMESTAMP, 102),
  (3, 'USED', CURRENT_TIMESTAMP, 'hatch-back', '3.6L V6', 'white', 'Gasoline', '32280', 'Impala', 2018, 4, 2018, '40.73061', '-73.935242', CURRENT_TIMESTAMP, 103),
  (4, 'USED', CURRENT_TIMESTAMP, 'cross-country', '3.6L V6', 'white', 'Gasoline', '32280', 'Impala', 2018, 4, 2018, '40.73061', '-73.935242', CURRENT_TIMESTAMP, 104);