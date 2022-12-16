import random 
import names
import datetime

languages = ["Ossetic", "Ukrainian", "Buryat", "Kalmyk", "Chechen", "Ingush", "Abaza", "Adyghe", "Russian"]
supervisor = ['Ryan Hill', 'Malcolm Reels', 'Lori Rentfro', 'Nicole Kennedy', 'James Fitzgerald', 'Melvin Haynes', 'David Perrette', 'Dave White', 
'Percy Ryan', 'Olympia Taylor', 'Jeff Esterly', 'Fred Kurth', 'Richard Rivera', 'Chad Thomas', 'Tanya Suddoth']

languages = ["Ossetic", "Ukrainian", "Buryat", "Kalmyk", "Chechen", "Ingush", "Abaza", "Adyghe", "Russian"]

skillsAlpha = ["Investigative" ,"Keen observation","Communication" ,"Research" ,"Physical endurance ","Decision-making ","Fighting","acting","shooting","hill climbing","swimming","jumping","running"]

weaponslist = ["AK47","handmissiles","snipperGuns","shortGun","drone","smokeBomb","frenchRiffle","Diamondback","Big Kill","AZ400","wirlessShort","AmbassadorGun"]

ethnicitylist = ['Asian','Ukranian','polish','dutch','georgian','uzebican','khazakhan','russian']

identificationMarks = ["Head","chin","cheeck","ear","forehead","Nose","lips",'chest',"toes","arms"]

BetaSkillSAgnet = ['Tortoise CVS','Social Media Blogging','Pharmacy','Equity Derivatives','Immunohistochemistry','Operating Room','Proposal Writing','CGI','DV','Jetty','IATA','IFR','Qooxdoo','Ocean Transportation','VSEO','VxWorks','Kinect','VXI','MMIS','Human Computer Interaction','Global Mobility','AOI','Gyrotonic','Web TV','Public Policy','Skin','Trading','VRU','Glass','Non-fiction','Zenworks','Win CVS','Guardianship','Americans with Disabilities Act','Account Reconciliation','JDF','HMIs','Omega','Interactive TV','Kitchen Remodeling','Oracle OLAP','UK Law','Music History','OEM contracts','NCBI','Microsoft Project','xSeries','SMSTS','Internet Yellow Pages','Singing','HF','Turbines','Public Policy','EBPP','WFC','International Trade','Drama','Online Lead Generation','Final Cut Pro','Peer Tutoring','Bit.ly','Program Management','Dtrace','RMP','Running','SEO','NIR Spectroscopy','Italian','FSC certified','PMIS','Digital Electronics','EMS','HttpUnit','Btrieve','EBSCO','Digital Imaging','ERDAS Imagine','Close Protection','jQuery','NICU','Registered Patent Attorney','Mental Health','Low Voltage','Hyperion Reports','Sales Presentations','Advertising','HPLC','Gyrotonic','ENOVIA LCA','HLA','Organizational Development','Freight Forwarding','Sh','MTT','MV','Yeast two-hybrid','Long-term Care','VAS','Ice Hockey','Rhinoplasty']
# print(BetaSkillSAgnet)

missions = ['ceaseFire','shelling','crossTrekking','HighTowering','feetMining','MagnetPlating','massShooting',"peakCutting",'Watershooting']

dateTimes = datetime.datetime.now() - datetime.timedelta(days=10*2)
dateexe= dateTimes.strftime("%m-%d-%Y %H:%M:%S")
# print(type(dateexe))

famousOcuupation = ['Painter','Mechanic','Magician','Lifeguard','Clown','Housekeeper','Gardener','Geisha','Footballer','Forestranger','Builder','Foreman','Farmer','Fireman']

devices = ['HackRF One','Ubertooth One','Comidox Zigbee CC2531 Sniffer','Crazyradio PA 2.0','Proxmark3 Kit','Wi-Fi Pineapple','Wi-Fi Deauther','DSTIKE WIFI Duck','Alfa AWUS036ACH USB Wi-Fi Adapter','Raspberry Pi']

locationsLat = ['30.1755285','-26.800415','59.1930889','49.4679131','52.0872281','50.994689','-7.0148687','-8.9445','46.8117208','5.4328871','17.39713','20.044412','52.0997957','-7.898852','-13.9535913','49.0996492','54.2569032','35.84026','16.6969748','34.8838824','6.9463216','27.4456115','52.2513095','49.854154','55.5747494','22.358169','13.2805504','24.3520171','32.6963741','18.6967739','42.7003378','15.113472','40.417358','8.3048218','32.790614','38.058088','35.026516','0.881124','60.2025952','28.524376','30.173912','48.9648921','32.7104016','11.4702151','62.6243044','10.1775604','-12.23146','38.624235','41.3275459','53.7217952']

