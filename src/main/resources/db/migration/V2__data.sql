-- Test data --

INSERT INTO public.team (id, name)
values
  ('d607fd70-69c3-11e9-a923-1681be663d3e', 'team1'),
  ('d6080040-69c3-11e9-a923-1681be663d3e', 'team2');

INSERT INTO public."user" (id, email, password, group_type, team_id, "position")
VALUES
('6f710d64-69cc-11e9-a923-1681be663d3e', 'user2@user.com',
 '$2a$10$3fVSHfe0w8SC769JjKSbaOONyoBu9X6/V6BlGM1p4K5rGgfm3lLfK', 'USER', 'd607fd70-69c3-11e9-a923-1681be663d3e',
 'Software Engineer'),
('6f710fee-69cc-11e9-a923-1681be663d3e', 'user3@user.com',
 '$2a$10$THsBRnOa64/6qAw2DsCvcutheKFc2PtAeegvfS15AIn4IwMbydDya', 'USER', 'd607fd70-69c3-11e9-a923-1681be663d3e',
 'Team Leader'),
('6f71114c-69cc-11e9-a923-1681be663d3e', 'user11@admin.com',
 '$2a$10$6yAGvN8HbMjVCqIjpl9ksey7USpI9TARL9aCNHx.pAYBi0DyE5ZO2', 'ADMIN', 'd6080040-69c3-11e9-a923-1681be663d3e',
 'Software Engineer'),
('6f711282-69cc-11e9-a923-1681be663d3e', 'user12@user.com',
 '$2a$10$FSbLYUZv/wD.HPpHeg3iMuNlVKfyZLtxAgUBB1hishvzwxdi8OVZu', 'USER', 'd607fd70-69c3-11e9-a923-1681be663d3e',
 'Software Engineer'),
('6f7113b8-69cc-11e9-a923-1681be663d3e', 'user13@user.com',
 '$2a$10$y/6C0ZRu2HAEe2jS5mO7eO8zGnH5DEN2gJXFjUD9N8H6jcLZaXLOq', 'USER', 'd6080040-69c3-11e9-a923-1681be663d3e',
 'Software Engineer'),
('6f7114e4-69cc-11e9-a923-1681be663d3e', 'user14@user.com',
 '$2a$10$fBkAKf0NzdHwyjxczjeDkuxVc.1g/fFt2JmjsNUltORpOOT9GRvaq', 'USER', 'd6080040-69c3-11e9-a923-1681be663d3e',
 'Quality Assurance Engineer');

INSERT INTO public.equipment_group(id,name)
values ('23f1e05a-69ce-11e9-a923-1681be663d3e', 'PC'),
       ('23f1e33e-69ce-11e9-a923-1681be663d3e', 'Laptop'),
       ('23f1e74e-69ce-11e9-a923-1681be663d3e', 'Screen'),
       ('23f1e8b6-69ce-11e9-a923-1681be663d3e', 'Accessories');

INSERT INTO public.equipment (id, serial_number, model, equipment_group_id,
                              checklist_jamcloud_enrollment,
                              checklist_confirmation_of_receipt, purchase_timestamp, qr_code, invoice, price)
VALUES
('f823c6dc-69cd-11e9-a923-1681be663d3e', 'serial_number_1', 'MacBook Pro 123', '23f1e33e-69ce-11e9-a923-1681be663d3e',
 'checklist_jamcloud_enrollment_1', 'checklist_confirmation_of_receipt_1', '2019-02-28T15:57:17+00:00', 'qr_code_1',
 'www.invoice1.com', 12999.00),
('8f900efe-69ce-11e9-a923-1681be663d3e', 'serial_number_2', 'Dell P2213', '23f1e74e-69ce-11e9-a923-1681be663d3e',
 'checklist_jamcloud_enrollment_2', 'checklist_confirmation_of_receipt_2', '2019-02-28T15:57:17+00:00', 'qr_code_2',
 'www.invoice2.com', 1099.00);

INSERT INTO public.equipment_ownership (id, user_id, equipment_id, assignment_timestamp, dismission_timestamp)
VALUES
('cd1b79cc-69cc-11e9-a923-1681be663d3e', '6f7114e4-69cc-11e9-a923-1681be663d3e', '8f900efe-69ce-11e9-a923-1681be663d3e',
 '2019-02-28T15:57:17+00:00', '2019-03-28T15:57:17+00:00'),
('cd1b7c60-69cc-11e9-a923-1681be663d3e', '6f710d64-69cc-11e9-a923-1681be663d3e', 'f823c6dc-69cd-11e9-a923-1681be663d3e',
 '2019-03-28T15:57:17+00:00', null),
('8f90105c-69ce-11e9-a923-1681be663d3e', '6f710d64-69cc-11e9-a923-1681be663d3e', 'f823c6dc-69cd-11e9-a923-1681be663d3e',
 '2019-03-28T15:57:17+00:00', null);

INSERT INTO public.repair (id, equipment_id, description, price) VALUES
  ('3ad74384-69d1-11e9-a923-1681be663d3e', '8f900efe-69ce-11e9-a923-1681be663d3e', 'Repair description', 1399);
