-- Instance timezone: log_timezone = 'Europe/Helsinki'

create database gmt_database;

alter database gmt_database set timezone = 'GMT';

CREATE TABLE time_table
(
    dt    date,
    tm    time without time zone,
    tm_tz time with time zone,
    ts    TIMESTAMP without time zone,
    ts_tz TIMESTAMP with time zone
);

insert into time_table (dt, tm, tm_tz, ts, ts_tz) values (now(), now(), now(), now(), now());
insert into time_table (tm) values (now());
select * from time_table;
select tm from time_table;
delete from time_table;

show timezone;

-- https://www.postgresql.org/docs/8.1/datetime-keywords.html

-- CET	+01:00	Central European Time
-- Europe/Helsinki UTC+2

set timezone='Europe/Helsinki';
set timezone='GMT';
select now();
create database default_database;

alter database default_database set timezone = 'Europe/Helsinki';

/*

The PreparedStatement setTimestamp Javadoc states that:

    With a Calendar object, the driver can calculate the timestamp taking into account a custom timezone.
    If no Calendar object is specified, the driver uses the default timezone, which is that of the virtual machine running the application.

While for the ResultSet getTimestamp method it says that:

    This method uses the given calendar to construct an appropriate millisecond value for the timestamp if the underlying database does not store timezone information.

 */

