CREATE TABLE IF NOT EXISTS usuario (
    id       SERIAL PRIMARY KEY,
    nome     VARCHAR(100) NOT NULL,
    email    VARCHAR(100) NOT NULL UNIQUE,
    senha    VARCHAR(64)  NOT NULL
);

CREATE TABLE IF NOT EXISTS video (
    id              SERIAL PRIMARY KEY,
    titulo          VARCHAR(200) NOT NULL,
    descricao       TEXT,
    anolancamento   INT,
    tipo            VARCHAR(10) NOT NULL,
    duracao         INT,
    temporadas      INT
);

CREATE TABLE IF NOT EXISTS curtida (
    usuario_id  INT REFERENCES usuario(id) ON DELETE CASCADE,
    video_id    INT REFERENCES video(id) ON DELETE CASCADE,
    PRIMARY KEY (usuario_id, video_id)
);

CREATE TABLE IF NOT EXISTS favorito (
    usuario_id  INT REFERENCES usuario(id) ON DELETE CASCADE,
    video_id    INT REFERENCES video(id) ON DELETE CASCADE,
    PRIMARY KEY (usuario_id, video_id)
);

CREATE TABLE IF NOT EXISTS lista_reproducao (
    id          SERIAL PRIMARY KEY,
    nome        VARCHAR(100) NOT NULL,
    usuario_id  INT REFERENCES usuario(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS lista_video (
    lista_id  INT REFERENCES lista_reproducao(id) ON DELETE CASCADE,
    video_id  INT REFERENCES video(id) ON DELETE CASCADE,
    PRIMARY KEY (lista_id, video_id)
);




INSERT INTO video (titulo, descricao, anolancamento, tipo, duracao, temporadas) VALUES
('O Poderoso Chefão',
 'A história da família Corleone, uma das mais poderosas famílias da máfia americana.',
 1972, 'filme', 175, NULL),

('Interestelar',
 'Astronautas viajam por um buraco de minhoca em busca de um novo lar.',
 2014, 'filme', 169, NULL),

('Parasita',
 'Uma família pobre se infiltra na vida de uma família rica.',
 2019, 'filme', 132, NULL),

('Matrix',
 'Um hacker descobre que vive em uma simulação criada por máquinas.',
 1999, 'filme', 136, NULL),

('O Senhor dos Anéis: A Sociedade do Anel',
 'Frodo embarca em uma jornada para destruir um anel mágico.',
 2001, 'filme', 178, NULL),

('Vingadores: Ultimato',
 'Os Vingadores tentam reverter as ações de Thanos.',
 2019, 'filme', 181, NULL),

('A Origem',
 'Um ladrão invade sonhos para implantar ideias.',
 2010, 'filme', 148, NULL),

('Coringa',
 'A origem de Arthur Fleck, o Coringa.',
 2019, 'filme', 122, NULL),

('Breaking Bad',
 'Professor de química entra no tráfico de drogas.',
 2008, 'serie', NULL, 5),

('Stranger Things',
 'Crianças enfrentam forças sobrenaturais em Hawkins.',
 2016, 'serie', NULL, 4),

('Game of Thrones',
 'Famílias lutam pelo Trono de Ferro.',
 2011, 'serie', NULL, 8),

('The Last of Us',
 'Joel e Ellie sobrevivem após uma pandemia.',
 2023, 'serie', NULL, 2),

('Dark',
 'Mistério envolvendo viagem no tempo.',
 2017, 'serie', NULL, 3),

('Peaky Blinders',
 'Família Shelby domina o submundo de Birmingham.',
 2013, 'serie', NULL, 6);




DELETE FROM video a
USING video b
WHERE a.id > b.id
AND a.titulo = b.titulo
AND a.anolancamento = b.anolancamento;




ALTER TABLE video
ADD CONSTRAINT unique_video
UNIQUE (titulo, anolancamento);