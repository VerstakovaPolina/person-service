SET SEARCH_PATH TO schema;

SELECT * FROM person_data INNER JOIN medical_card ON medical_card.id = person_data.medical_card_id;

DELETE FROM illness WHERE id NOT IN
    ( SELECT id FROM (
                       SELECT MIN(id) AS id
                       FROM illness
                       GROUP BY type_id,heaviness
                     ) unique_rows
);

SELECT * FROM medical_card ORDER BY id LIMIT
    (SELECT COUNT(id)/2 FROM medical_card);

SELECT child.first_name, child.last_name, parent.first_name, parent.last_name
FROM person_data AS child JOIN person_data AS parent ON child.parent_id=parent.id
WHERE parent.medical_card_id IN (SELECT id FROM medical_card WHERE med_status IS NULL);

CREATE VIEW contact_address_data AS
SELECT phone_number,email,city,street,building,flat AS data_for_sending_message
FROM contact join address on contact.id = address.contact_id;