locationsPhy = ['Bakhmut','Berdyansk','Bila Tserkva','Bilhorod-Dnistrovskyi','Bolhrad','Boryspil','Brody','Brovary','Bryanka','Podolskiy','Kamianske','Kerch','Kharkov Region Capital','Khartsyzsk','Kherson Region Capital','Khmelnitsky Region Capital','Kiev Region Capital','Kolomiya','Konotop','Konstantinovka','Korosten','Kovel','Kramatorsk','Krasnodon','Kremenchug','Kremenets','Krivoy Rog','Kropyvnytskyi Region Capital']

vehicUse=['police cruiser',' police interceptor',' patrol car',' area car',' cop car',' prowl car',' squad car',' radio car',' radio motor patrol']
# print(vehicUse)

betaSkills = ['Tortoise CVS','Social Media Blogging','Pharmacy','Equity Derivatives','Immunohistochemistry','Operating Room','Proposal Writing','CGI','DV','Jetty','IATA','IFR','Qooxdoo','Ocean Transportation','VSEO','VxWorks','Kinect','VXI','MMIS','Human Computer Interaction','Global Mobility','AOI','Gyrotonic','Web TV','Public Policy','Skin','Trading','VRU','Glass','Non-fiction','Zenworks','Win CVS','Guardianship','Americans with Disabilities Act','Account Reconciliation','JDF','HMIs','Omega','Interactive TV','Kitchen Remodeling','Oracle OLAP','UK Law','Music History','OEM contracts','NCBI','Microsoft Project','xSeries','SMSTS','Internet Yellow Pages','Singing','HF','Turbines','Public Policy','EBPP','WFC','International Trade','Drama','Online Lead Generation','Final Cut Pro','Peer Tutoring','Bit.ly','Program Management','Dtrace','RMP','Running','SEO','NIR Spectroscopy','Italian','FSC certified','PMIS','Digital Electronics','EMS','HttpUnit','Btrieve','EBSCO','Digital Imaging','ERDAS Imagine','Close Protection','jQuery','NICU','Registered Patent Attorney','Mental Health','Low Voltage','Hyperion Reports','Sales Presentations','Advertising','HPLC','Gyrotonic','ENOVIA LCA','HLA','Organizational Development','Freight Forwarding','Sh','MTT','MV','Yeast two-hybrid','Long-term Care','VAS','Ice Hockey','Rhinoplasty']

