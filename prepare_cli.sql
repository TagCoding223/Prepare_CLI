-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 20, 2025 at 03:51 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `prepare_cli`
--

-- --------------------------------------------------------

--
-- Table structure for table `chapter`
--

CREATE TABLE `chapter` (
  `chapter_id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `chapter`
--

INSERT INTO `chapter` (`chapter_id`, `name`) VALUES
(1, 'Number System'),
(2, 'Ratio');

-- --------------------------------------------------------

--
-- Table structure for table `field_model`
--

CREATE TABLE `field_model` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `field_model`
--

INSERT INTO `field_model` (`id`, `name`) VALUES
(1, 'SSC'),
(2, '10Th');

-- --------------------------------------------------------

--
-- Table structure for table `field_model_subject`
--

CREATE TABLE `field_model_subject` (
  `id` bigint(20) NOT NULL,
  `field_model_id` bigint(20) NOT NULL,
  `subject_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `field_model_subject`
--

INSERT INTO `field_model_subject` (`id`, `field_model_id`, `subject_id`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 1, 4),
(5, 2, 1),
(6, 2, 6),
(7, 2, 2),
(8, 2, 5);

-- --------------------------------------------------------

--
-- Table structure for table `field_model_subject_chapter`
--

CREATE TABLE `field_model_subject_chapter` (
  `id` bigint(20) NOT NULL,
  `chapter_id` bigint(20) NOT NULL,
  `field_model_subject_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `field_model_subject_chapter`
--

INSERT INTO `field_model_subject_chapter` (`id`, `chapter_id`, `field_model_subject_id`) VALUES
(5, 1, 1),
(6, 2, 1),
(7, 2, 5);

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE `question` (
  `id` bigint(20) NOT NULL,
  `correctOption` varchar(255) NOT NULL,
  `optionA` varchar(255) NOT NULL,
  `optionB` varchar(255) NOT NULL,
  `optionC` varchar(255) NOT NULL,
  `optionD` varchar(255) NOT NULL,
  `question` text NOT NULL,
  `chapter_id` bigint(20) NOT NULL,
  `field_model_id` bigint(20) NOT NULL,
  `subject_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`id`, `correctOption`, `optionA`, `optionB`, `optionC`, `optionD`, `question`, `chapter_id`, `field_model_id`, `subject_id`) VALUES
(1, '4', '3', '4', '5', '6', 'What is 2 + 2?', 1, 1, 1),
(2, '11', '7', '11', '13', '9', 'Find the greatest common divisor of 803 and 154 using the Euclidean Algorithm.', 1, 1, 1),
(3, '2q+1', '2q', '2q + 1', 'q', 'q + 1', 'Every positive odd Integer is in the form', 1, 1, 1),
(4, '0 ≤ r < b', '1 < r < b', '0 < r ≤ b', '0 ≤ r < b', '0 < r < b', 'Euclids division lemma states that for any positive integers a and b there exist unique integers q and r such that a = bq + r, where r must satisfy', 1, 1, 1),
(5, '100020203', '100002203', '1020203', '1002203', '100020203', 'Ten crore twenty thousand two hundred three is written in figures as', 1, 1, 1),
(6, '34', '1', '3', '17', '34', 'Consider the following for the next two (02) items that follow :\r\n<br>\r\nConsider the sum<br>\r\n\r\nS = 0! + 1! + 2! + 3! + 4! +... .+ 100!\r\n<br>\r\n\r\nIf the sum S is divided by 60, what is the remainder ?', 1, 1, 1),
(7, '2', '0', '1', '2', 'Cannot be determined', 'Consider the following for the next two (02) items that follow :\r\n<br>\r\nConsider the sum<br>\r\n\r\nS = 0! + 1! + 2! + 3! + 4! +... .+ 100!\r\n<br>\r\nIf the sum S is divided by 8, what is the remainder ?', 1, 1, 1),
(8, '2 only', '1 only', '2 only', 'Both 1 and 2', 'Neither 1 nor 2', 'Consider the following statements :\r\n<br>\r\n(25)! + 1 is divisible by 26\r\n<br>\r\n(6)! + 1 is divisible by 7\r\n<br>\r\nWhich of the above statements is/are correct ?', 1, 1, 1),
(9, '1111110011', '1011', '111011', '111111001', '1111110011', 'What is the binary number equivalent to decimal number 1011 ?', 1, 1, 1),
(10, '311', '310', '311', '312', '313', '(11 ones + 10 tens + 12 hundreds - one thousand) is equal to', 1, 1, 1),
(11, 'Rational', 'Rational', 'Irrational', 'Natural', 'Non-Real', '0 is a/an ______ number.', 1, 1, 1),
(12, '100', ' 120', '125', '90', '100', 'In an election 95% of the eligible voters cast their votes. 30% of the votes cast were declared invalid. The winner got 60% of the valid votes. If the winner got 798 votes, how many of the eligible voters did not cast their votes?', 1, 1, 1),
(13, '85', '58', '85', '74', 'None of these', 'A two digit number contains the smaller of two digits in the units place. The product is 40 and the difference between the digits is 3. Then the number is', 1, 1, 1),
(14, '73', '71', '72', '74', '73', 'What is the difference between the sum of first five prime numbers and sum of next five prime numbers?', 1, 1, 1),
(15, 'Rs. 30', 'Rs 33', 'Rs. 30', 'Rs. 47', 'Rs. 50', 'A and B went to a shop to buy chocolate and candies. The price of each chocolate is Rs. 5 more than that of each candy. Although they spent the same amount, A bought twice as many chocolates as B who in turn, bought 6 more candies than A. If the price of both chocolate and candy is a positive integer. Then what can be the maximum price of a chocolate ?', 1, 1, 1),
(16, 'Decimal expansion of an irrational number is non-terminating and non- repeating', 'Decimal expansion of a rational number is terminating', 'Decimal expansion of a rational number is non-terminating', 'Decimal expansion of an irrational number is terminating', 'Decimal expansion of an irrational number is non-terminating and non- repeating', 'Which one of the following is a correct statement?', 1, 1, 1),
(17, 'irrational number', 'irrational number', 'rational number', 'whole number', 'natural number', 'The product of a non-zero rational number with an irrational number is', 1, 1, 1),
(18, 'π is irrational and 227227 is rationals', 'π and 227227 are both rationals', 'π and 227227 are both irrationals', 'π is rational and 227227 are irrationals', 'π is irrational and 227227 is rationals', 'Which of the following statements is true?', 1, 1, 1),
(19, 'A and D only', 'A, C and E only', 'A and B only', 'B and D only', 'A and D only', 'Choose the set of numbers, similar to the set (31, 19, 41) out of the following:\r\n<br>\r\n(27, 29, 47)\r\n<br>\r\n(23, 34, 49)\r\n<br>\r\n(29, 16, 41)\r\n<br>\r\n(29, 17, 37)\r\n<br>\r\n(23, 37, 49)\r\n<br>\r\nChoose the correct answer from the options given below:', 1, 1, 1),
(20, '0.64', '0.064', '0.64', '0.006', '0.694', 'Compute the value of (0.35)2-(0.03)20.19(0.35)2-(0.03)20.19 upto 3 decimal place.', 1, 1, 1),
(21, '12', '7', '12', '15', '21', '(72n - 1) If n is a natural number then it is divisible by', 1, 1, 1),
(22, '1', '2', '1', '3', '5', 'Which of the following numbers is not a prime number?', 1, 1, 1),
(23, '3', '5', '2', '3', '4', 'Consider the numbers a, b, c and d with values 54, 71, 75 and 99, respectively. Find a number which may be subtracted from each of them such that ab=cd��=��', 1, 1, 1),
(24, '118', '118', '127', '99', '123', 'Out of four integers, any three were randomly taken at a time and added. The results were found to be 174, 193, 267 and 242. Which of the following integers is the greatest among these four?', 1, 1, 1),
(25, '113', '113', '209', '317', '191', 'Which one of the following three-digit numbers divides 9238 and 7091 with the same remainder in each case?', 1, 1, 1),
(26, '0 ≤ r < b', '1 < r < b', '0 < r ≤ b', '0 ≤ r < b', '0 < r < b', 'Euclids division lemma states that for any positive integers a and b there exist unique integers q and r such that a = bq + r, where r must satisfy', 1, 1, 1),
(27, '121900121900', '121900121900', '137990137990', '1190011900', '101990101990', 'Express 0.134¯0.134¯ in the from of pq��', 1, 1, 1),
(28, '12.4', '8.4', '13.7', '12.4', '9.4', 'The mean of all the factors of 48 is', 1, 1, 1),
(29, 'either a natural number or an irrational number', 'always a natural number', 'always a rational number', 'always an irrational number', 'either a natural number or an irrational number', 'If n is a natural number, then √n is', 1, 1, 1),
(30, '21', '22', '105', '21', '55', 'What is the value of [(1 + 2 + 3 + .......... +20)/10]?', 1, 1, 1),
(31, '70', '50', '60', '70', 'none of these', 'When 40% of a number is added to 42, the result is the number itself. Then, the number is', 1, 1, 1),
(32, '24, 12', '25, 11', '24, 12', '10, 16', '14, 22', 'Divide 36 into two parts, such that the sum of the reciprocals is 1/8.', 1, 1, 1),
(33, '1036000', '1030000', '1000000', '1036000', '1040000', 'Which of the following numbers will be obtained when the number 1035608 is rounded off to the nearest thousand?', 1, 1, 1),
(34, '4', '4', '12', '5', '9', 'How many integers in the set {1, 2, 3,....., 100} have exactly 3 divisors?', 1, 1, 1),
(35, '280', '275', '265', '270', '280', 'How many times does the digit 3 appear when you count between 100 to 1000?', 1, 1, 1),
(36, '110', '121', '102', '110', '135', 'What will be the decimal equivalent for binary number 1101110?', 1, 1, 1),
(37, '2', '4', '2', '8', '16', 'For converting a number in decimal number system to its binary equivalent, remainders are recorded after successive division of the number by', 1, 1, 1),
(38, '6 : 13', '6 : 13', '3 : 16', '5 : 13', '8 : 15', 'There are 2 numbers in the ratio of 9 : 16. If 112 is added to both numbers the ratio becomes 37 : 44. What will be the ratio if 12 is subtracted from both numbers?', 1, 1, 1),
(39, '1', '4', '9', '1', '16', 'If a seven-digit number 5642X7Y is divisible by 12. If we take the minimum possible value of X and Y. Then the value of (X - Y)12 is', 1, 1, 1),
(40, '3080', '3160', '2940', '3240', '3080', '\r\nWhat is the sum of first 20 terms of the following series ?\r\n\r\n1 x 2 + 2 x 3 + 3 x 4 + 4 x 5 + ..........', 1, 1, 1),
(41, '400', '300', '210', '400', '420', 'The sum of first 20 odd natural numbers is equal to:', 1, 1, 1),
(42, '42', '72', '50', '42', '36', 'The sum of two numbers is 70. If 30% of the first number is equal to the 45% of the second number. Find the larger of the two numbers.', 1, 1, 1),
(43, '1', '-1', '1', '2', '-2', 'If x2 = y + z, y2 = z + x, z2 = x + y then the value of 1x+1+1y+1+1z+11�+1+1�+1+1�+1 is -', 1, 1, 1),
(44, '6003', '6003', '6890', '6546', '6668', 'The greatest number which on rounding off to nearest thousand gives 6000 is:-', 1, 1, 1),
(45, '24', '18', '24', '42', '81', 'A two-digit number is such that the product of the digits is 8. When 18 is added to the number, then the digits are reversed. The number is', 1, 1, 1),
(46, '40', '40', '45', '35', '30', 'A sum of Rs. 312 was divided among 100 boys and girls in such a way that each boy gets Rs. 3.60 and each girl Rs. 2.40. The number of girls is', 1, 1, 1),
(47, '2', '2', '3', '4', '5', 'The product of a non-zero whole number and its successor is always divisible by', 1, 1, 1),
(48, '99987', '99999', '98978', '98987', '99987', 'The largest 5-digit number having three different digits is', 1, 1, 1),
(49, '27', '26', '27', '32', '35', 'If 1/3 of 1/4 of a number is 18, then what is the value of 1/8 of that number?', 1, 1, 1),
(50, '27', '32', '28', '27', '23', 'If the product of two numbers is 180 and the sum of their squares is 369, then what is the sum of the numbers?', 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`id`, `name`) VALUES
(1, 'Math'),
(2, 'Science'),
(3, 'Reasoning'),
(4, 'Computer'),
(5, 'Social Science'),
(6, 'Sanskrit');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `city` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `user_role` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `city`, `email`, `user_name`, `password`, `phone`, `user_role`) VALUES
(1, 'Pune', 'k@gmail.com', 'Km Dubey', 'k@321', '7896332145', 'User_Role'),
(4, '', '', '', '', '', 'User_Role'),
(5, 'Indore', 'vishalchouhan@gmail.com', 'Vishal Chouhan', 'vishal@123', '856321479', 'User_Role');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chapter`
--
ALTER TABLE `chapter`
  ADD PRIMARY KEY (`chapter_id`);

--
-- Indexes for table `field_model`
--
ALTER TABLE `field_model`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `field_model_subject`
--
ALTER TABLE `field_model_subject`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK5xgfp4si7iv7yelrlshl7frpc` (`field_model_id`),
  ADD KEY `FKqy204lcq5g27uqjq9r8wi2g8h` (`subject_id`);

