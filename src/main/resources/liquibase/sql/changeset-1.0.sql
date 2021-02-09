create table cart_records
(
    cart_record_id              varchar(36) unique,
    cart_id                     varchar(36) null,
    product_type_id             varchar(36) null,
    count                       int         null,
    create_date_time_utc        timestamp   null,
    update_date_time_utc        timestamp   null,
    delete_info_id              varchar(36) null,
    inactivate_info_id          varchar(36) null,
    auditable_status            varchar(36) null,
    create_session_token_id     varchar(36) null,
    update_session_token_id     varchar(36) null,
    primary key (cart_record_id)
);

create table products
(
    product_id                  varchar(36) unique,
    product_type_id             varchar(36) null,
    product_type_category_id    varchar(36) null,
    sale_id                     varchar(36) null,
    location                    varchar(36) null,
    create_date_time_utc        timestamp   null,
    update_date_time_utc        timestamp   null,
    delete_info_id              varchar(36) null,
    inactivate_info_id          varchar(36) null,
    created_by_admin            varchar(36) null,
    updated_by_admin            varchar(36) null,
    auditable_status            varchar(12) null,
    create_session_token_id     varchar(36) null,
    update_session_token_id     varchar(36) null,
    primary key (product_id)
);

create table product_types
(
    product_type_id             varchar(36)     unique,
    product_type_category_id    varchar(36)     null,
    sale_id                     varchar(36)     null,
    name                        varchar(36)     null,
    price                       decimal(19, 2)  null,
    available_flag              boolean         null,
    create_date_time_utc        timestamp       null,
    update_date_time_utc        timestamp       null,
    delete_info_id              varchar(36)     null,
    inactivate_info_id          varchar(36)     null,
    created_by_admin            varchar(36)     null,
    updated_by_admin            varchar(36)     null,
    auditable_status            varchar(12)     null,
    create_session_token_id     varchar(36)     null,
    update_session_token_id     varchar(36)     null,
    primary key (product_type_id)
);

create table product_type_categories
(
    product_type_category_id    varchar(36) unique,
    category_name               varchar(36) null,
    create_date_time_utc        timestamp   null,
    update_date_time_utc        timestamp   null,
    delete_info_id              varchar(36) null,
    inactivate_info_id          varchar(36) null,
    created_by_admin            varchar(36) null,
    updated_by_admin            varchar(36) null,
    auditable_status            varchar(12) null,
    create_session_token_id     varchar(36) null,
    update_session_token_id     varchar(36) null,
    primary key (product_type_category_id)
);

create table roles
(
    role_id varchar(36) unique,
    name    varchar(36) null,
    primary key (role_id)
);


create table sales
(
    sale_id                     varchar(36) unique,
    description                 varchar(36) null,
    percent_value               integer     null,
    create_date_time_utc        timestamp   null,
    update_date_time_utc        timestamp   null,
    delete_info_id              varchar(36) null,
    inactivate_info_id          varchar(36) null,
    created_by_admin            varchar(36) null,
    updated_by_admin            varchar(36) null,
    auditable_status            varchar(12) null,
    create_session_token_id     varchar(36) null,
    update_session_token_id     varchar(36) null,
    primary key (sale_id)
);

create table users
(
    user_id                 varchar(36)  unique,
    cart_id                 varchar(36)  null,
    name                    varchar(36)  null,
    password                varchar(128) null,
    email                   varchar(36)  null,
    create_date_time_utc    timestamp    null,
    update_date_time_utc    timestamp    null,
    delete_info_id          varchar(36)  null,
    inactivate_info_id      varchar(36)  null,
    auditable_status        varchar(12)  null,
    create_session_token_id varchar(36)  null,
    update_session_token_id varchar(36)  null,
    primary key (user_id)
);

create table user_roles
(
    role_id varchar(36)  null,
    user_id varchar(36)  null
);