for i in range(40):

    EmpID = "BQ"+str(random.randint(1400000, 1500000))
    Names =  names.get_full_name()
    Aliases = names.get_first_name()
    Salary = str(random.randint(100000, 150000))
    SupervisorName = random.choice(supervisor)
    PassportNo = 'UPI'+str(random.randint(1400000, 1500000))
    MotherTongue = random.choice(languages)
    knownLanguagesCount = str(random.randint(1, 10))
    passwords = ''

    betaquery = "INSERT INTO BetaAgents values ("+"'"+EmpID+"'"+","+"'"+Names+"'"+','+"'"+Aliases+"'"+','+Salary+','+"'"+SupervisorName+"'"+','+"'"+PassportNo+"'"+','+"'"+MotherTongue+"'"+","+knownLanguagesCount+","+"'"+'dac3169ae19731ae1a26d9142496b25e0f98b01bb61a91cef59969566f44538a'+"'"+');'

    print(betaquery)

    SkillID = "SK"+str(random.randint(1400000, 1500000))
    NameOfTheSkill = random.choice(skillsAlpha)
    RequireWeapons = random.choice(["Yes","No"])
    DaysToMaster = str(random.randint(90, 1000))
    mustLearn = random.choice(["Yes","No"])


    skillquery = "INSERT INTO SkillSet values ("+"'"+SkillID+"'"+","+"'"+NameOfTheSkill+"'"+','+"'"+RequireWeapons+"'"+','+DaysToMaster+','+"'"+mustLearn+"'"+");"

    print(skillquery)

    SerialNo = "WP"+str(random.randint(1400000, 1500000))
    NameOfTheWeapon = random.choice(weaponslist)
    SafeToUse = random.choice(["Yes","No"])
    needAssistanceToOperate = random.choice(["Yes","No"])
    RequiresExperienceToOperate = random.choice(["Yes","No"])

    weaponQuery = "INSERT INTO WeaponsData values ("+"'"+SerialNo+"'"+","+"'"+NameOfTheWeapon+"'"+','+"'"+SafeToUse+"'"+','+"'"+needAssistanceToOperate+"'"+','+"'"+RequiresExperienceToOperate+"'"+");"

    print(weaponQuery)

    EmpIDAgent = "AE"+str(random.randint(1400000, 1500000))
    Names =  names.get_full_name()
    Aliases = names.get_first_name()
    Salary = str(random.randint(100000, 150000))
    SupervisorName = names.get_first_name()
    DriversLicence = "NPI"+str(random.randint(10000000, 15000000))
    Ethnicity = random.choice(ethnicitylist)
    height = str(random.randint(170, 210))
    MotherTongue = random.choice(languages)
    identificationMarks = random.choice(identificationMarks)
    PassportNo = "USIS"+str(random.randint(1400000, 1500000))
    passwords = "dac3169ae19731ae1a26d9142496b25e0f98b01bb61a91cef59969566f44538a"
    SkillIDagent = SkillID
    weaponIDagent = SerialNo

    agentQuery = "INSERT INTO AlphaAgents values ("+"'"+EmpIDAgent+"'"+","+"'"+Names+"'"+','+"'"+Aliases+"'"+','+ \
    Salary+','+"'"+SupervisorName+"'"+','+"'"+DriversLicence+"'"+","+"'"+Ethnicity+"'"+','+ \
    "'"+height+"'"+','+"'"+MotherTongue+"'"+','+"'"+identificationMarks+"'"+','+"'"+PassportNo+"'"+","+"'"+passwords+"'"+','+"'"+SkillIDagent+"'"+","+"'"+weaponIDagent+"'"+");"

    print(agentQuery)

    TechID = "TC"+str(random.randint(1400000, 1500000))
    NameOfTheSkill = random.choice(BetaSkillSAgnet)
    RequiredProficiencyLevel =str(random.randint(1,10))
    HasCertifications = random.choice(["Yes","No"])
    DifficultyLevel = random.choice(['tooDifficult','hard','medium','easy','too Easy'])
    PrerequisiteSkills = random.choice(BetaSkillSAgnet)
    whoSkilledIn = EmpID

    techSkillsQuery = "INSERT INTO TechnicalSkills values ("+"'"+TechID+"'"+","+"'"+NameOfTheSkill+"'"+','+RequiredProficiencyLevel+',' \
    +"'"+HasCertifications+"'"+','+"'"+DifficultyLevel+"'"+","+"'"+PrerequisiteSkills+"'"+','+ \
    "'"+whoSkilledIn+"'"+");"

    print(techSkillsQuery)


    IdentityNumber = "TR"+str(random.randint(1400000, 1500000))
    NameOfTerrorists = names.get_full_name()
    aliases = names.get_first_name()
    Height = str(random.randint(170, 220))
    color = random.choice(['white','black','redWhite','brown','whiteBrown','voiletBrown'])
    ethnicity = random.choice(ethnicitylist)
    locationsWhereHeWasFound = random.choice(locationsLat)
    InCustody = random.choice(["Yes","No"])
    InformationSentTo = "CX1410110"
    ConfimredBy = EmpID
    SuspectedBy = EmpIDAgent

    terinfoQuery = "INSERT INTO TerroristsInformation values ("+"'"+IdentityNumber+"'"+","+"'"+NameOfTerrorists+"'"+','+"'"+aliases+"'"+',' \
    +"'"+Height+"'"+','+"'"+color+"'"+','+"'"+ethnicity+"'"+','+"'"+locationsWhereHeWasFound+"'"+","+"'"+InCustody+"'"+','+"'"+InformationSentTo+"'"+','+"'"+ConfimredBy+"'"+','+"'"+SuspectedBy+"'"+");"

    print(terinfoQuery)

    # CREATE TABLE Budget
    dates = datetime.datetime.now() - datetime.timedelta(days=10*i)
    dateBudgest= dates.strftime("%m-%d-%Y %H:%M:%S")

    EventName = random.choice(missions)
    dateTimes = dateBudgest
    MoneySpentOnEvent = str(random.randint(200, 1000))
    QuoteSubmittedBy = EmpIDAgent
    AuthorisedBy = 'CX1410110'

    BudgetInfo = "INSERT INTO Budget values ("+"'"+EventName+"'"+","+"'"+dateTimes+"'"+','+"'"+MoneySpentOnEvent+"'"+',' \
    +"'"+QuoteSubmittedBy+"'"+','+"'"+AuthorisedBy+"'"+");"
        
    print(BudgetInfo)

    # CREATE TABLE Informers
    IDNumber = "IF"+str(random.randint(1400000, 1500000))
    Name = names.get_full_name()
    aliases = names.get_first_name()
    occupation = random.choice(famousOcuupation)
    AccuracyLevel = str(random.randint(1,10))
    recruitedBy = EmpID

    informerInfo =  "INSERT INTO Informers values ("+"'"+IDNumber+"'"+","+"'"+Name+"'"+','+"'"+aliases+"'"+',' \
    +"'"+occupation+"'"+','+"'"+AccuracyLevel+"'"+','+"'"+recruitedBy+"'"+");"

    print(informerInfo)

    # CREATE TABLE ElectronicDevices
    SerialNumber = "XYZ"+str(random.randint(1400000, 1500000))
    NameOfDevise = random.choice(devices)
    model = "prtn"+ str(random.randint(1940,2022))
    Price = str(random.randint(500,50000))
    requiresExpInHandling = random.choice(["Yes","No"])
    requiresMaintenance = random.choice(["Yes","No"])
    UsedBy = EmpID

    techSkillsQuery = "INSERT INTO ElectronicDevices values ("+"'"+SerialNumber+"'"+","+"'"+NameOfDevise+"'"+','+"'"+model+"'"+',' \
    +"'"+Price+"'"+','+"'"+requiresExpInHandling+"'"+","+"'"+requiresMaintenance+"'"+','+ \
    "'"+UsedBy+"'"+");"

    print(techSkillsQuery)
    

    # CREATE TABLE TerroristActivities
    dateTimes = datetime.datetime.now() - datetime.timedelta(days=80*i)
    dateexet= dateTimes.strftime("%m-%d-%Y %H:%M:%S")
    dateTimes = dateexet
    Locations = random.choice(locationsLat)
    numberOfPeopleKilled = str(random.randint(2,80))
    Report = random.choice(['normal','severe','critical','notraces'])
    InspectedBy = EmpIDAgent

    terInfoQuery = "INSERT INTO TerroristActivities values ("+"'"+dateTimes+"'"+","+"'"+Locations+"'"+','+"'"+numberOfPeopleKilled+"'"+',' \
    +"'"+Report+"'"+','+"'"+InspectedBy+"'"+");"
    
    print(terInfoQuery)
        

    # CREATE TABLE Causalities
    dateTimes = dateexet
    incidentLocation = Locations
    DeceasedName = names.get_full_name()
    DeceasedHomeAddress = random.choice(locationsPhy)
    DeceasedNationality = random.choice(languages)
    AssetDamageInDollars = str(random.randint(20000,80000))


    casualitiesQuery = "INSERT INTO Causalities values ("+"'"+dateTimes+"'"+","+"'"+incidentLocation+"'"+','+"'"+DeceasedName+"'"+',' \
    +"'"+DeceasedHomeAddress+"'"+','+"'"+DeceasedNationality+"'"+","+"'"+AssetDamageInDollars+"'"+");"


    print(casualitiesQuery)

    # CREATE TABLE Patrolling
    patdateTimes = datetime.datetime.now() - datetime.timedelta(days=1*i)
    patdateexe= patdateTimes.strftime("%m-%d-%Y %H:%M:%S")

    PatrollingID = "PTI"+str(random.randint(1400000, 1500000))
    dateTimes = patdateexe
    Location = random.choice(locationsPhy)
    VehicleUsed = random.choice(vehicUse)
    purposeOfPatrolling = random.choice(['casual','onComplaint','regular','emergency','SideLining','protocal'])
    DriverName = names.get_full_name()
    officerOnDuty = EmpIDAgent

    patrollingQuery = "INSERT INTO Patrolling values ("+"'"+PatrollingID+"'"+","+"'"+dateTimes+"'"+','+"'"+Location+"'"+',' \
    +"'"+VehicleUsed+"'"+','+"'"+purposeOfPatrolling+"'"+","+"'"+DriverName+"'"+','+ \
    "'"+officerOnDuty+"'"+");"

    print(patrollingQuery)


