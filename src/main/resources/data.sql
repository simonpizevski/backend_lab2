INSERT INTO category (name, symbol, description)
VALUES ('Park', '🌳', 'Grönområden och parker i hela Sverige'),
       ('Museum', '🏛️', 'Museer och kulturarv i Sverige'),
       ('Naturreservat', '🌿', 'Skyddade naturområden och nationalparker'),
       ('Stad', '🏢', 'Städer och urbana områden');

INSERT INTO location (name, category_id, user_id, is_public, last_modified, created_at, description, coordinate)
VALUES ('Kungsträdgården', 1, 1, true, NOW(), NOW(), 'En av Stockholms mest kända parker, belägen nära gamla stan.',
        ST_GeomFromText('POINT(18.0712 59.3285)', 4326)),
       ('Vasamuseet', 2, 2, true, NOW(), NOW(), 'Museum på Djurgården som hyser det världskända skeppet Vasa.',
        ST_GeomFromText('POINT(18.0916 59.3274)', 4326)),
       ('Abisko Nationalpark', 3, 1, false, NOW(), NOW(),
        'En av Sveriges mest kända nationalparker belägen i Lappland.',
        ST_GeomFromText('POINT(18.7836 68.3589)', 4326)),
       ('Gamla Stan', 4, 3, false, NOW(), NOW(),
        'Stockholms historiska stadskärna med medeltida gator och byggnader.',
        ST_GeomFromText('POINT(18.0714 59.3251)', 4326)),
       ('Liseberg', 1, 4, true, NOW(), NOW(), 'En av Europas största nöjesparker, belägen i Göteborg.',
        ST_GeomFromText('POINT(11.9860 57.6906)', 4326)),
       ('Skåneleden', 3, 5, false, NOW(), NOW(), 'Långvandring på den berömda Skåneleden i sydöstra Sverige.',
        ST_GeomFromText('POINT(13.1626 55.6505)', 4326)),
       ('Höga Kusten', 3, 6, true, NOW(), NOW(),
        'Ett UNESCO-världsarv och naturreservat vid Höga Kusten i Ångermanland.',
        ST_GeomFromText('POINT(18.0663 63.2924)', 4326)),
       ('Stortorget, Malmö', 4, 7, false, NOW(), NOW(),
        'Malmös största torg med närhet till stadens shopping och restauranger.',
        ST_GeomFromText('POINT(13.0023 55.6079)', 4326)),
       ('Kosterhavet Nationalpark', 3, 1, false, NOW(), NOW(),
        'Sveriges första marina nationalpark som ligger utanför västkusten.',
        ST_GeomFromText('POINT(11.2404 58.7983)', 4326));

