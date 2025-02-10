# 5x5
# 4,0 ... 4,4
# ...
# 0,0 ... 0,4
#
# values 0 ... 9
# 20 21 22 23 24
# ...
#  5  6 ...
#  0  1  2  3  4
#

# 0 blau
# 1 dunkelblau
# 2 hellblau
# 3 lila
# 4 grün
# 5 gelb
# 6 rot
# 7 orange
# 8 weiß


import itertools

class Zelle:
    def __init__(self):
        self.farbe = -1
        self.regel = -1

    def __repr__(self):
        return f'Zelle(farbe: {self.farbe}, regel: {self.regel})'

def make_feld():
    # build basic field
    feld = []
    for row_count in range(0, 5):
        row = []
        for col_count in range(0, 5):
            row.append(Zelle())
        feld.append(row)

    # rule number
    feld[0][0].regel = 2
    feld[0][1].regel = 6
    feld[0][2].regel = 3
    feld[0][3].regel = 2
    feld[0][4].regel = 6

    feld[1][0].regel = 7
    feld[1][1].regel = 1
    feld[1][2].regel = 5
    feld[1][3].regel = 7
    feld[1][4].regel = 6

    feld[2][0].regel = 3
    feld[2][1].regel = 4
    feld[2][2].regel = 3
    feld[2][3].regel = 8
    feld[2][4].regel = 1

    feld[3][0].regel = 1
    feld[3][1].regel = 7
    feld[3][2].regel = 4
    feld[3][3].regel = 4
    feld[3][4].regel = 5

    feld[4][0].regel = 5
    feld[4][1].regel = 2
    feld[4][2].regel = 4
    feld[4][3].regel = 7
    feld[4][4].regel = 2

    return feld

# initially...
# 1 blau
# 2 dunkelblau
# 3 hellblau
# 4 lila
# 5 grün
# 6 gelb
# 7 rot
# 8 orange
# 9 weiß

def assign_colors(color_perm, feld):
    feld[0][2].farbe = color_perm[0]
    feld[3][1].farbe = color_perm[0]
    feld[3][4].farbe = color_perm[0]

    feld[2][1].farbe = color_perm[1]
    feld[2][3].farbe = color_perm[1]
    feld[4][1].farbe = color_perm[1]

    feld[3][0].farbe = color_perm[2]
    feld[4][3].farbe = color_perm[2]

    feld[0][3].farbe = color_perm[3]
    feld[1][4].farbe = color_perm[3]
    feld[2][0].farbe = color_perm[3]

    feld[1][2].farbe = color_perm[4]
    feld[2][4].farbe = color_perm[4]
    feld[4][0].farbe = color_perm[4]

    feld[2][2].farbe = color_perm[5]
    feld[3][3].farbe = color_perm[5]
    feld[4][2].farbe = color_perm[5]

    feld[0][0].farbe = color_perm[6]
    feld[1][1].farbe = color_perm[6]

    feld[0][1].farbe = color_perm[7]
    feld[0][4].farbe = color_perm[7]
    feld[4][4].farbe = color_perm[7]

    feld[1][0].farbe = color_perm[8]
    feld[1][3].farbe = color_perm[8]
    feld[3][2].farbe = color_perm[8]


def check_feld(feld):
    for row_count in range(0, 5):
        for col_count in range(0, 5):
            if feld[row_count][col_count].farbe < 0 or feld[row_count][col_count].regel < 0:
                raise Exception('bad feld')

