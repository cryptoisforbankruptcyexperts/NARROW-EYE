-- OM SAI RAM

-- DELETE FROM Patrolling;
-- DELETE FROM TechnicalSkills;
-- DELETE FROM TerroristsInformation;
-- DELETE FROM Budget;
-- DELETE FROM Informers;
-- DELETE FROM ElectronicDevices;
-- DELETE FROM Causalities;
-- DELETE FROM TerroristActivities;
-- DELETE FROM AlphaAgents;
-- DELETE FROM BetaAgents;
-- DELETE FROM OperationDirector;
-- DELETE FROM SkillSet;
-- DELETE FROM WeaponsData;


INSERT INTO BetaAgents values ('1410301BQ','Nick','Keron',35600,'robert','UPI49123','Ukranian',3,'dac3169ae19731ae1a26d9142496b25e0f98b01bb61a91cef59969566f44538a');

INSERT INTO SkillSet values ('SK1410101','Shooting', 'Yes','108','yes');

INSERT INTO WeaponsData values ('WP1410201','AK47','No','No','Yes');

INSERT INTO AlphaAgents values ('1410501AE','Mark','Henry',56000,'Peter','NPI89706','European','181','Georgian','Chin','TSA89078','dac3169ae19731ae1a26d9142496b25e0f98b01bb61a91cef59969566f44538a','SK1410101','WP1410201');

INSERT INTO TechnicalSkills values ('TC1410701','Hacking',10,'Yes','hard','Computing','1410301BQ');

INSERT INTO OperationDirector values ('CX1410110','Van Schneider','NarrowEye','Ukraine','dac3169ae19731ae1a26d9142496b25e0f98b01bb61a91cef59969566f44538a');

INSERT INTO TerroristsInformation values ('TR1410901','Owaisi','Asaduddeen',5.11,'white','Asian','Russia','no','CX1410110','1410301BQ','1410501AE');

INSERT INTO Budget values ('EveningSupper','12-21-2018 04-48-31',338,'1410501AE','CX1410110');

INSERT INTO Informers values ('IF1410601','Masood','rock','teacher',10,'1410301BQ');

INSERT INTO ElectronicDevices values ('CSX9492523371','WirelessModem','R1YTZ94',4987,'Yes','Yes','1410301BQ');

INSERT INTO TerroristActivities values ('04-21-2019 04-18-20','Kyiv',10,'Major attack','1410501AE');

INSERT INTO Causalities values ('04-21-2019 04-18-20','Kyiv','Yakob','Ukrania','European','96700');

INSERT INTO Patrolling values ('PT1410001','03-14-2019 04-19-20','Kyiv','MaxiTruck','morningRegular','Benjamin','1410501AE');
