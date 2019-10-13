INSERT INTO formulas(id, image,  name, method) VALUES(1, 'https://www.bbcgoodfood.com/sites/default/files/user-collections/my-colelction-image/2015/12/recipe-image-legacy-id--890477_11.jpg', 'Gotowana parówka z musztardą', 'Ugotować parówkę, podawać z bułką i musztardą');
INSERT INTO formulas(id, name, method) VALUES (2, 'Green bean parsley pesto gnocchi', 'Bring a large pan of lightly salted water to the boil. Add the gnocchi and beans, and boil for 2-3 mins or until the gnocchi floats to the top of the pan.
Drain and toss the gnocchi and beans with the pesto, then divide between four bowls. Finish with a little extra shaved parmesan, if you like. ');
INSERT INTO formulas(id, name, method) VALUES  (3, 'Chicken noodle soup', 'Pour 900ml chicken or vegetable stock into a pan and add 1 boneless, skinless chicken breast, 1 tsp chopped root ginger and 1 finely chopped garlic clove.
Bring to the boil, then reduce the heat, partly cover and simmer for 20 mins, until the chicken is tender. Remove the chicken to a board and shred into bite-size pieces using a couple of forks.
Return the chicken to the stock with 50g rice or wheat noodles, 2 tbsp sweetcorn, 2-3  thinly sliced mushrooms, 1 shredded spring onion and 2 tsp soy sauce. Simmer for 3-4 mins until the noodles are tender.
Ladle into two bowls and scatter over the remaining shredded spring onion, mint or basil leaves and shredded chili if using. Serve with extra soy sauce for sprinkling.');

INSERT INTO likes(id, user, description,formula_id) VALUES (1, 'Skryty_parówkożerca', 'Szybka potrawa, możma się dobrze najeść !!', 1);
INSERT INTO likes(id, user, description,formula_id) VALUES (2, 'Kasia', 'Moja ulubiona potrawa z kuchni włoskiej. Mniam Mniam', 2);
INSERT INTO likes(id, user, description,formula_id) VALUES (3, 'Skryty_parówkożerca', 'Zupa dobra ale najepiej smakuje w zestawie z musztardą i gotowaną parówką', 3);
INSERT INTO likes(id, user, description,formula_id) VALUES (4, 'Skryty_parówkożerca', 'Dobrze smakuje w zestawie z musztardą i gotowaną parówką', 2);
INSERT INTO likes(id, user, description,formula_id) VALUES (5, 'Kasia', 'Skrytym parówkożercom mówimy NIE !!!', 2);
INSERT INTO likes(id, user, description,formula_id) VALUES (6, 'Hejter', 'To jest najlepszy przepis z tej marnej strony', 3);
INSERT INTO likes(id, user, description,formula_id) VALUES (7, 'Hejter', 'Przepisy bardzo przeciętne, nic z tego nie da się zjeść. Stronę należy zamknąć w ogóle', 1);


INSERT INTO ingredients(id, name) VALUES (1, 'Parówka');
INSERT INTO ingredients(id, name) VALUES (2, 'Musztarka');
INSERT INTO ingredients(id, name) VALUES (3, 'Makaron');
INSERT INTO ingredients(id, name) VALUES (4, 'Mąka');
INSERT INTO ingredients(id, name) VALUES (5, 'Groszek zielony');
INSERT INTO ingredients(id, name) VALUES (6, 'Bułka');
INSERT INTO ingredients(id, name) VALUES (7, 'Kurczak');
INSERT INTO ingredients(id, name) VALUES (8, 'Przyprawy');
INSERT INTO ingredients(id, name) VALUES (9, 'Grzyby suszone');

INSERT INTO INGREDIENTS_FORMULAS(INGREDIENTS_ID, FORMULAS_ID) VALUES(1,1);
INSERT INTO INGREDIENTS_FORMULAS(INGREDIENTS_ID, FORMULAS_ID) VALUES(2,1);
INSERT INTO INGREDIENTS_FORMULAS(INGREDIENTS_ID, FORMULAS_ID) VALUES(3,3);
INSERT INTO INGREDIENTS_FORMULAS(INGREDIENTS_ID, FORMULAS_ID) VALUES(4,2);
INSERT INTO INGREDIENTS_FORMULAS(INGREDIENTS_ID, FORMULAS_ID) VALUES(5,2);
INSERT INTO INGREDIENTS_FORMULAS(INGREDIENTS_ID, FORMULAS_ID) VALUES(6,1);
INSERT INTO INGREDIENTS_FORMULAS(INGREDIENTS_ID, FORMULAS_ID) VALUES(7,3);
INSERT INTO INGREDIENTS_FORMULAS(INGREDIENTS_ID, FORMULAS_ID) VALUES(8,3);
INSERT INTO INGREDIENTS_FORMULAS(INGREDIENTS_ID, FORMULAS_ID) VALUES(9,3);

INSERT INTO FORMULACATEGORIES(ID,ICON, NAME) VALUES(1, 'meatfood.png', 'Potrawa mięsna');
INSERT INTO FORMULACATEGORIES(ID,ICON, NAME) VALUES(2, 'fastfood.png', 'Fast Food');
INSERT INTO FORMULACATEGORIES(ID,ICON, NAME) VALUES(3, 'meatfood.png', 'Zupy');
INSERT INTO FORMULACATEGORIES(ID,ICON, NAME) VALUES(4, 'meatfood.png', 'Danie regionalne');
INSERT INTO FORMULACATEGORIES(ID,ICON, NAME) VALUES(5, 'fastfood.png', 'Kuchnia włoska');


INSERT INTO FORMULACATEGORIES_FORMULAS(FORMULA_CATEGORIES_ID, FORMULAS_ID) VALUES (1,1);
INSERT INTO FORMULACATEGORIES_FORMULAS(FORMULA_CATEGORIES_ID, FORMULAS_ID) VALUES (1,3);
INSERT INTO FORMULACATEGORIES_FORMULAS(FORMULA_CATEGORIES_ID, FORMULAS_ID) VALUES (2,1);
INSERT INTO FORMULACATEGORIES_FORMULAS(FORMULA_CATEGORIES_ID, FORMULAS_ID) VALUES (3,3);
INSERT INTO FORMULACATEGORIES_FORMULAS(FORMULA_CATEGORIES_ID, FORMULAS_ID) VALUES (4,2);
INSERT INTO FORMULACATEGORIES_FORMULAS(FORMULA_CATEGORIES_ID, FORMULAS_ID) VALUES (4,1);
INSERT INTO FORMULACATEGORIES_FORMULAS(FORMULA_CATEGORIES_ID, FORMULAS_ID) VALUES (5,2);
INSERT INTO FORMULACATEGORIES_FORMULAS(FORMULA_CATEGORIES_ID, FORMULAS_ID) VALUES (5,3);