tries = 0
for color_perm in itertools.permutations([1, 2, 3, 4, 5, 6, 7, 8, 9]):
    tries += 1
    feld = make_feld()
    assign_colors(color_perm, feld)

    check_feld(feld)

    try:
        # check the rules for this feld
        for row_count in range(0, 5):
            row = feld[row_count]
            for col_count in range(0, 5):
                cell = row[col_count]
                if cell.farbe % 2 == 0:
                    # gerade
                    if cell.regel == 1:
                        if cell.farbe <= feld[4][col_count].farbe:
                            raise Exception((cell))
                    if cell.regel == 2:
                        number_of_ones_found = 0
                        # left
                        if col_count > 0 and feld[row_count][col_count-1].farbe == 1:
                            number_of_ones_found += 1
                        # below
                        if row_count > 0 and feld[row_count-1][col_count].farbe == 1:
                            number_of_ones_found += 1
                        # right
                        if col_count < 4 and feld[row_count][col_count+1].farbe == 1:
                            number_of_ones_found += 1
                        # above
                        if row_count < 4 and feld[row_count+1][col_count].farbe == 1:
                            number_of_ones_found += 1
                        if number_of_ones_found < 1:
                            raise Exception(cell)
                    if cell.regel == 3:
                        if cell.farbe >= 5:
                            raise Exception(cell)
                    if cell.regel == 4:
                        if cell.farbe >= feld[row_count][4].farbe:
                            raise Exception(cell)
                    if cell.regel == 5:
                        # left
                        if col_count > 0 and feld[row_count][col_count-1].farbe <= cell.farbe:
                            raise Exception(cell)
                        # below
                        if row_count > 0 and feld[row_count-1][col_count].farbe <= cell.farbe:
                            raise Exception(cell)
                        # right
                        if col_count < 4 and feld[row_count][col_count+1].farbe <= cell.farbe:
                            raise Exception(cell)
                        # above
                        if row_count < 4 and feld[row_count+1][col_count].farbe <= cell.farbe:
                            raise Exception(cell)
                    if cell.regel == 6:
                        if row_count < 4:
                            if cell.farbe % feld[row_count+1][col_count].farbe != 0:
                                raise Exception(cell)
                    if cell.regel == 7:
                        if row_count > 0:
                            if feld[row_count-1][col_count].farbe in [2, 3, 5, 7]:
                                raise Exception(cell)
                    if cell.regel == 8:
                        if col_count > 0 and col_count < 4:
                            if feld[row_count][col_count-1].farbe - feld[row_count][col_count+1].farbe not in [1, -1]:
                                raise Exception(cell)

                else:
                    # ungerade
                    if cell.regel == 1:
                        if cell.farbe >= feld[0][col_count].farbe:
                            raise Exception((cell))
                    if cell.regel == 2:
                        number_of_nines_found = 0
                        # left
                        if col_count > 0 and feld[row_count][col_count-1].farbe == 9:
                            number_of_nines_found += 1
                        # below
                        if row_count > 0 and feld[row_count-1][col_count].farbe == 9:
                            number_of_nines_found += 1
                        # right
                        if col_count < 4 and feld[row_count][col_count+1].farbe == 9:
                            number_of_nines_found += 1
                        # above
                        if row_count < 4 and feld[row_count+1][col_count].farbe == 9:
                            number_of_nines_found += 1
                        if number_of_nines_found < 1:
                            raise Exception(cell)
                    if cell.regel == 3:
                        if cell.farbe < 5:
                            raise Exception(cell)
                    if cell.regel == 4:
                        if cell.farbe <= feld[row_count][0].farbe:
                            raise Exception(cell)
                    if cell.regel == 5:
                        # left
                        if col_count > 0 and feld[row_count][col_count-1].farbe >= cell.farbe:
                            raise Exception(cell)
                        # below
                        if row_count > 0 and feld[row_count-1][col_count].farbe >= cell.farbe:
                            raise Exception(cell)
                        # right
                        if col_count < 4 and feld[row_count][col_count+1].farbe >= cell.farbe:
                            raise Exception(cell)
                        # above
                        if row_count < 4 and feld[row_count+1][col_count].farbe >= cell.farbe:
                            raise Exception(cell)
                    if cell.regel == 6:
                        if row_count < 4:
                            if feld[row_count+1][col_count].farbe % cell.farbe != 0:
                                raise Exception(cell)
                    if cell.regel == 7:
                        if row_count > 0:
                            if feld[row_count-1][col_count].farbe not in [2, 3, 5, 7]:
                                raise Exception(cell)
                    if cell.regel == 8:
                        if row_count > 0 and row_count < 4:
                            if feld[row_count-1][col_count].farbe - feld[row_count+1][col_count].farbe not in [1, -1]:
                                raise Exception(cell)

        print('##############################')
        print(f'blau:       {color_perm[0]}')
        print(f'dunkelblau: {color_perm[1]}')
        print(f'hellblau:   {color_perm[2]}')
        print(f'lila:       {color_perm[3]}')
        print(f'grün:       {color_perm[4]}')
        print(f'gelb:       {color_perm[5]}')
        print(f'rot:        {color_perm[6]}')
        print(f'orange:     {color_perm[7]}')
        print(f'weiß:       {color_perm[8]}')
        #print(color_perm)
    except Exception as e:
        pass


print(f'checked {tries} solutions.')
#N: grünorange hellblaugelb.blaurotdunkelblau
#E: lilaweiß hellblaugelb.rotblaudunkelblau
