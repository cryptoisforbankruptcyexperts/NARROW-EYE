--
DROP TABLE Patrolling;
DROP TABLE TechnicalSkills;
DROP TABLE TerroristsInformation;
DROP TABLE Budget;
DROP TABLE Informers;
DROP TABLE ElectronicDevices;
DROP TABLE Causalities;
DROP TABLE TerroristActivities;
DROP TABLE AlphaAgents;
DROP TABLE BetaAgents;
DROP TABLE OperationDirector;
DROP TABLE SkillSet;
DROP TABLE WeaponsData;


--
CREATE TABLE BetaAgents
        (EmpID varchar(15),
        Names varchar(155),
        Aliases varchar(155),
        Salary numeric(10,0),
        SupervisorName varchar(155),
        PassportNo varchar(155),
        MotherTongue varchar(11),
        knownLanguagesCount numeric(3,0),
        primary key (EmpID)
        );
--
CREATE TABLE SkillSet
        (SkillID varchar(15),
        NameOfTheSkill varchar(155),
        RequireWeapons varchar(3),
        DaysToMaster numeric(4,0),
        mustLearn varchar(3),
        primary key (SkillID)
        );

--
CREATE TABLE WeaponsData
        (SerialNo varchar(15),
        NameOfTheWeapon varchar(155),
        SafeToUse varchar(3),
        needAssistanceToOperate varchar(3),
        RequiresExperienceToOperate varchar(3),
        primary key (SerialNo)
        );
--
CREATE TABLE AlphaAgents
        (EmpID varchar(15),
        names varchar(155),
        aliases varchar(155),
        Salary numeric(10,0),
        SupervisorName varchar(155),
        DriversLicence varchar(155),
        Ethnicity varchar(11),
        height varchar(11),
        MotherTongue varchar(11),
        identificationMarks varchar(11),
        PassportNo varchar(11),
        -- languageID varchar(11),
        SkillID varchar(11),
        -- OperationId varchar(11),
        weaponID varchar(15),
        primary key (EmpID),
	    foreign key (SkillID) references SkillSet (SkillID),
        foreign key (weaponID) references WeaponsData (SerialNo)
        );

--
CREATE TABLE TechnicalSkills 
        (TechID varchar(15),
        NameOfTheSkill varchar(155),
        RequiredProficiencyLevel numeric(4,0),
        HasCertifications varchar(3),
        DifficultyLevel varchar(3),
        PrerequisiteSkills varchar(155),
        whoSkilledIn varchar(155),
        primary key (TechID),
        foreign Key (whoSkilledIn) references BetaAgents(EmpID)
        );

-- CREATE TABLE Passport

--         (
--         PassportNo varchar(155),
--         Nationality varchar(15),
--         ExpirationDate varchar(15),
--         IssuedDate varchar(15),
--         );

--
-- CREATE TABLE Languages
    
--         (
--         languageID varchar(155),
--         MotherTongue varchar(155),
--         Preference1 varchar(155),
--         Preference2 varchar(155),
--         Preference3 varchar(155),
--         KnowExtraLanguages varchar(155),
--         spokenBy varchar(15),
--         );

--
CREATE TABLE OperationDirector
        (OperationId varchar(155),
        OperationDirectorName varchar(155),
        OperationName varchar(155),
        OperationLocation varchar(155),
        primary key (OperationId)
        );
--
CREATE TABLE TerroristsInformation
        (IdentityNumber varchar(15),
        NameOfTerrorists varchar(15),
        aliases varchar(15),
        Height numeric(2,2),
        color varchar(15),
        ethnicity varchar(15),
        locationsWhereHeWasFound varchar(155),
        InCustody varchar(3),
        missedToCatch varchar(3),
        CanBeKilled varchar(3),
        InformationSentTo varchar(155),
        CaughtBy varchar(15),
        primary key (IdentityNumber),
	    foreign key (CaughtBy) references AlphaAgents(EmpID),
        foreign key (CaughtBy) references BetaAgents(EmpID),
        foreign key (InformationSentTo) references OperationDirector(OperationId)
        );

--   
CREATE TABLE Budget
        (EventName varchar(155),
        dateTimes varchar(15),
        MoneySpentOnEvent numeric(7,0),
        QuoteSubmittedBy varchar(15),
        AuthorisedBy varchar(15),
        primary key (EventName,dateTimes),
        foreign key (QuoteSubmittedBy) references AlphaAgents(EmpID),
        foreign key (AuthorisedBy) references OperationDirector(OperationId)
        );

--
CREATE TABLE Informers
        (IDNumber varchar(155),
        Name varchar(155),
        aliases varchar(155),
        occupation varchar(155),
        AccuracyLevel numeric(2,0),
        recruitedBy varchar(15),
        primary key (IDNumber),
        foreign key (recruitedBy) references BetaAgents(EmpID)
        );

--
CREATE TABLE ElectronicDevices
        (SerialNumber varchar(155),
        NameOfDevise varchar(155),
        model varchar(155),
        MfdYear numeric(4,0),
        Price numeric(6,0),
        requiresExpInHandling varchar(3),
        requiresMaintenance varchar(3),
        UsedBy varchar(15),
        primary key (SerialNumber),
        foreign key (UsedBy) references BetaAgents(EmpID)
        );
 
-- CREATE TABLE HygieneDetails
--         (
--         DietCode
--         sugarLevels
--         Proteins
--         Carbohydrates
--         QtyOfCitrusIntake
--         EmpID
--         );

--
CREATE TABLE TerroristActivities
        (dateTimes varchar(15),
        Locations varchar(155),
        numberOfPeopleKilled numeric(7,0),
        Clues varchar(155),
        Report varchar(155),
        InspectedBy varchar(155),
        primary key (dateTimes, Locations),
        foreign key (InspectedBy) references AlphaAgents(EmpID)
        );

--
CREATE TABLE Causalities
        (dateTimes varchar(15),
        DeceasedName varchar(155),
        DeceasedHomeAddress varchar(155),
        DeceasedNationality varchar(155),
        Location varchar(155),
        AssetDamageInDollars varchar(155),
        primary key (dateTimes, Location, DeceasedName),
        foreign key (dateTimes, Location) references TerroristActivities (dateTimes, Locations)
        );

-- 
CREATE TABLE Patrolling
        (PatrollingID varchar(155),
        dateTimes varchar(15),
        Location varchar(155),
        VehicleUsed varchar(155),
        purposeOfPatrolling varchar(155),
        DriverName varchar(155),
        officerOnDuty varchar(15),
        primary key (PatrollingID),
        foreign key (officerOnDuty) references AlphaAgents(EmpID)
        );

