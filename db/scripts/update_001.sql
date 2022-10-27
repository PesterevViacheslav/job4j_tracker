CREATE TABLE IF NOT EXISTS ITEM (id SERIAL PRIMARY KEY not null,
                                 item_name TEXT not null,
                                 item_description TEXT,
                                 created TIMESTAMP not null default now()
                                 );