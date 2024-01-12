DROP DATABASE IF EXISTS odysseyonwheelz;
CREATE DATABASE odysseyonwheelz;

USE odysseyonwheelz;
CREATE TABLE user(
    userId VARCHAR(20) PRIMARY KEY NOT NULL ,
    userName VARCHAR(50) NOT NULL ,
    userNIC VARCHAR(15) NOT NULL ,
    userMobile INT(20) NOT NULL,
    userEmail VARCHAR(200) NOT NULL,
    userPassword VARCHAR(200) NOT NULL
);

CREATE TABLE employee(
    employeeId VARCHAR(20) PRIMARY KEY KEY NOT NULL ,
    employeeName VARCHAR(50) NOT NULL ,
    empEmail VARCHAR(200) NOT NULL,
    empNIC VARCHAR(20),
    empPosition VARCHAR(20) NOT NULL,
    empAddress VARCHAR(200) NOT NULL,
    empContact VARCHAR(15) NOT NULL
);
CREATE TABLE employee_Attendance(
    attendanceId VARCHAR(20) PRIMARY KEY NOT NULL ,
    attendanceDate DATE,
    employeeId VARCHAR(10),
    CONSTRAINT FOREIGN KEY (employeeId) REFERENCES employee(employeeId) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE employee_salary(
    salaryId VARCHAR(20) PRIMARY KEY NOT NULL ,
    salaryAmount DECIMAL(10,2) DEFAULT NULL,
    employeeId VARCHAR(10),
    CONSTRAINT FOREIGN KEY (employeeId) references employee(employeeId) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE customer(
    customerNIC VARCHAR(30) PRIMARY KEY NOT NULL ,
    customerName VARCHAR(100) DEFAULT NULL,
    customerCountry VARCHAR(30) ,
    customerEmail VARCHAR(200) DEFAULT NULL
);
CREATE TABLE customer_contact (
    contactId VARCHAR(10) PRIMARY KEY ,
    customerNIC VARCHAR(20),
    customerContact VARCHAR(20),
    FOREIGN KEY (customerNIC) REFERENCES customer(customerNIC) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE rent(
    rentId VARCHAR(20) PRIMARY KEY NOT NULL ,
    customerNIC VARCHAR(20),
    pickup_location VARCHAR(200),
    dropOff_location VARCHAR(200),
    rent_starting DATE,
    rent_ending DATE,
    order_date DATE,
    CONSTRAINT FOREIGN KEY (customerNIC) REFERENCES customer(customerNIC) ON UPDATE CASCADE ,
    INDEX (rent_starting),
    INDEX (rent_ending),
    INDEX (order_date)
);

CREATE TABLE vehicle (
    vehicle_id VARCHAR(10) PRIMARY KEY,
    vehicle_type VARCHAR(50),
    vehicle_name VARCHAR(100),
    per_day_80km DOUBLE,
    excess_mileage DOUBLE,
    status INT(2)
);
CREATE TABLE rent_detail (
    primaryID INT AUTO_INCREMENT PRIMARY KEY ,
    rent_id VARCHAR(10) NOT NULL ,
    vehicle_id VARCHAR(10) NOT NULL ,
    rent_fee DOUBLE NOT NULL,
    excess_Mileage_cost DOUBLE DEFAULT NULL,
    start_date DATE,
    end_date DATE,
    order_date DATE,

    CONSTRAINT FOREIGN KEY (rent_id) REFERENCES rent(rentId) ,
    CONSTRAINT FOREIGN KEY (vehicle_id) REFERENCES vehicle(vehicle_id) ON DELETE CASCADE ON UPDATE CASCADE ,
    CONSTRAINT FOREIGN KEY (start_date) REFERENCES rent(rent_starting) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FOREIGN KEY (end_date) REFERENCES rent(rent_ending) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FOREIGN KEY (order_date) REFERENCES rent(order_date) ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE language(
    wordSetNb int AUTO_INCREMENT PRIMARY KEY ,
    russian VARCHAR(1000) DEFAULT NULL,
    sinhala VARCHAR(1000) DEFAULT NULL,
    german VARCHAR(1000) DEFAULT NULL,
    hindi VARCHAR(1000) DEFAULT NULL,
    french VARCHAR(1000) DEFAULT NULL,
    english VARCHAR(1000) DEFAULT NULL,
    tamil VARCHAR(1000) DEFAULT NULL,
    chinese VARCHAR(1000) DEFAULT NULL,
    japan VARCHAR(1000) DEFAULT NULL

);
CREATE TABLE locations(nb int primary key auto_increment,yard_name VARCHAR(100),status VARCHAR(20));
CREATE TABLE countries(country_name VARCHAR(100));

INSERT INTO user (userId, userName, userNIC, userMobile, userEmail,userPassword) VALUES
    ('U001','PENGUIN','960036789v','0764532478','sdweerapperuma@gmail.com','123'),
    ('U002','RIDDLER','960089769v','0767834971','RIDDLER34gotham@gmail.com','456');

INSERT INTO employee (employeeId, employeeName, empEmail, empNIC, empPosition, empAddress, empContact)
VALUES
    ('E004', 'John Doe', 'johndoe@gmail.com', '923456789v', 'Technician', 'colombo', '0712345678'),
    ('E005', 'Jane Smith', 'janesmith@gmail.com', '823456789v', 'Engineer', 'kandy', '0723456789'),
    ('E006', 'Alice Johnson', 'alicejohnson@gmail.com', '713456789v', 'Supervisor', 'negombo', '0734567890'),
    ('E007', 'Bob Williams', 'bobwilliams@gmail.com', '603456789v', 'Driver', 'jaffna', '0745678901'),
    ('E008', 'Eva Davis', 'evadavis@gmail.com', '503456789v', 'Security', 'anuradhapura', '0756789012'),
    ('E009', 'Charlie Brown', 'charliebrown@gmail.com', '403456789v', 'Clerk', 'batticaloa', '0767890123'),
    ('E010', 'Lucy Johnson', 'lucyjohnson@gmail.com', '303456789v', 'Accountant', 'trincomalee', '0778901234'),
    ('E011', 'Michael Smith', 'michaelsmith@gmail.com', '203456789v', 'Cleaner', 'ratnapura', '0789012345'),
    ('E012', 'Sophia Davis', 'sophiadavis@gmail.com', '103456789v', 'Assistant', 'kurunegala', '0790123456'),
    ('E013', 'David Wilson', 'davidwilson@gmail.com', '903456789v', 'Coordinator', 'gampaha', '0711223344'),
    ('E014', 'Olivia Anderson', 'oliviaanderson@gmail.com', '803456789v', 'Manager', 'nuwaraeliya', '0712345678'),
    ('E015', 'Henry Taylor', 'henrytaylor@gmail.com', '703456789v', 'Technician', 'colombo', '0723456789'),
    ('E016', 'Grace Miller', 'gracemiller@gmail.com', '603456789v', 'Engineer', 'kandy', '0734567890'),
    ('E017', 'Samuel Brown', 'samuelbrown@gmail.com', '503456789v', 'Supervisor', 'negombo', '0745678901'),
    ('E018', 'Isabella Wilson', 'isabellawilson@gmail.com', '403456789v', 'Driver', 'jaffna', '0756789012');

INSERT INTO customer (customerNIC, customerName, customerCountry, customerEmail)
VALUES
    ('AB123456', 'John Doe', 'USA', 'john.doe@example.com'),
    ('CD789012', 'Jane Smith', 'Canada', 'jane.smith@example.com'),
    ('EF345678', 'Bob Johnson', 'Australia', 'bob.johnson@example.com'),
    ('GH901234', 'Emily Davis', 'Germany', 'emily.davis@example.com'),
    ('IJ567890', 'Michael Wilson', 'France', 'michael.wilson@example.com'),
    ('KL123456', 'Amanda Brown', 'Spain', 'amanda.brown@example.com'),
    ('MN789012', 'David Lee', 'Italy', 'david.lee@example.com'),
    ('OP345678', 'Sophia Garcia', 'Brazil', 'sophia.garcia@example.com'),
    ('QR901234', 'James Kim', 'South Korea', 'james.kim@example.com'),
    ('ST567890', 'Linda Wang', 'China', 'linda.wang@example.com'),
    ('UV123456', 'Daniel Martinez', 'Mexico', 'daniel.martinez@example.com'),
    ('WX789012', 'Elena Rodriguez', 'Argentina', 'elena.rodriguez@example.com'),
    ('YZ345678', 'Mohammed Ali', 'Egypt', 'mohammed.ali@example.com'),
    ('AA901234', 'Mia Johnson', 'Sweden', 'mia.johnson@example.com'),
    ('BB567890', 'Oliver Nielsen', 'Denmark', 'oliver.nielsen@example.com'),
    ('CC123456', 'Isabella Smith', 'Norway', 'isabella.smith@example.com'),
    ('DD789012', 'Benjamin Smith', 'Finland', 'benjamin.jensen@example.com'),
    ('EE345678', 'Emma Davis Smith', 'Ireland', 'emma.davis@example.com'),
    ('FF901234', 'William Wong', 'Singapore', 'william.wong@example.com'),
    ('GG567890', 'Grace Kim', 'Japan', 'grace.kim@example.com'),
    ('HH123456', 'Ryan Chen', 'Taiwan', 'ryan.chen@example.com'),
    ('II789012', 'Zoe Tan', 'Malaysia', 'zoe.tan@example.com'),
    ('JJ345678', 'Lucas Lim', 'Philippines', 'lucas.lim@example.com'),
    ('KK901234', 'Ava Nguyen', 'Vietnam', 'ava.nguyen@example.com'),
    ('LL567890', 'Ethan Park', 'Thailand', 'ethan.park@example.com'),
    ('MM123456', 'Nina Kumar', 'India', 'nina.kumar@example.com'),
    ('NN789012', 'Oscar Patel', 'South Africa', 'oscar.patel@example.com'),
    ('OO345678', 'Victoria Mbeki', 'Nigeria', 'victoria.mbkei@example.com'),
    ('PP901234', 'Samuel Kofi', 'Ghana', 'samuel.kofi@example.com'),
    ('QQ567890', 'Sophie Abimbola', 'Kenya', 'sophie.abimbola@example.com');

INSERT INTO vehicle(vehicle_id, vehicle_type,vehicle_name, per_day_80km,excess_mileage,status) VALUES
    ('QA-5678', 'normal','Suzuki Alto',12000,120,1 ),
    ('AAI-5678', 'normal','Suzuki Celerio', 13500,135,1),
    ('BAY-3489', 'normal','Perodua Axia',13500,135,1),
    ('ABC-1234', 'normal','Perodua Bezza Prime Sedan(2017)',13500,135,1),
    ('XYZ-5678', 'normal','Toyota Vitz',13500,135,1),
    ('DEF-9876', 'luxury','Mercedes Benz S-Class AMG (Long Wheel Base)', 65000,650,1),
    ('GHI-5432', 'luxury','BMW 320-White', 29500,295,1),
    ('JKL-9876', 'luxury','CHRYSLER 300 C - White (Rolls Royce Facelift)', 34500,345,1),
    ('MNO-1234', 'luxury','Mercedes Benz C 350 - 2017', 34500,345,1),
    ('PQR-5678', 'luxury','Jaguar XF 3.0 V6', 39500,395,1),
    ('STU-9876', 'luxury','Toyota Camry', 24500,245,1),
    ('VWX-1234', 'MVP','Toyota Alphard 6 Passenger',34500,345,1),
    ('YZA-5678', 'MVP','Mercedes Vito Luxury 5 + 2 Passenger',29500,295,1),
    ('BCD-9876', 'luxury van', 'Toyota Regius 9 Seater - Dual A/C New Petrol',17500,175,1),
    ('EFG-1234', 'luxury van', 'Toyota Regius 9 Seater - Dual A/c',16500,165,1),
    ('HIJ-5678', 'luxury van', 'Toyota Hiace Commuter 09 Seater - Line A/c',17500,175,1),
    ('KLM-9876', 'luxury van', 'Toyota Hiace Commuter 15 Seater - Line A/c',17500,175,1),
    ('NOP-1234', 'luxury van', 'Toyota Grand Cabin 13 Seater - Line A/c',18500,185,1),
    ('QRS-5678', 'SUV','Toyota Land Cruiser Prado TRJ 150', 34500,345,1),
    ('TUV-9876', 'SUV','Mitsubishi Montero Sport 2018', 29500,295,1),
    ('WXY-1234', 'SUV','Nissan X Trail (diesel)', 26000,265,1),
    ('ZAB-5678', 'SUV','Toyota Rush 2018', 26500,265,1),
    ('CDE-9876', 'SUV','Suzuki Vitara', 22500,225,1),
    ('FGH-1234', 'SUV','Toyata Hilux 4wd Double Cab', 22500,225,1),
    ('IJK-5678', 'SUV','Terios 4wd', 22500,225,1);

INSERT INTO locations(yard_name,status) VALUES
    ('Arugam Bay town ','Available'),
    ('Bandaranaike International Airport (BIA) - Katunayake, colombo','Available'),
    ('Colombo - Suburbs - Colombo & Greater Colombo Area, Colombo','Available'),
    ('Dambulla / Sigiriya town limits - Dambulla / Sigiriya town limits','Available'),
    ('Dikwella / Tangalle town limits - Dikwella / Tangalle town limits','Available'),
    ('Ella - Ella, Ella, Uva, Sri Lanka','Available'),
    ('Galle Unawatuna City Limits - Galle Unawatuna City Limits (Any)','Available'),
    ('Habarana town limits - Habarana town limits (Any), Habarana','Available'),
    ('Jaffna Town Limits - Jaffna Town Limits (Any), Jaffna, Northern','Unavailable'),
    ('Kalpitiya Tourism zone - Kalpitiya Tourism zone (Any), Kalpitiya','Unavailable'),
    ('Kandy City limits - Kandy City limits (Any), Kandy, Central, Sri Lanka','Available'),
    ('Main Office - Battaramulla - 50,Ramya Mawatha, sri subuthipura','Unavailable'),
    ('Mattala MRI International Airport - Mattala / Hambantota','Unavailable'),
    ('Negambo City Hotels - Negambo City Hotels (Any), Negambo','Available'),
    ('Nilaveli / Trincomallee town limits - Nilaveli / Trincomallee town limits','Available'),
    ('Nuwara Eliya - Nuwara Eliya, Nuwara Eliya, Central, Sri Lanka','Available'),
    ('Polonnaruwa town limits - Polonnaruwa town limits (Any), Polonnaruwa','Available');

INSERT INTO countries (country_name) VALUES
    ('Afghanistan'), ('Albania'), ('Algeria'), ('Andorra'), ('Angola'), ('Antigua and Barbuda'),
    ('Argentina'), ('Armenia'), ('Australia'), ('Austria'), ('Azerbaijan'), ('Bahamas'), ('Bahrain'),
    ('Bangladesh'), ('Barbados'), ('Belarus'), ('Belgium'), ('Belize'), ('Benin'), ('Bhutan'), ('Bolivia'),
    ('Bosnia and Herzegovina'), ('Botswana'), ('Brazil'), ('Brunei'), ('Bulgaria'), ('Burkina Faso'),
    ('Burundi'), ('Cabo Verde'), ('Cambodia'), ('Cameroon'), ('Canada'), ('Central African Republic'),
    ('Chad'), ('Chile'), ('China'), ('Colombia'), ('Comoros'), ('Congo'), ('Costa Rica'), ('Croatia'),
    ('Cuba'), ('Cyprus'), ('Czech Republic'), ('Denmark'), ('Djibouti'), ('Dominica'), ('Dominican Republic'),
    ('East Timor (Timor-Leste)'), ('Ecuador'), ('Egypt'), ('El Salvador'), ('Equatorial Guinea'),
    ('Eritrea'), ('Estonia'), ('Eswatini'), ('Ethiopia'), ('Fiji'), ('Finland'), ('France'), ('Gabon'),
    ('Gambia'), ('Georgia'), ('Germany'), ('Ghana'), ('Greece'), ('Grenada'), ('Guatemala'), ('Guinea'),
    ('Guinea-Bissau'), ('Guyana'), ('Haiti'), ('Honduras'), ('Hungary'), ('Iceland'), ('India'), ('Indonesia'),
    ('Iran'), ('Iraq'), ('Ireland'), ('Israel'), ('Italy'), ('Ivory Coast'), ('Jamaica'), ('Japan'), ('Jordan'),
    ('Kazakhstan'), ('Kenya'), ('Kiribati'), ('Korea, North'), ('Korea, South'), ('Kosovo'), ('Kuwait'),
    ('Kyrgyzstan'), ('Laos'), ('Latvia'), ('Lebanon'), ('Lesotho'), ('Liberia'), ('Libya'), ('Liechtenstein'),
    ('Lithuania'), ('Luxembourg'), ('Madagascar'), ('Malawi'), ('Malaysia'), ('Maldives'), ('Mali'), ('Malta'),
    ('Marshall Islands'), ('Mauritania'), ('Mauritius'), ('Mexico'), ('Micronesia'), ('Moldova'), ('Monaco'),
    ('Mongolia'), ('Montenegro'), ('Morocco'), ('Mozambique'), ('Myanmar (Burma)'), ('Namibia'), ('Nauru'),
    ('Nepal'), ('Netherlands'), ('New Zealand'), ('Nicaragua'), ('Niger'), ('Nigeria'), ('North Macedonia (formerly Macedonia)'),
    ('Norway'), ('Oman'), ('Pakistan'), ('Palau'), ('Panama'), ('Papua New Guinea'), ('Paraguay'), ('Peru'), ('Philippines'),
    ('Poland'), ('Portugal'), ('Qatar'), ('Romania'), ('Russia'), ('Rwanda'), ('Saint Kitts and Nevis'), ('Saint Lucia'),
    ('Saint Vincent and the Grenadines'), ('Samoa'), ('San Marino'), ('Sao Tome and Principe'), ('Saudi Arabia'),
    ('Senegal'), ('Serbia'), ('Seychelles'), ('Sierra Leone'), ('Singapore'), ('Slovakia'), ('Slovenia'), ('Solomon Islands'),
    ('Somalia'), ('South Africa'), ('South Sudan'), ('Spain'), ('Sri Lanka'), ('Sudan'), ('Suriname'), ('Sweden'), ('Switzerland'),
    ('Syria'), ('Taiwan'), ('Tajikistan'), ('Tanzania'), ('Thailand'), ('Togo'), ('Tonga'), ('Trinidad and Tobago'), ('Tunisia'),
    ('Turkey'), ('Turkmenistan'), ('Tuvalu'), ('Uganda'), ('Ukraine'), ('United Arab Emirates'), ('United Kingdom'),
    ('United States of America'), ('Uruguay'), ('Uzbekistan'), ('Vanuatu'), ('Vatican City (Holy See)'), ('Venezuela'), ('Vietnam'),
    ('Yemen'), ('Zambia'), ('Zimbabwe');


INSERT INTO language(wordSetNb,russian,sinhala,german,hindi,french,english,tamil,chinese,japan) VALUES
    (1,'номер паспорта','ජා තික හැඳුනුම්පත් අංකය','Nummer des Reisepasses','पासपोर्ट नंबर','numéro de passeport','ID / Passport','கடவுச்சீட்டு எண்','护照号','パスポート番号'),
    (2,'Оформить аренду','කුලියට ගන්න','Miete machen','किराया लगाओ','Faire un loyer','Make a Rent','கடவுச்சீட்டு எண்','护照号','パスポート番号'),
    (3,'Начальный день','ආරම්භක දිනය','Starttag','शुरुआती दिन','Jour de départ','Starting day','தொடக்க நாள்','开始日','開始日'),
    (4,'дата окончания','අවසන් දිනය','Endtag','समाप्त होने की तारीख','Jour de fin','Ending day','கடைசி நாள்','结束日','結束日'),
    (5,'номер аренды','කුලී අංකය','Mietnummer','किराया संख्या','numéro de loyer','Rent number','வாடகை எண்','租金号码','家賃番号'),
    (6,'выбрать место','ආරම්භක ස්ථා නය','Treffpunkt','लेने की जगह','lieu de ramassage','pickup location','எடுக்கும் இடம்','接人的地方','乗車場所'),
    (7,'Место сброса','අවසන් ස්ථා නය','Endort','समापन स्थान','lieu de fin','Drop off location','முடிவடையும் இடம்','结束地点','終了場所'),
    (8,'Добро пожаловать в OdysseyOnWheelz, с гордостью представленный Penguin Corporation, — ваш лучший выбор в сфере услуг по прокату автомобилей в Шри-Ланке. Созданный специально для взыскательных туристов, мы предлагаем незабываемое путешествие по красотам острова. Наслаждайтесь свободой путешествий с нашим разнообразным флотом, исключительным сервисом и стремлением сделать ваше приключение в Шри-Ланке незабываемым. Откройте для себя Шри-Ланку с OdysseyOnWheelz: где каждая поездка — это исследование.',
     'Penguin Corporation විසින් සාඩම්බරයෙන් ඉදිරිපත් කරන OdysseyOnWheelz වෙත සා දරයෙන් පිළිගනිමු - ශ්‍රී ලංකා වේ මෝ ටර් රථ කුලියට දීමේ සේවා  සඳහා ඔබේ ප්‍රමුඛ තේරීම. විචක්ෂණශීලී සංචා රකයින් සඳහා  ගැ ලපෙන පරිදි, අපි දිවයිනේ සුන්දරත්වය හරහා  බා ධා වකින් තො රව ගමනක් පිරිනමන්නෙමු. අපගේ විවිධ යා ත්‍රා  සමූහය, සුවිශේෂී සේවා ව සහ ඔබගේ ශ්‍රී ලා ංකේය වික්‍රමය අමතක නො වන බවට පත් කිරීමට ඇති කැ පවීම සමඟ ගවේෂණය කිරීමේ නිදහස භුක්ති විඳින්න. OdysseyOnWheelz සමඟින් ශ්‍රී ලංකා ව සො යා ගන්න - සෑ ම ධා වකයක්ම ගවේෂණයකි',
     'Willkommen bei OdysseyOnWheelz, stolz präsentiert von der Penguin Corporation – Ihrer ersten Wahl für Autovermietungen in Sri Lanka. Wir sind auf anspruchsvolle Touristen zugeschnitten und bieten eine nahtlose Reise durch die Schönheit der Insel. Genießen Sie die Freiheit, mit unserer vielfältigen Flotte, dem außergewöhnlichen Service und der Verpflichtung, Ihr Abenteuer in Sri Lanka unvergesslich zu machen, die Freiheit zu erkunden. Entdecken Sie Sri Lanka mit OdysseyOnWheelz – wo jede Fahrt eine Erkundung ist',
     'पेंगुइन कॉर्पोरेशन द्वारा गर्व से प्रस्तुत ओडिसीऑनव्हील्ज़ में आपका स्वागत है - श्रीलंका में कार किराए पर लेने की सेवाओं के लिए आपकी प्रमुख पसंद। समझदार पर्यटकों के लिए तैयार, हम द्वीप की सुंदरता के माध्यम से एक निर्बाध यात्रा प्रदान करते हैं। हमारे विविध बेड़े, असाधारण सेवा और अपने श्रीलंकाई साहसिक कार्य को अविस्मरणीय बनाने की प्रतिबद्धता के साथ अन्वेषण करने की स्वतंत्रता का आनंद लें। OdysseyOnWheelz के साथ श्रीलंका की खोज करें - जहां हर ड्राइव एक अन्वेषण है',
     'Bienvenue sur OdysseyOnWheelz, fièrement présenté par Penguin Corporation - votre premier choix pour les services de location de voitures au Sri Lanka. Conçus pour les touristes exigeants, nous proposons un voyage fluide à travers la beauté de l''île. Profitez de la liberté d''explorer avec notre flotte diversifiée, notre service exceptionnel et notre engagement à rendre votre aventure au Sri Lanka inoubliable. Découvrez le Sri Lanka avec OdysseyOnWheelz – où chaque trajet est une exploration',
     'Welcome to OdysseyOnWheelz, proudly presented by Penguin Corporation - your premier choice for car rental services in Sri Lanka. Tailored for discerning tourists, we offer a seamless journey through the island''s beauty. Enjoy the freedom to explore with our diverse fleet, exceptional service, and a commitment to making your Sri Lankan adventure unforgettable. Discover Sri Lanka with OdysseyOnWheelz – where every drive is an exploration',
     'OdysseyOnWheelz க்கு வரவேற்கிறோம், இது Penguin Corporation மூலம் பெருமையுடன் வழங்கப்படுகிறது - இலங்கையில் கார் வாடகை சேவைகளுக்கான உங்களின் முதன்மையான தேர்வாகும். புத்திசாலித்தனமான சுற்றுலாப் பயணிகளுக்கு ஏற்றவாறு, தீவின் அழகில் தடையற்ற பயணத்தை நாங்கள் வழங்குகிறோம். எங்களின் மாறுபட்ட கடற்படை, விதிவிலக்கான சேவை மற்றும் உங்கள் இலங்கை சாகசத்தை மறக்க முடியாததாக மாற்றுவதற்கான அர்ப்பணிப்பு ஆகியவற்றுடன் ஆராய்வதற்கான சுதந்திரத்தை அனுபவிக்கவும். OdysseyOnWheelz உடன் இலங்கையைக் கண்டறியவும் - ஒவ்வொரு ஓட்டமும் ஒரு ஆய்வு ஆகும்',
     '欢迎来到 OdysseyOnWheelz，由企鹅公司自豪地推出 - 您在斯里兰卡汽车租赁服务的首选。 我们专为眼光独到的游客量身打造，为您提供畅游岛屿美景的无缝之旅。 我们多元化的机队、卓越的服务以及让您的斯里兰卡冒险难忘的承诺让您享受自由探索的乐趣。 与 OdysseyOnWheelz 一起探索斯里兰卡——每一次驾驶都是一次探索',
     'ペンギン コーポレーションが自信を持って提供する OdysseyOnWheelz へようこそ。スリランカでのレンタカー サービスの第一選択です。 目の肥えた観光客向けに、島の美しさを巡るシームレスな旅をご提供します。 多様な船団、卓越したサービス、そしてスリランカの冒険を忘れられないものにするための取り組みで、自由な探検をお楽しみください。 OdysseyOnWheelz でスリランカを発見 – すべてのドライブが探検'),
     (9,'почему выбрали нас?','අපව තෝ රා  ගන්නේ ඇයි?','Warum uns wählen?','हमें क्यों चुनें?','Pourquoi nous choisir?','why choose us?','ஏன் எங்களை தேர்வு செய்தாய்?','为什么选择我们？','なぜ私たちを選ぶのですか？'),
     (10,'ПРИЧИНЫ, ПО КОТОРЫМУ МЫ ЛУЧШАЯ КОМПАНИЯ ПО АРЕНДЕ АВТОМОБИЛЕЙ В ШРИ-ЛАНКЕ',
      'අපි ශ්‍රී ලංකා වේ හො ඳම මෝ ටර් රථ කුලියට දෙන සමා ගම වීමට හේතු',
      'GRÜNDE, WARUM WIR DAS BESTE AUTOVERMIETUNGSUNTERNEHMEN IN SRI LANKA SIND',
      'श्रीलंका में हम सबसे अच्छी कार रेंटल कंपनी क्यों हैं के कारण',
      'RAISONS POUR LESQUELLES NOUS SOMMES LA MEILLEURE ENTREPRISE DE LOCATION DE VOITURES AU SRI LANKA',
      'REASONS WHY WE ARE THE BEST CAR RENTAL COMPANY IN SRI LANKA',
      'இலங்கையில் எங்கள் சிறந்த கார் கார் கம்பேனி என்றால் என்ன என்னும் காரணங்கள்',
      '我们是斯里兰卡最好的租车公司的原因',
      '日本で最高のレンタカー会社である理由'),
      (11,'Легко и безопасно','පහසු සහ ආරක්ෂිත','Einfach und sicher','आसान और सुरक्षित','Facile et sécurisé','Easy and secure','எளிதும் பாதுகாப்பும்','轻松安全','簡単で安全'),
      (12,'Изменения в бронировании','වෙන් කරවා  ගැ නීම','Buchungsänderungen','बुकिंग संशोधन','Modifications de réservation','Booking amendments','புக்கிங் மாற்றம்','预订修改','予約の修正'),
      (13,'Круглосуточная поддержка клиентов','24/7 පාරිභෝගික සහාය','Kundensupport rund um die Uhr','24/7 ग्राहक समर्थन','Assistance client 24/7','24/7 customer support','24/7 வாடிக்கையாளர் ஆதரவு','全天候客户支持','24/7カスタマーサポート'),
      (14,'Современный автопарк','නවීන බලඇණිය','Moderne Flotte','आधुनिक फ्लीट','Flotte moderne','Modern Fleet','புதிய வாகன கூடம்','现代车队','モダンフリート'),
      (15,'Неограниченный пробег','අසීමිත ගමන','Unbegrenzte Kilometer','सीमित किलोमीटर','Kilométrage illimité','Unlimited Mileage','கடந்துவிடத்தக்க காரணமும் எண்ணெயும்','无限里程','制限なしの走行距離');

INSERT INTO rent(rentId, customerNIC, rent_starting, rent_ending, order_date) VALUES
    ('R-00001','AB123456','2024-01-05','2024-02-12','2024-01-06'),
    ('R-00002','FF901234','2024-01-12','2024-01-15','2024-01-07'),
    ('R-00003','FF901234','2024-01-18','2024-01-18','2024-01-07'),
    ('R-00004','GG567890','2024-02-18','2024-02-19','2024-01-07');

INSERT INTO rent_detail (rent_id, vehicle_id, rent_fee,excess_Mileage_cost, start_date, end_date, order_date) VALUES
    ('R-00001','ZAB-5678',26500,0,'2024-01-05','2024-02-12','2024-01-06'),
    ('R-00001','QRS-5678',34500,0,'2024-01-05','2024-02-12','2024-01-06'),
    ('R-00002','VWX-1234',34500,0,'2024-01-12','2024-01-15','2024-01-07'),
    ('R-00002','IJK-5678',22500,0,'2024-01-12','2024-01-15','2024-01-07'),
    ('R-00002','ABC-1234',13500,0,'2024-01-12','2024-01-15','2024-01-07'),
    ('R-00003','ABC-1234',13500,0,'2024-01-18','2024-01-18','2024-01-07'),
    ('R-00004','MNO-1234',34500,0,'2024-02-18','2024-02-19','2024-01-07'),
    ('R-00004','PQR-5678',39500,0,'2024-02-18','2024-02-19','2024-01-07'),
    ('R-00004','JKL-9876',34500,0,'2024-02-18','2024-02-19','2024-01-07'),
    ('R-00004','ZAB-5678',26500,0,'2024-02-18','2024-02-19','2024-01-07');
