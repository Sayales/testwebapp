CREATE TABLE `notes` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DONE` bit(1) DEFAULT NULL,
  `TEXT` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
INSERT INTO test.notes (ID, DONE, TEXT) VALUES (15, false, 'First note');
INSERT INTO test.notes (ID, DONE, TEXT) VALUES (16, false, 'One More Testing Edited');
INSERT INTO test.notes (ID, DONE, TEXT) VALUES (17, false, 'Another one');
INSERT INTO test.notes (ID, DONE, TEXT) VALUES (18, false, 'More TODOs');
INSERT INTO test.notes (ID, DONE, TEXT) VALUES (19, false, 'For the God of TODOs');