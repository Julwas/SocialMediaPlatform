INSERT INTO `hospital`.`departments` (`department_id`, `name`, `description`) VALUES ('1', 'Cardiology', 'Specializes in heart treatments');
INSERT INTO `hospital`.`departments` ( `name`, `description`) VALUES ( 'Neurology', 'Focuses on nervous system disorders');
INSERT INTO `hospital`.`departments` ( `name`, `description`) VALUES ( 'Orthopedics', 'Handles bone and joint-related conditions.');
INSERT INTO `hospital`.`departments` ( `name`, `description`) VALUES ( 'Pediatrics', 'Provides healthcare for children.');
INSERT INTO `hospital`.`departments` ( `name`, `description`) VALUES ( 'Oncology', 'Dedicated to cancer diagnosis and treatment.');

INSERT INTO `hospital`.`doctors` (`doctors_id`, `first_name`, `last_name`, `specialization`, `department_id`) 
VALUES 
    ('2001', 'John', 'Doe', 'Cardiology', 1),
    ('2002', 'Jane', 'Smith', 'Neurology', 2),
    ('2003', 'Robert', 'Brown', 'Orthopedics', 3),
    ('2004', 'Emily', 'Davis', 'Pediatrics', 4),
    ('2005', 'Michael', 'Wilson', 'Dermatology', 5);
    
   INSERT INTO `hospital`.`nurses` (`nurses_id`, `first_name`, `last_name`, `assigned_id_department`) 
VALUES 
    ('3001', 'Sophia', 'Johnson', 1),
    ('3002', 'Emma', 'Williams', 2),
    ('3003', 'Olivia', 'Jones', 3),
    ('3004', 'Ava', 'Brown', 4),
    ('3005', 'Isabella', 'Taylor', 5); 
    
    INSERT INTO `hospital`.`patients` (`first_name`, `last_name`, `date_of_birth`, `gender`, `address`, `contact_number`) 
VALUES 
    ('James', 'Smith', '1980-05-15', 'Male', '123 Elm Street', 123456789),
    ('Mary', 'Johnson', '1990-03-22', 'Female', '456 Pine Avenue', 234567890),
    ('Robert', 'Williams', '1975-11-05', 'Male', '789 Oak Drive', 345678901),
    ('Patricia', 'Brown', '1985-07-19', 'Female', '321 Maple Lane', 456789012),
    ('Michael', 'Taylor', '2000-01-10', 'Male', '654 Cedar Road', 567890123);
    
    INSERT INTO `hospital`.`appointments` 
(`patient_id_appointments`, `doctor_id_appointments`, `appointment_date`, `status`) 
VALUES 
    (11, 2001, '2025-01-30', 'Scheduled'),
    (12, 2002, '2025-01-31', 'Completed'),
    (13, 2003, '2025-02-01', 'Cancelled'),
    (14, 2004, '2025-02-02', 'Scheduled'),
    (15, 2005, '2025-02-03', 'Rescheduled');
    
    INSERT INTO `Hospital`.`LabTest` (`name`, `description`, `cost`) 
VALUES
('Complete Blood Count', 'Measures different components of blood', 15.00),
('Lipid Panel', 'Checks cholesterol and triglycerides', 25.50),
('Blood Glucose', 'Measures sugar level in the blood', 10.00),
('Liver Function Test', 'Assesses liver health', 30.00),
('Thyroid Function Test', 'Measures thyroid hormone levels', 20.00);

INSERT INTO `Hospital`.`TestResults` 
(`patient_id_test_result`, `lab_test_id_test_result`, `test_date`, `doctor_id_test_result`, `result`) 
VALUES
(11, 1, '2025-01-01', 2001, 'Normal'),
(12, 2, '2025-01-02', 2002, 'High Cholesterol'),
(13, 3, '2025-01-03', 2003, 'Normal'),
(14, 4, '2025-01-04', 2004, 'Elevated Levels'),
(15, 5, '2025-01-05', 2005, 'Abnormal');

INSERT INTO `Hospital`.`Rooms` (`room_number`, `type`, `capacity`) 
VALUES
(101, 'ICU', 1),
(102, 'General', 3),
(103, 'Private', 2),
(104, 'ICU', 1),
(105, 'General', 4);

INSERT INTO `Hospital`.`Admissions` 
(`patient_id_admissions`, `room_id_admissions`, `admission_date`, `discharge_date`) 
VALUES
(11, 1, '2025-01-01', '2025-01-10'),
(12, 2, '2025-01-02', NULL),
(13, 3, '2025-01-03', '2025-01-08'),
(14, 4, '2025-01-04', '2025-01-09'),
(15, 5, '2025-01-05', NULL);

