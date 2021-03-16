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

