create database courseManagementSystem
    on
    primary (name=coursedata,
    filename='c:\Software\DataBase\courseData.mdf',
    size=10MB,
    maxsize=15MB,
    filegrowth=20%)
    log on
    (name=courselog,
        filename='c:\Software\DataBase\courseData.ldf',
        size=3MB,
        maxsize=5MB,
        filegrowth=1MB)



create table student
(
    student_ID int identity(10001,1) primary key,
    student_Fname nvarchar(15),
    student_Mname nvarchar(15),
    student_lname nvarchar(15),
    student_gpa float not null,
    course1  nvarchar(10),
    course2  nvarchar(10),
    course3  nvarchar(10),
    course4  nvarchar(10),
    course5  nvarchar(10),
    course6  nvarchar(10),
    course7  nvarchar(10),
)
create table instructor
(
    instructor_ID int identity(101,1) primary key,
    instructor_Fname nvarchar(15),
    instructor_Mname nvarchar(15),
    instructor_lname nvarchar(15),
    course1  nvarchar(10),
    course2  nvarchar(10),
    course3  nvarchar(10),
    course4  nvarchar(10),
    course5  nvarchar(10),

)
create table allAdmin
(
    admin_ID int identity(1,1) primary key,
    admin_Fname nvarchar(15),
    admin_Mname nvarchar(15),
    admin_lname nvarchar(15),
)
create table allPassword
(
    id int,
    pass nvarchar(100) ,
    person nvarchar(10)
)
create table course
(
    nameOfCourse nvarchar(15),
    courseCode nvarchar(10) primary key,
    startDate date,
    endDate date,
    daysOfCourse int,
    numberOfHours int,
    price smallmoney,
    room nvarchar(10),
    publish bit
)

create table cs111
(
    id int identity(1,1) primary key,
    studentId int foreign key references student(student_ID) on delete set null on update cascade,
    assignment float,
    practical float,
    midterm float,
    final float,
    instructorID int foreign key references instructor(instructor_ID) on delete set null on update cascade,
    survey nvarchar(15)
)

create table pl221
(
    id int identity(1,1) primary key,
    studentId int foreign key references student(student_ID) on delete set null on update cascade,
    assignment float,
    practical float,
    midterm float,
    final float,
    instructorID int foreign key references instructor(instructor_ID) on delete set null on update cascade,
    survey nvarchar(15)
)

create table db221
(
    id int identity(1,1) primary key,
    studentId int foreign key references student(student_ID) on delete set null on update cascade,
    assignment float,
    practical float,
    midterm float,
    final float,
    instructorID int foreign key references instructor(instructor_ID) on delete set null on update cascade,
    survey nvarchar(15)
)

create table or231
(
    id int identity(1,1) primary key,
    studentId int foreign key references student(student_ID) on delete set null on update cascade,
    assignment float,
    practical float,
    midterm float,
    final float,
    instructorID int foreign key references instructor(instructor_ID) on delete set null on update cascade,
    survey nvarchar(15)
)

create table dc241
(
    id int identity(1,1) primary key,
    studentId int foreign key references student(student_ID) on delete set null on update cascade,
    assignment float,
    practical float,
    midterm float,
    final float,
    instructorID int foreign key references instructor(instructor_ID) on delete set null on update cascade,
    survey nvarchar(15)
)

create table cs214
(
    id int identity(1,1) primary key,
    studentId int foreign key references student(student_ID) on delete set null on update cascade,
    assignment float,
    practical float,
    midterm float,
    final float,
    instructorID int foreign key references instructor(instructor_ID) on delete set null on update cascade,
    survey nvarchar(15)
)

create table ld361
(
    id int identity(1,1) primary key,
    studentId int foreign key references student(student_ID) on delete set null on update cascade,
    assignment float,
    practical float,
    midterm float,
    final float,
    instructorID int foreign key references instructor(instructor_ID) on delete set null on update cascade,
    survey nvarchar(15)
)
create table cs316
(
    id int identity(1,1) primary key,
    studentId int foreign key references student(student_ID) on delete set null on update cascade,
    assignment float,
    practical float,
    midterm float,
    final float,
    instructorID int foreign key references instructor(instructor_ID) on delete set null on update cascade,
    survey nvarchar(15)
)

create table it431
(
    id int identity(1,1) primary key,
    studentId int foreign key references student(student_ID) on delete set null on update cascade,
    assignment float,
    practical float,
    midterm float,
    final float,
    instructorID int foreign key references instructor(instructor_ID) on delete set null on update cascade,
    survey nvarchar(15)
)