INSERT INTO `Hospital`.`Medications` (`name`, `descriptions`, `manufacturer`) 
VALUES
('Aspirin', 'Pain reliever', 'Bayer'),
('Paracetamol', 'Fever reducer', 'Johnson & Johnson'),
('Metformin', 'Diabetes medication', 'Merck'),
('Atorvastatin', 'Lowers cholesterol', 'Pfizer'),
('Amoxicillin', 'Antibiotic', 'GSK');

INSERT INTO `Hospital`.`Prescriptions` 
(`patient_id_prescriptions`, `doctor_id_prescriptions`, `medication_id_prescriptions`, `dosage`, ` frequency`,
 `start_date`, `end_date`)
VALUES
(11, 2001, 11, '500mg', 'Once Daily', '2025-01-01', '2025-01-10'),
(12, 2002, 12, '1 tablet', 'Twice Daily', '2025-01-02', '2025-01-12'),
(13, 2003, 13, '850mg', 'Once Daily', '2025-01-03', '2025-01-13'),
(14, 2004, 14, '10mg', 'Once Daily', '2025-01-04', '2025-01-14'),
(15, 2005, 15, '250mg', 'Every 6 hours', '2025-01-05', '2025-01-15');

INSERT INTO `Hospital`.`Billing` 
(`patient_id_billing`, `admission_id_billing`, `total_amount`, `paid_amount`, `billing_date`, `payment_status`,
`labtest_id_billing`)
VALUES
(11, 11, 500.00, 500.00, '2025-01-11', 'Paid', 1),
(12, 12, 300.00, 150.00, '2025-01-12', 'Partial', 2),
(13, 13, 400.00, 400.00, '2025-01-13', 'Paid', 3),
(14, 14, 600.00, 0.00, '2025-01-14', 'Unpaid', 4),
(15, 15, 250.00, 250.00, '2025-01-15', 'Paid', 5);
-- Update 
UPDATE `Hospital`.`Doctors` SET `specialization` = 'Cardiovascular Surgery' WHERE `doctors_id` = 2001;
UPDATE `Hospital`.`Rooms` SET `type` = 'Private' WHERE `room_number` = 102;
UPDATE `Hospital`.`Patients` SET `contact_number` = 987654321 WHERE `first_name` = 'James' AND `last_name` = 'Smith';
UPDATE `Hospital`.`LabTest` SET `cost` = 18.00 WHERE `name` = 'Complete Blood Count';
UPDATE `Hospital`.`Appointments` SET `status` = 'Completed' WHERE `appointment_date` = '2025-01-30';
UPDATE `Hospital`.`Billing` SET `payment_status` = 'Partial' WHERE `billing_id` = 14;
UPDATE `Hospital`.`Nurses` SET `assigned_id_department` = 3 WHERE `nurses_id` = 3002;
UPDATE `Hospital`.`Admissions` SET `discharge_date` = '2025-01-20' WHERE `admissions_id` = 12;
UPDATE `Hospital`.`Prescriptions` SET `dosage` = '750mg' WHERE `prescriptions_id` = 13;
UPDATE `Hospital`.`Medications` SET `descriptions` = 'Effective pain relief and anti-inflammatory' WHERE `name` = 'Aspirin';
-- Delete
DELETE FROM `Hospital`.`Doctors` WHERE `doctors_id` = 2005;
DELETE FROM `Hospital`.`Nurses` WHERE `nurses_id` = 3005;
DELETE FROM `Hospital`.`LabTest` WHERE `labTest_id` = 5;
DELETE FROM `Hospital`.`Patients` WHERE `first_name` = 'Michael' AND `last_name` = 'Taylor';
DELETE FROM `Hospital`.`Appointments` WHERE `appointment_date` = '2025-02-03';
DELETE FROM `Hospital`.`Rooms` WHERE `room_number` = 105;
DELETE FROM `Hospital`.`Admissions` WHERE `admissions_id` = 15;
DELETE FROM `Hospital`.`Prescriptions` WHERE `prescriptions_id` = 15;
DELETE FROM `Hospital`.`Billing` WHERE `billing_id` = 15;
DELETE FROM `Hospital`.`Departments` WHERE `department_id` = 5;
-- Alter
ALTER TABLE `Hospital`.`Patients` ADD COLUMN `email` VARCHAR(100) AFTER `contact_number`;
ALTER TABLE `Hospital`.`Rooms` MODIFY COLUMN `capacity` INT NOT NULL DEFAULT 1;
ALTER TABLE `Hospital`.`Prescriptions`  DROP COLUMN `end_date`;
ALTER TABLE `Hospital`.`LabTest` CHANGE COLUMN `description` `details` VARCHAR(200);
ALTER TABLE `Hospital`.`Nurses` DROP COLUMN `last_name`;

