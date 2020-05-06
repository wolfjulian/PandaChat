SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;


CREATE TABLE `user` (
  `ID` int(11) NOT NULL,
  `Benutzername` varchar(30) NOT NULL,
  `Chatname` varchar(30) NOT NULL,
  `Passwort` varchar(50) NOT NULL,
  `RegistriertSeit` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Gebannt` tinyint(1) DEFAULT NULL,
  `GebanntBis` datetime NOT NULL,
  `Administrator` tinyint(1) NOT NULL,
  `Moderator` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `user` (`ID`, `Benutzername`, `Chatname`, `Passwort`, `RegistriertSeit`, `Gebannt`, `GebanntBis`, `Administrator`, `Moderator`) VALUES
(1, 'abel', 'abel', 'abel', '2020-04-04 12:19:37', NULL, '0000-00-00 00:00:00', 1, 0),
(2, 'bebel', 'bebel', 'bebel', '2020-04-04 12:19:37', NULL, '0000-00-00 00:00:00', 0, 1),
(3, 'cebel', 'cebel', 'cebel', '2020-04-04 12:21:42', NULL, '0000-00-00 00:00:00', 0, 0),
(4, 'debel', 'debel', 'debel', '2020-04-04 12:21:42', 1, '2020-08-31 15:00:00', 0, 0);


ALTER TABLE `user`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `userbenutzernameUNQ` (`Benutzername`);


ALTER TABLE `user`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
