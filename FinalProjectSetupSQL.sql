-----------------------------------------------------
-- Set-up Script

--Un-comment to run certain sections

/*
CREATE TABLE IF NOT EXISTS account (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(64) UNIQUE NOT NULL,
    user_password VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    firstname VARCHAR(64),
    lastname VARCHAR(64),
    is_admin BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS test (
    test_id SERIAL PRIMARY KEY,
    title VARCHAR(128) NOT NULL,
    created_by INT NOT NULL,
    date_created DATE NOT NULL DEFAULT CURRENT_DATE,
    FOREIGN KEY (created_by) REFERENCES account (user_id)
);

CREATE TABLE IF NOT EXISTS question (
    question_id SERIAL PRIMARY KEY,
    question_text TEXT NOT NULL,
    answer_type VARCHAR(32) NOT NULL	-- ex. "multiple_choice", "open_response"
);

CREATE TABLE IF NOT EXISTS answer_option (
    option_id SERIAL PRIMARY KEY,
    question_id INT NOT NULL,
    option_label VARCHAR(16),	-- ex. "A", "B", "C"
    option_text TEXT NOT NULL,
    is_correct BOOLEAN NOT NULL DEFAULT FALSE,
    FOREIGN KEY (question_id) REFERENCES question (question_id)
);

CREATE TABLE IF NOT EXISTS test_question (
    test_id INT NOT NULL,
    question_id INT NOT NULL,
    points INT NOT NULL DEFAULT 0,
    PRIMARY KEY (test_id, question_id),
    FOREIGN KEY (test_id) REFERENCES test (test_id),
    FOREIGN KEY (question_id) REFERENCES question (question_id)
);

CREATE TABLE IF NOT EXISTS test_assignment (
    user_id INT NOT NULL,
    test_id INT NOT NULL,
    date_assigned DATE NOT NULL DEFAULT CURRENT_DATE,
    due_date DATE,
    PRIMARY KEY (user_id, test_id),
    FOREIGN KEY (user_id) REFERENCES account (user_id),
    FOREIGN KEY (test_id) REFERENCES test (test_id)
);

CREATE TABLE IF NOT EXISTS test_taken (
    user_id INT NOT NULL,
    test_id INT NOT NULL,
    date_taken DATE DEFAULT CURRENT_DATE,
    time_taken INT,	-- Minutes
    overall_score NUMERIC(4,1),
    PRIMARY KEY (user_id, test_id),
    FOREIGN KEY (user_id) REFERENCES account (user_id),
    FOREIGN KEY (test_id) REFERENCES test (test_id)
);



-----------------------------------------------------
-- Test Data


INSERT INTO account (username, user_password, email, firstname, is_admin)
VALUES
('admin', 'password123', 'admin@test.com', 'Admin', TRUE);

INSERT INTO account (username, user_password, email, firstname, lastname, is_admin)
VALUES
('jsmith', 'test123', 'jsmith@test.com', 'John', 'Smith', FALSE),
('mjohnson', 'pass123', 'mj@test.com', 'Mary', 'Johnson', FALSE);

INSERT INTO test (title, created_by)
VALUES
('Basic Math Test', 1),
('Science Quiz', 1);

INSERT INTO question (question_text, answer_type)
VALUES
('What is 2 + 2?', 'multiple_choice'),
('Water freezes at what temperature?', 'multiple_choice');

-- Answer options for question 1
INSERT INTO answer_option (question_id, option_label, option_text, is_correct)
VALUES
(1, 'A', '3', FALSE),
(1, 'B', '4', TRUE),
(1, 'C', '5', FALSE);

-- Answer options for question 2
INSERT INTO answer_option (question_id, option_label, option_text, is_correct)
VALUES
(2, 'A', '0 degrees', TRUE),
(2, 'B', '10 degrees', FALSE),
(2, 'C', '100 degrees', FALSE);

INSERT INTO test_question (test_id, question_id, points)
VALUES
(1, 1, 100),
(2, 2, 5);

INSERT INTO test_assignment (user_id, test_id, due_date)
VALUES
(2, 1, '2025-12-30'),
(2, 2, '2025-12-25'),
(3, 2, '2025-12-30');

INSERT INTO test_taken (user_id, test_id, time_taken, overall_score)
VALUES
(2, 1, 5, 100);



-----------------------------------------------------
-- Test View



CREATE VIEW view_assigned_tests AS
SELECT 
    u.user_id,
    u.firstname,
    u.lastname,
    t.test_id,
    t.title AS test_title,
    ta.date_assigned,
    ta.due_date
FROM test_assignment ta
JOIN account u ON ta.user_id = u.user_id
JOIN test t ON ta.test_id = t.test_id;

*/

SELECT * FROM account;