create table cs419
(
    id int identity(1,1) primary key,
    studentId int foreign key references student(student_ID) on delete set null on update cascade,
    assignment float,
    practical float,
    midterm float,
    final float,
    instructorID int foreign key references instructor(instructor_ID) on delete set null on update cascade,
    survey nvarchar(15)
)


ALTER TABLE pl221
    ADD total AS pl221.assignment + pl221.final + pl221.midterm + pl221.practical PERSISTED

ALTER TABLE cs214
    ADD total AS cs214.assignment + cs214.final + cs214.midterm + cs214.practical PERSISTED

ALTER TABLE ld361
    ADD total AS ld361.assignment + ld361.final + ld361.midterm + ld361.practical PERSISTED

ALTER TABLE dc241
    ADD total AS dc241.assignment + dc241.final + dc241.midterm + dc241.practical PERSISTED

ALTER TABLE or231
    ADD total AS or231.assignment + or231.final + or231.midterm + or231.practical PERSISTED

ALTER TABLE db221
    ADD total AS db221.assignment + db221.final + db221.midterm + db221.practical PERSISTED

ALTER TABLE it431
    ADD total AS it431.assignment + it431.final + it431.midterm + it431.practical PERSISTED

ALTER TABLE cs419
    ADD total AS cs419.assignment + cs419.final + cs419.midterm + cs419.practical PERSISTED

ALTER TABLE cs111
    ADD total AS cs111.assignment + cs111.final + cs111.midterm + cs111.practical PERSISTED

ALTER TABLE cs316
    ADD total AS cs316.assignment + cs316.final + cs316.midterm + cs316.practical PERSISTED


use courseManagementSystem

INSERT INTO course (nameOfCourse,courseCode,startDate,endDate,daysOfCourse,numberOfHours,price,room,publish)
VALUES('introToCS','cs111','2020-10-17','2021-01-12',90,3,1000,'R2',1)

INSERT INTO course (nameOfCourse,courseCode,startDate,endDate,daysOfCourse,numberOfHours,price,room,publish)
VALUES('DataStruct','cs214','2020-10-16','2021-01-12',90,3,1200,'H4',1)

INSERT INTO course (nameOfCourse,courseCode,startDate,endDate,daysOfCourse,numberOfHours,price,room,publish)
VALUES('Algorithm','cs316','2020-10-21','2021-01-12',90,3,1200,'H1',1)

INSERT INTO course (nameOfCourse,courseCode,startDate,endDate,daysOfCourse,numberOfHours,price,room,publish)
VALUES('Compilers','cs419','2020-10-23','2021-01-12',90,2,800,'H5',1)

INSERT INTO course (nameOfCourse,courseCode,startDate,endDate,daysOfCourse,numberOfHours,price,room,publish)
VALUES('dataBase','db221','2020-10-18','2021-01-12',90,3,1100,'R3',1)

INSERT INTO course (nameOfCourse,courseCode,startDate,endDate,daysOfCourse,numberOfHours,price,room,publish)
VALUES('DC','dc241','2020-10-17','2021-01-23',90,2,700,'R5',1)

INSERT INTO course (nameOfCourse,courseCode,startDate,endDate,daysOfCourse,numberOfHours,price,room,publish)
VALUES('VR','it431','2020-10-18','2021-01-18',80,2,850,'R4',1)

INSERT INTO course (nameOfCourse,courseCode,startDate,endDate,daysOfCourse,numberOfHours,price,room,publish)
VALUES('LD','ld361','2020-10-23','2021-01-23',80,2,750,'H2',1)

INSERT INTO course (nameOfCourse,courseCode,startDate,endDate,daysOfCourse,numberOfHours,price,room,publish)
VALUES('OR','or231','2020-10-20','2021-01-20',90,3,900,'H3',1)

INSERT INTO course (nameOfCourse,courseCode,startDate,endDate,daysOfCourse,numberOfHours,price,room,publish)
VALUES('PL2','pl221','2020-10-19','2021-01-16',90,3,1200,'H5',1)

INSERT INTO course (nameOfCourse,courseCode,startDate,endDate,daysOfCourse,numberOfHours,price,room,publish)
VALUES('PL1','pl121','2020-10-15','2021-01-19',90,3,1000,'H4',1)
