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
select * from time_table;

show timezone;

-- https://www.postgresql.org/docs/8.1/datetime-keywords.html

-- CET	+01:00	Central European Time
-- Europe/Helsinki UTC+2

set timezone='Europe/Helsinki';
select now();
create database default_database;

alter database default_database set timezone = 'Europe/Helsinki';