--
-- Indexes for table `field_model_subject_chapter`
--
ALTER TABLE `field_model_subject_chapter`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKqdqgnla4sj48bhxe5me1cbt8o` (`chapter_id`),
  ADD KEY `FK39cretcp70xqri9wlo0ia6gib` (`field_model_subject_id`);

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKrms5bmu5xtol6rxcv4pnckcpm` (`chapter_id`),
  ADD KEY `FKnvw5vr2w3gfp13x042kuwq0og` (`field_model_id`),
  ADD KEY `FKkfvh71q42645g7p9cgxjygbgc` (`subject_id`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `UK_e6gkqunxajvyxl5uctpl2vl2p` (`email`),
  ADD UNIQUE KEY `UK_8f9egnwceetj2aq0hwqd8togf` (`phone`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chapter`
--
ALTER TABLE `chapter`
  MODIFY `chapter_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `field_model`
--
ALTER TABLE `field_model`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `field_model_subject`
--
ALTER TABLE `field_model_subject`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `field_model_subject_chapter`
--
ALTER TABLE `field_model_subject_chapter`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT for table `subject`
--
ALTER TABLE `subject`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `field_model_subject`
--
ALTER TABLE `field_model_subject`
  ADD CONSTRAINT `FK5xgfp4si7iv7yelrlshl7frpc` FOREIGN KEY (`field_model_id`) REFERENCES `field_model` (`id`),
  ADD CONSTRAINT `FKqy204lcq5g27uqjq9r8wi2g8h` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`);

--
-- Constraints for table `field_model_subject_chapter`
--
ALTER TABLE `field_model_subject_chapter`
  ADD CONSTRAINT `FK39cretcp70xqri9wlo0ia6gib` FOREIGN KEY (`field_model_subject_id`) REFERENCES `field_model_subject` (`id`),
  ADD CONSTRAINT `FKqdqgnla4sj48bhxe5me1cbt8o` FOREIGN KEY (`chapter_id`) REFERENCES `chapter` (`chapter_id`);

--
-- Constraints for table `question`
--
ALTER TABLE `question`
  ADD CONSTRAINT `FKkfvh71q42645g7p9cgxjygbgc` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`),
  ADD CONSTRAINT `FKnvw5vr2w3gfp13x042kuwq0og` FOREIGN KEY (`field_model_id`) REFERENCES `field_model` (`id`),
  ADD CONSTRAINT `FKrms5bmu5xtol6rxcv4pnckcpm` FOREIGN KEY (`chapter_id`) REFERENCES `chapter` (`chapter_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
