DELIMITER %%
CREATE PROCEDURE usp_get_older(searchedId INT)
BEGIN

UPDATE `minions`
SET `age` = `age` + 1
WHERE `id` = searchedId;

END%%