SELECT 
    p.first_name AS PatientName,
    p.last_name AS PatientLastName,
    d.first_name AS DoctorName,
    d.last_name AS DoctorLastName,
    a.room_id_admissions,
    r.room_number,
    lt.name AS LabTestName,
    tr.result AS TestResult,
    m.name AS MedicationName,
    pr.dosage,
    b.total_amount AS BillingAmount,
    b.payment_status
FROM `Hospital`.`Patients` p
JOIN `Hospital`.`Admissions` a ON p.patients_id = a.patient_id_admissions
JOIN `Hospital`.`Rooms` r ON a.room_id_admissions = r.rooms_id
JOIN `Hospital`.`Prescriptions` pr ON p.patients_id = pr.patient_id_prescriptions
JOIN `Hospital`.`Doctors` d ON pr.doctor_id_prescriptions = d.doctors_id
JOIN `Hospital`.`LabTest` lt ON p.patients_id = lt.labTest_id
JOIN `Hospital`.`TestResults` tr ON lt.labTest_id = tr.lab_test_id_test_result
JOIN `Hospital`.`Medications` m ON pr.medication_id_prescriptions = m.medications_id
JOIN `Hospital`.`Billing` b ON p.patients_id = b.patient_id_billing;

-- 5 Statements with Joins
SELECT p.first_name, d.first_name AS DoctorName
FROM `Hospital`.`Patients` p
INNER JOIN `Hospital`.`Appointments` a ON p.patients_id = a.patient_id_appointments
INNER JOIN `Hospital`.`Doctors` d ON a.doctor_id_appointments = d.doctors_id;

SELECT d.first_name AS DoctorName, n.first_name AS NurseName
FROM `Hospital`.`Doctors` d
LEFT JOIN `Hospital`.`Nurses` n ON d.department_id = n.assigned_id_department;

SELECT r.room_number, a.admission_date
FROM `Hospital`.`Rooms` r
RIGHT JOIN `Hospital`.`Admissions` a ON r.rooms_id = a.room_id_admissions;

SELECT p.first_name, a.admission_date
FROM `Hospital`.`Patients` p
LEFT JOIN `Hospital`.`Admissions` a ON p.patients_id = a.patient_id_admissions
UNION
SELECT p.first_name, a.admission_date
FROM `Hospital`.`Patients` p
RIGHT JOIN `Hospital`.`Admissions` a ON p.patients_id = a.patient_id_admissions;

SELECT d1.first_name AS Doctor1, d2.first_name AS Doctor2
FROM `Hospital`.`Doctors` d1
INNER JOIN `Hospital`.`Doctors` d2 ON d1.department_id = d2.department_id AND d1.doctors_id <> d2.doctors_id;

--  Aggregate Functions (Without HAVING)
SELECT COUNT(*) AS TotalPatients FROM `Hospital`.`Patients`;
SELECT AVG(cost) AS AverageCost FROM `Hospital`.`LabTest`;
SELECT SUM(total_amount) AS TotalBilling FROM `Hospital`.`Billing`;
SELECT MAX(capacity) AS MaxCapacity FROM `Hospital`.`Rooms`;
SELECT MIN(cost) AS MinCost FROM `Hospital`.`LabTest`;
SELECT status, COUNT(*) AS AppointmentCount FROM `Hospital`.`Appointments` GROUP BY status;
SELECT payment_status, SUM(total_amount) AS TotalAmount FROM `Hospital`.`Billing` GROUP BY payment_status;

-- Aggregate Functions (With HAVING)

SELECT patient_id_admissions, COUNT(*) AS AdmissionCount
FROM `Hospital`.`Admissions`
GROUP BY patient_id_admissions
HAVING COUNT(*) > 1;

SELECT doctor_id_prescriptions, COUNT(*) AS PrescriptionCount
FROM `Hospital`.`Prescriptions`
GROUP BY doctor_id_prescriptions
HAVING COUNT(*) > 2;

SELECT department_id, COUNT(*) AS DoctorCount
FROM `Hospital`.`Doctors`
GROUP BY department_id
HAVING COUNT(*) > 2;

SELECT type, AVG(capacity) AS AvgCapacity
FROM `Hospital`.`Rooms`
GROUP BY type
HAVING AVG(capacity) > 3;

SELECT labTest_id, AVG(cost) AS AvgCost
FROM `Hospital`.`LabTest`
GROUP BY labTest_id
HAVING AVG(cost) > 20;

SELECT patient_id_billing, SUM(total_amount) AS TotalAmount
FROM `Hospital`.`Billing`
GROUP BY patient_id_billing
HAVING SUM(total_amount) > 500;

SELECT result, COUNT(*) AS ResultCount
FROM `Hospital`.`TestResults`
GROUP BY result
HAVING COUNT(*) < 2;