CREATE UNIQUE INDEX events_slug_key ON tb_events(slug);
CREATE UNIQUE INDEX attendees_event_id_email_key ON tb_attendees (event_id, email);
CREATE UNIQUE INDEX check_ins_attendee_id_key ON tb_checkins(attendee_id);