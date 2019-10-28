use strict;
use warnings;

use Acme::Chef;


my $chef_source = "
Zesty caching stew with gummy bears.

The only thing better than a stew is a super-easy stew topped with gummy bears - try this one and let me know what you think. On October 27th 2019 I had to refine the recipe with Haxe. If you have cooked this before, please cook it again. It's improved a lot.

Ingredients.
7 gummy bears
2 kg beef stew meat
150 g all-purpose flour
1 level teaspoon salt
1 heaped teaspoon ground black pepper
3 g garlic
5 bay leaves
33 potatoes
4 carrots


Cooking time: 12 hours.

Pre-heat oven to 180 degrees Celsius.

Method.
Put beef stew meat into mixing bowl. Combine potatoes into mixing bowl. Hash the bay leaves. Remove garlic from mixing bowl. Mix the mixing bowl well. Chop the bay leaves until hashed. Put all-purpose flour into mixing bowl. Remove ground black pepper. Add gummy bears. Remove ground black pepper. Add gummy bears. Divide garlic into mixing bowl. Put potatoes into mixing bowl. Combine beef stew meat into mixing bowl. Grind the garlic. Remove carrots from mixing bowl. Work the garlic until grinded. Add salt. Put salt into mixing bowl. Combine potatoes into mixing bowl. Fold ground black pepper into mixing bowl. Add bay leaves. Put ground black pepper into mixing bowl. Add gummy bears. Add beef stew meat. Add carrots. Put garlic into mixing bowl. Add carrots. Remove salt. Fold garlic into mixing bowl. Put garlic into mixing bowl. Add carrots. Remove salt. Fold carrots into mixing bowl. Put beef stew meat into mixing bowl. Slice the carrots. Combine beef stew meat into mixing bowl. Handle the carrots until sliced. Add potatoes. Remove beef stew meat. Divide garlic into mixing bowl. Put gummy bears into mixing bowl. Remove salt. Fold carrots into mixing bowl. Put bay leaves into mixing bowl. Add garlic. Add beef stew meat. Fold bay leaves into mixing bowl. Put carrots into mixing bowl. Remove salt. Fold bay leaves into mixing bowl. Put carrots into mixing bowl. Add garlic. Add salt. Combine bay leaves. Put potatoes into mixing bowl. Remove salt. Put bay leaves into mixing bowl. Combine beef stew meat. Fold bay leaves into mixing bowl. Put potatoes into mixing bowl. Add potatoes. Remove bay leaves. Remove carrots. Put all-purpose flour into mixing bowl. Divide garlic into mixing bowl. Add carrots. Remove garlic. Put carrots into mixing bowl. Add carrots. Remove beef stew meat. Fold ground black pepper into mixing bowl. Put gummy bears into mixing bowl. Mill the ground black pepper. Add gummy bears into mixing bowl. Mill the ground black pepper until milled. Add salt. Serve with Chocolate Cake. Liquify contents of the mixing bowl. Pour contents of the mixing bowl into the baking dish. Clean mixing bowl. Serve with Haxe. Liquify contents of the mixing bowl. Pour contents of the mixing bowl into the baking dish.

Serves 1.

Chocolate Cake.

Ingredients.
60 eggs
1 teaspoon sugar
5 g yeast
10 ml water
100 g all-purpose flour
876 ml cream

Method.
Clean mixing bowl. Put water into mixing bowl. Combine yeast into mixing bowl. Add yeast. Add sugar. Add sugar. Fold cream into mixing bowl. Put cream into mixing bowl. Put cream into mixing bowl. Put cream into mixing bowl. Remove yeast. Add sugar. Add sugar. Put eggs into mixing bowl. Remove water. Remove yeast. Add sugar.
Put yeast into mixing bowl. Add water. Fold cream into mixing bowl. Put eggs into mixing bowl. Caramelise the cream. Remove sugar from mixing bowl. Stir the cream until caramelised. Add water. Fold water into mixing bowl. Fold cream into mixing bowl. Put cream into mixing bowl. Put water into mixing bowl. Put cream into mixing bowl. Add yeast. Remove sugar. Remove sugar. Put sugar into mixing bowl. Fold cream into mixing bowl. Put eggs into mixing bowl. Add yeast. Remove sugar. Put sugar into mixing bowl. Add sugar. Fold cream into mixing bowl. Divide cream into mixing bowl. Put water into mixing bowl. Remove yeast. Add sugar. Fold water into mixing bowl. Put water into mixing bowl. Put water into mixing bowl. Remove cream. Put water into mixing bowl. Remove sugar. Remove cream. Put yeast into mixing bowl. Add yeast. Remove sugar. Fold yeast into mixing bowl. Put eggs into mixing bowl. Sift the yeast. Add sugar. Filter the yeast until sifted. Stir yeast into mixing bowl.

Haxe.

Ingredients.
5 schweine
2 heaped tablespoons pfeffer
10 g petersilie
7 kg sauerkraut
109 ml wasser
1 einhornhaar

Method.
Clean mixing bowl. Put sauerkraut into mixing bowl. Remove einhornhaar. Combine schweine into mixing bowl. Add pfeffer. Put wasser into mixing bowl. Remove sauerkraut. Add einhornhaar. Put wasser into mixing bowl. Remove einhornhaar. Divide pfeffer into mixing bowl. Put schweine into mixing bowl. Combine petersilie into mixing bowl. Add sauerkraut. Put sauerkraut into mixing bowl. Combine sauerkraut into mixing bowl. Add einhornhaar. Put wasser into mixing bowl. Put sauerkraut into mixing bowl. Combine sauerkraut into mixing bowl. Put schweine into mixing bowl. Combine petersilie into mixing bowl.
";

my $compiled = Acme::Chef->compile($chef_source);  

my $chef_bin = $compiled->dump('autorun');
my $output_of_chef_program = eval $chef_bin;

print "$output_of_chef_program\n";
