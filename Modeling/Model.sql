/* to realize te relationship and the modeling */



create database SocialNetwork;

/*Users table, an integer is selected like the primary key*/
create table users(

    user_id int(11) PRIMARY KEY auto_increment,
    names varchar(20) not null,
    last_names varchar(20) not null,
    phone_number varchar(20) not null,
    date_birth date not null,
    gender varchar(20) not null,
    email varchar(50) not null,
    password varchar(100) not null
);


/*
the conditional is between who is follows who ?
 */


create table following(
    
    user_id_follower int(11),
    user_id_followed int(11),
    foreign key(user_id_follower) references users(user_id),
    foreign key(user_id_follower) references users(user_id)

);






