create table  sys_user
(
       userId            INTEGER /*auto_increment*/ not null,
       userName          VARCHAR(32),
       loginName         VARCHAR(32),
       loginPwd          VARCHAR(255),
       loginSalt         VARCHAR(255),
       email             VARCHAR(64),
       phone             VARCHAR(32),
       loginIp           VARCHAR(64),
       loginTime         DATETIME,
       state             INTEGER(1),
       createTime        DATETIME,
       createId          INTEGER
);
alter  table sys_user
       add constraint PK_sys_user_userId primary key (userId);
create unique index IDXU_sys_user_loginName on sys_user(loginName);

create table  sys_role
(
       roleId            INTEGER /*auto_increment*/ not null,
       roleCode          VARCHAR(32),
       roleName          VARCHAR(32),
       description       VARCHAR(255),
       seq               INTEGER,
       state             INTEGER(1),
       createTime        DATETIME,
       createId          INTEGER
);
alter  table sys_role
       add constraint PK_sys_role_roleId primary key (roleId);
create unique index IDXU_sys_role_roleCode on sys_role(roleCode);

create table  sys_user_role
(
       userRoleId        INTEGER /*auto_increment*/ not null,
       userId            INTEGER,
       roleId            INTEGER
);
alter  table sys_user_role
       add constraint PK_sys_user_role_userRoleId primary key (userRoleId);

create table  sys_role_resource
(
       roleResId         INTEGER not null,
       roleId            INTEGER,
       resId             INTEGER
);
alter  table sys_role_resource
       add constraint PK_sys_role_rce_roleResId primary key (roleResId);

create table  sys_function
(
       resCode           VARCHAR(32),
       funcCode          VARCHAR(32),
       funcName          VARCHAR(32),
       funcUrl           VARCHAR(128)
);

create table  sys_resource
(
       resId             INTEGER /*auto_increment*/ not null,
       resType           VARCHAR(32),
       resCode           VARCHAR(32),
       resName           VARCHAR(32),
       resPid            INTEGER,
       resLevel          INTEGER(1),
       resIcon           VARCHAR(32),
       seq               INTEGER,
       state             INTEGER(1),
       createTime        DATETIME,
       createId          INTEGER
);
alter  table sys_resource
       add constraint PK_sys_resource_resId primary key (resId);
create unique index IDXU_sys_resource_resCode on sys_resource(resCode);

alter  table sys_user_role
       add constraint FK_sys_user_role_userId foreign key (userId)
       references sys_user(userId);
alter  table sys_user_role
       add constraint FK_sys_user_role_roleId foreign key (roleId)
       references sys_role(roleId);

alter  table sys_role_resource
       add constraint FK_sys_role_resource_roleId foreign key (roleId)
       references sys_role(roleId);
alter  table sys_role_resource
       add constraint FK_sys_role_resource_resId foreign key (resId)
       references sys_resource(resId);

alter  table sys_function
       add constraint FK_sys_function_resCode foreign key (resCode)
       references sys_resource(resCode);

