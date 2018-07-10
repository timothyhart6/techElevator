TRUNCATE doughnut, filling, topping CASCADE;

WITH create_filling as (
  INSERT INTO filling (name)
  VALUES ('Pastry Cream')
  RETURNING id
)

INSERT INTO doughnut (name, filling_id)
SELECT 'Chocolate Bismark', cf.id
  FROM create_filling cf;

INSERT INTO doughnut (name)
VALUES ('Plain')

-- GET ALL OF THE DOUGHNUTS, AND THE ASSOCIATED FILLING IF IT HAS ONE
SELECT * 
  FROM doughnut d
  LEFT JOIN filling f
    ON d.filling_id = f.id
