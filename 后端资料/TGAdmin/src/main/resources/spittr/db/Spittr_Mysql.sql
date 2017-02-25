/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/12/31 10:37:39                          */
/*==============================================================*/


drop table if exists S_MusicAblumRelationship;

drop table if exists S_MusicCategory;

drop table if exists S_albums;

drop table if exists S_authority;

drop table if exists S_listendRec;

drop table if exists S_singer;

drop table if exists S_song;

drop table if exists S_type;

drop table if exists S_userComment;

drop table if exists S_userFavAlbum;

drop table if exists S_userFavSong;

drop table if exists S_users;

drop table if exists adminUser;

/*==============================================================*/
/* Table: S_MusicAblumRelationship                              */
/*==============================================================*/
create table S_MusicAblumRelationship
(
   s_aid                varchar(50) not null,
   s_songid             varchar(40) not null,
   primary key (s_aid, s_songid)
);

/*==============================================================*/
/* Table: S_MusicCategory                                       */
/*==============================================================*/
create table S_MusicCategory
(
   s_songid             varchar(40) not null,
   s_stid               varchar(50) not null,
   primary key (s_songid, s_stid)
);

/*==============================================================*/
/* Table: S_albums                                              */
/*==============================================================*/
create table S_albums
(
   s_aid                varchar(50) not null,
   s_singerid           varchar(50) not null,
   s_atitle             varchar(40) not null,
   s_apubTime           date not null,
   s_adescp             varchar(500),
   s_avisRec            int,
   primary key (s_aid)
);

/*==============================================================*/
/* Table: S_authority                                           */
/*==============================================================*/
create table S_authority
(
   s_authid             int not null,
   s_auleavel           varchar(10) not null,
   s_whodid             varchar(50) not null,
   primary key (s_authid)
);

/*==============================================================*/
/* Table: S_listendRec                                          */
/*==============================================================*/
create table S_listendRec
(
   s_userid             varchar(50) not null,
   s_songid             varchar(40) not null,
   s_listendRecNum      int,
   s_userLisetenenDate  date,
   primary key (s_userid, s_songid)
);

/*==============================================================*/
/* Table: S_singer                                              */
/*==============================================================*/
create table S_singer
(
   s_singerid           varchar(50) not null,
   s_sname              varchar(40) not null,
   s_sgender            int not null,
   s_singerdescp        varchar(500),
   s_svisi              int,
   s_spic               varchar(200),
   primary key (s_singerid)
);

/*==============================================================*/
/* Table: S_song                                                */
/*==============================================================*/
create table S_song
(
   s_songid             varchar(40) not null,
   s_singerid           varchar(50) not null,
   s_title              varchar(40) not null,
   s_surl               varchar(400) not null,
   s_visited            int,
   s_visitedTotal       int,
   s_dloaded            int,
   s_scover             varchar(400),
   s_smv                varchar(400),
   s_songdescp          varchar(500),
   primary key (s_songid)
);

/*==============================================================*/
/* Table: S_type                                                */
/*==============================================================*/
create table S_type
(
   s_stid               varchar(50) not null,
   s_sttitle            varchar(40) not null,
   primary key (s_stid)
);

/*==============================================================*/
/* Table: S_userComment                                         */
/*==============================================================*/
create table S_userComment
(
   s_userid             varchar(50) not null,
   s_songid             varchar(40) not null,
   s_userCommContent    varchar(200) not null,
   s_userCommDate       date,
   primary key (s_userid, s_songid)
);

/*==============================================================*/
/* Table: S_userFavAlbum                                        */
/*==============================================================*/
create table S_userFavAlbum
(
   s_aid                varchar(50) not null,
   s_userid             varchar(50) not null,
    ’≤ÿs_uFavAlbumDate    date not null,
   primary key (s_aid, s_userid)
);

/*==============================================================*/
/* Table: S_userFavSong                                         */
/*==============================================================*/
create table S_userFavSong
(
   s_songid             varchar(40) not null,
   s_userid             varchar(50) not null,
   s_uFavSongDate       date not null,
   primary key (s_songid, s_userid)
);

/*==============================================================*/
/* Table: S_users                                               */
/*==============================================================*/
create table S_users
(
   s_userid             varchar(50) not null,
   s_uaccount           varchar(50) not null,
   s_upwdsalt           varchar(100) not null,
   s_upwd               varchar(40) not null,
   s_unickname          varchar(50),
   s_uemail             varchar(50),
   s_unone              varchar(10),
   primary key (s_userid)
);

/*==============================================================*/
/* Table: adminUser                                             */
/*==============================================================*/
create table adminUser
(
   s_adminid            varchar(50) not null,
   s_authid             int not null,
   s_adminaccount       varchar(60) not null,
   s_adminPwd           varchar(50) not null,
   s_adminLogininDate   date,
   primary key (s_adminid)
);

alter table S_MusicAblumRelationship add constraint FK_musicAlbumRelationship foreign key (s_aid)
      references S_albums (s_aid) on delete restrict on update restrict;

alter table S_MusicAblumRelationship add constraint FK_musicAlbumRelationship2 foreign key (s_songid)
      references S_song (s_songid) on delete restrict on update restrict;

alter table S_MusicCategory add constraint FK_S_songcatagory1 foreign key (s_songid)
      references S_song (s_songid) on delete restrict on update restrict;

alter table S_MusicCategory add constraint FK_S_songcatagory2 foreign key (s_stid)
      references S_type (s_stid) on delete restrict on update restrict;

alter table S_albums add constraint FK_S_sinngerPublishAlbum foreign key (s_singerid)
      references S_singer (s_singerid) on delete restrict on update restrict;

alter table S_listendRec add constraint FK_S_listendRec foreign key (s_userid)
      references S_users (s_userid) on delete restrict on update restrict;

alter table S_listendRec add constraint FK_S_listendRec2 foreign key (s_songid)
      references S_song (s_songid) on delete restrict on update restrict;

alter table S_song add constraint FK_s_singerPublishMusic foreign key (s_singerid)
      references S_singer (s_singerid) on delete restrict on update restrict;

alter table S_userComment add constraint FK_S_userComment foreign key (s_userid)
      references S_users (s_userid) on delete restrict on update restrict;

alter table S_userComment add constraint FK_S_userComment2 foreign key (s_songid)
      references S_song (s_songid) on delete restrict on update restrict;

alter table S_userFavAlbum add constraint FK_S_userFavAlbum foreign key (s_aid)
      references S_albums (s_aid) on delete restrict on update restrict;

alter table S_userFavAlbum add constraint FK_S_userFavAlbum2 foreign key (s_userid)
      references S_users (s_userid) on delete restrict on update restrict;

alter table S_userFavSong add constraint FK_S_userFavSong foreign key (s_songid)
      references S_song (s_songid) on delete restrict on update restrict;

alter table S_userFavSong add constraint FK_S_userFavSong2 foreign key (s_userid)
      references S_users (s_userid) on delete restrict on update restrict;

alter table adminUser add constraint FK_S_adminPermission foreign key (s_authid)
      references S_authority (s_authid) on delete restrict on update restrict;

