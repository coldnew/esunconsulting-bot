-- name: esunconsulting-create-url!
-- creates a new url record
INSERT INTO esunconsulting (url)
VALUES (:url)

-- name: esunconsulting-get-url
-- retrieve a esunconsulting given the url.
SELECT * FROM esunconsulting
WHERE url = :url

-- name: esunconsulting-delete-url
-- delete a esunconsulting given the url.
DELETE * FROM esunconsulting
WHERE url = :url

-- name: esunconsulting-list-all-url
-- list all url from tweets
SELECT * from esunconsulting;