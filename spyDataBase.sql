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
        (EmpID varchar(156),
        Names varchar(256),
        Aliases varchar(256),
        Salary numeric(10,0),
        SupervisorName varchar(256),
        PassportNo varchar(256),
        MotherTongue varchar(155),
        knownLanguagesCount numeric(3,0),
        passwords varchar(255),
        primary key (EmpID)
        );
--
CREATE TABLE SkillSet
        (SkillID varchar(156),
        NameOfTheSkill varchar(256),
        RequireWeapons varchar(3),
        DaysToMaster numeric(4,0),
        mustLearn varchar(3),
        primary key (SkillID)
        );

--
CREATE TABLE WeaponsData
        (SerialNo varchar(156),
        NameOfTheWeapon varchar(256),
        SafeToUse varchar(3),
        needAssistanceToOperate varchar(3),
        RequiresExperienceToOperate varchar(3),
        primary key (SerialNo)
        );
--
CREATE TABLE AlphaAgents
        (EmpID varchar(156),
        names varchar(256),
        aliases varchar(256),
        Salary numeric(10,0),
        SupervisorName varchar(256),
        DriversLicence varchar(256),
        Ethnicity varchar(155),
        height numeric(4),
        MotherTongue varchar(155),
        identificationMarks varchar(155),
        PassportNo varchar(155),
        passwords varchar(255),
        -- languageID varchar(155),
        SkillID varchar(155),
        -- OperationId varchar(155),
        weaponID varchar(156),
        primary key (EmpID),
	    foreign key (SkillID) references SkillSet (SkillID),
        foreign key (weaponID) references WeaponsData (SerialNo)
        );

--
CREATE TABLE TechnicalSkills 
        (TechID varchar(156),
        NameOfTheSkill varchar(256),
        RequiredProficiencyLevel numeric(4,0),
        HasCertifications varchar(3),
        DifficultyLevel varchar(155),
        PrerequisiteSkills varchar(256),
        whoSkilledIn varchar(256),
        primary key (TechID),
        foreign Key (whoSkilledIn) references BetaAgents(EmpID)
        );

-- CREATE TABLE Passport

--         (
--         PassportNo varchar(256),
--         Nationality varchar(156),
--         ExpirationDate varchar(156),
--         IssuedDate varchar(156),
--         );

--
-- CREATE TABLE Languages
    
--         (
--         languageID varchar(256),
--         MotherTongue varchar(256),
--         Preference1 varchar(256),
--         Preference2 varchar(256),
--         Preference3 varchar(256),
--         KnowExtraLanguages varchar(256),
--         spokenBy varchar(156),
--         );

--
CREATE TABLE OperationDirector
        (OperationId varchar(256),
        OperationDirectorName varchar(256),
        OperationName varchar(256),
        OperationLocation varchar(256),
        passwords varchar(255),
        primary key (OperationId)
        );
--
CREATE TABLE TerroristsInformation
        (IdentityNumber varchar(156),
        NameOfTerrorists varchar(156),
        aliases varchar(156),
        Height numeric(4),
        color varchar(156),
        ethnicity varchar(156),
        locationsWhereHeWasFound varchar(256),
        InCustody varchar(3),
        InformationSentTo varchar(256),
        ConfimredBy varchar(156),
        SuspectedBy varchar(156),
        primary key (IdentityNumber),
	foreign key (SuspectedBy) references AlphaAgents(EmpID),
        foreign key (ConfimredBy) references BetaAgents(EmpID),
        foreign key (InformationSentTo) references OperationDirector(OperationId)
        );
--   
CREATE TABLE Budget
        (EventName varchar(256),
        dateTimes varchar(156),
        MoneySpentOnEvent numeric(7,0),
        QuoteSubmittedBy varchar(156),
        AuthorisedBy varchar(156),
        primary key (EventName,dateTimes),
        foreign key (QuoteSubmittedBy) references AlphaAgents(EmpID),
        foreign key (AuthorisedBy) references OperationDirector(OperationId)
        );
--
CREATE TABLE Informers
        (IDNumber varchar(256),
        Name varchar(256),
        aliases varchar(256),
        occupation varchar(256),
        AccuracyLevel numeric(2,0),
        recruitedBy varchar(156),
        primary key (IDNumber),
        foreign key (recruitedBy) references BetaAgents(EmpID)
        );
--
CREATE TABLE ElectronicDevices
        (SerialNumber varchar(256),
        NameOfDevise varchar(256),
        model varchar(256),
        Price numeric(6,0),
        requiresExpInHandling varchar(3),
        requiresMaintenance varchar(3),
        UsedBy varchar(156),
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
        (dateTimes varchar(156),
        Locations varchar(256),
        numberOfPeopleKilled numeric(7,0),
        Report varchar(256),
        InspectedBy varchar(256),
        primary key (dateTimes, Locations),
        foreign key (InspectedBy) references AlphaAgents(EmpID)
        );
--
CREATE TABLE Causalities
        (dateTimes varchar(156),
        incidentLocation varchar(256),
        DeceasedName varchar(256),
        DeceasedHomeAddress varchar(256),
        DeceasedNationality varchar(256),
        AssetDamageInDollars varchar(256),
        primary key (dateTimes, incidentLocation, DeceasedName),
        foreign key (dateTimes, incidentLocation) references TerroristActivities (dateTimes, Locations)
        );

-- 
CREATE TABLE Patrolling
        (PatrollingID varchar(256),
        dateTimes varchar(256),
        Location varchar(256),
        VehicleUsed varchar(256),
        purposeOfPatrolling varchar(256),
        DriverName varchar(256),
        officerOnDuty varchar(256),
        primary key (PatrollingID),
        foreign key (officerOnDuty) references AlphaAgents(EmpID)
        );

