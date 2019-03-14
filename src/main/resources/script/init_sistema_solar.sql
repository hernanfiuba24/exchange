create schema sistemaSolar;
use sistemaSolar;

create table if not exists `sistema_solar` (
	`id` int(11) not null,
	`day` int(11) not null,
	`name` varchar(250) not null default '',
	primary key (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 COMMENT='Table with data of solar system';

insert into sistema_solar values (1, 1, 'via lactea');
insert into sistema_solar values (2, 1, 'andromeda');