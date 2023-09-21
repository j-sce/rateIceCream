insert into producers(name)
values ('Rīgas Piena Kombināts A/S');

insert into producers(name)
values ('Avenei SIA');

insert into producers(name)
values ('PJSC Zhytomyr Butter Plant');

insert into producers(name)
values ('Unilever Poland S.A.');

insert into producers(name)
values ('Zielona Budka (Mielec) Sp. z o.o.');

insert into producers(name)
values ('Producer1');

insert into producers(name)
values ('Producer2');


insert into ice_creams(name, producer, barcode)
values ('Pols šokolādes vafeļu glāzītē 120ml', 'Rīgas Piena Kombināts A/S', '4750025896114');

insert into ice_creams(name, producer, barcode)
values ('Ekselence ar valriekstiem kļavu sīrupu 1l', 'Rīgas Piena Kombināts A/S', '4750025570908');

insert into ice_creams(name, producer, barcode)
values ('Avenei avokado - ananasu 80ml', 'Avenei SIA', '4751030760025');

insert into ice_creams(name, producer, barcode)
values ('Eskimos plombīra baltās šokolādes glazūrā 110ml', 'PJSC Zhytomyr Butter Plant', '4823097806302');

insert into ice_creams(name, producer, barcode)
values ('Karlsons 100ml', 'Rīgas Piena Kombināts A/S', '4750025570151');

insert into ice_creams(name, producer, barcode)
values ('Oreo uz kociņa 110ml', 'Zielona Budka (Mielec) Sp. z o.o.', '5900130033112');

insert into ice_creams(name, producer, barcode)
values ('Mājas konfekte gotiņa 120ml', 'Unilever Poland S.A.', '8711327301511');

insert into ice_creams(name, producer, barcode)
values ('Super Viva Rainbow 170ml', 'Unilever Poland S.A.', '8711327550711');

insert into ice_creams(name, producer, barcode)
values ('Sulas Jungle Pop ar apelsīnu limonādes garšu 60ml', 'Rīgas Piena Kombināts A/S', '4750025902365');

insert into ice_creams(name, producer, barcode)
values ('Magnum ar mandelēm 120ml', 'Unilever Poland S.A.', '8000920500224');

insert into ice_creams(name, producer, barcode)
values ('Pols vaniļas cepumā 140ml', 'Rīgas Piena Kombināts A/S', '4750025898736');


insert into roles (name)
values ('ADMIN');

insert into roles (name)
values ('USER');

insert into roles (name)
values ('STAFF');



INSERT INTO `users` (`username`, `password`, `enabled`) VALUES ('staff', '$2a$10$cTUErxQqYVyU2qmQGIktpup5chLEdhD2zpzNEyYqmxrHHJbSNDOG.', 1);
INSERT INTO `users` (`username`, `password`, `enabled`) VALUES ('user', '$2a$10$.tP2OH3dEG0zms7vek4ated5AiQ.EGkncii0OpCcGq4bckS9NOULu', 1);
INSERT INTO `users` (`username`, `password`, `enabled`) VALUES ('admin', '$2a$10$IqTJTjn39IU5.7sSCDQxzu3xug6z/LPU6IF0azE/8CkHCwYEnwBX.', 1);

INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (1, 3);
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (2, 2);
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (3, 1);