def step1():
    """
    HEX -> ASCII
    """
    in_arr = [
        '2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A'.replace(' ', ''),
        '2A 20 59 6F 75 20 61 72 65 20 6F 6E 20 74 68 65 20 72 69 67 68 74 20 77 61 79 21 20 20 20 20 20 20 2A'.replace(' ', ''),
        '2A 20 4E 6F 77 20 64 6F 20 74 68 65 20 66 6F 6C 6C 6F 77 69 6E 67 3A 20 20 20 20 20 20 20 20 20 20 2A'.replace(' ', ''),
        '2A 20 22 6F 6E 65 20 69 73 20 7A 65 72 6F 20 61 6E 64 20 7A 65 72 6F 20 69 73 20 6F 6E 65 22 20 20 2A'.replace(' ', ''),
        '2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A 2A'.replace(' ', ''),
    ]

    out_arr = [
        in_arr[0].decode('hex'),
        in_arr[1].decode('hex'),
        in_arr[2].decode('hex'),
        in_arr[3].decode('hex'),
        in_arr[4].decode('hex'),
    ]

    for i in range (0, 5):
        print out_arr[i]

def step2():
    """
    HEX -> INVERT -> ASCII
    """
    in_arr = [
        'DC DC DC DC DC DC DC DC DC DC DC DC DC DC DC DC DC DC DC DC DC DC DC DC DC DC DC DC DC DC DC DC DC DC'.replace(' ', ''),
        'DC DF B1 9A 87 8B DF 8C 8B 9A 8F C5 DF DF DF DF DF DF C3 C3 DF CC DF DF DF DF DF DF DF DF DF DF DF DC'.replace(' ', ''),
        'DC DF DF 88 97 96 9C 97 DF 92 9A 9E 91 8C DF 9C 86 9C 93 96 9C DF 93 9A 99 8B DF 8C 97 96 99 8B DF DC'.replace(' ', ''),
        'DC DF DF 9A D1 98 D1 DF DF CF CE CF CE CE CF CF CE DF D2 C1 DF CE CE CF CF CE CF CE CF DF DF DF DF DC'.replace(' ', ''),
        'DC DC DC DC DC DC DC DC DC DC DC DC DC DC DC DC DC DC DC DC DC DC DC DC DC DC DC DC DC DC DC DC DC DC'.replace(' ', ''),
    ]

    byte_arr = [
        bytearray.fromhex(in_arr[0]),
        bytearray.fromhex(in_arr[1]),
        bytearray.fromhex(in_arr[2]),
        bytearray.fromhex(in_arr[3]),
        bytearray.fromhex(in_arr[4]),
    ]    


    for line in range (0, 5):
        for i in range (0, len(byte_arr[line])):
            byte_arr[line][i] = 255 - byte_arr[line][i]

    hex_arr = [
        ''.join(format(x, '02x') for x in byte_arr[0]),
        ''.join(format(x, '02x') for x in byte_arr[1]),
        ''.join(format(x, '02x') for x in byte_arr[2]),
        ''.join(format(x, '02x') for x in byte_arr[3]),
        ''.join(format(x, '02x') for x in byte_arr[4]),
    ]

    out_arr = [
        hex_arr[0].decode('hex'),
        hex_arr[1].decode('hex'),
        hex_arr[2].decode('hex'),
        hex_arr[3].decode('hex'),
        hex_arr[4].decode('hex'),
    ]

    for i in range (0, 5):
        print out_arr[i]

def step3():
    """
    HEX -> INVERT -> <<3 -> ASCII
    """
    in_arr = [
        'F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4'.replace(' ', ''),
        'F4 FB D7 32 73 FB 32 12 11 B8 FB FB FB FB FB FB FB FB FB FB FB FB FB FB FB FB FB FB FB FB FB FB FB F4'.replace(' ', ''),
        'F4 FB FB FB FB F4 16 B5 FB 11 D2 71 F2 FB D9 79 D9 FB FA 73 53 93 D2 52 D3 72 DA FB FB FB FB FB FB F4'.replace(' ', ''),
        'F4 FB 75 F2 53 FB 91 12 72 51 71 D2 12 32 FB D2 91 FB 32 53 D3 B1 DB FB FB FB FB FB FB FB FB FB FB F4'.replace(' ', ''),
        'F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4 F4'.replace(' ', ''),
    ]

    byte_arr = []
    for line in range (0, len(in_arr)):
        byte_arr.append(bytearray.fromhex(in_arr[line]))

    for line in range (0, len(in_arr)):
        for i in range (0, len(byte_arr[line])):
            byte_arr[line][i] = 255 - byte_arr[line][i]
        for i in range (0, len(byte_arr[line])):
            for rot in range (0, 3):
                if byte_arr[line][i] > 127:
                    overflow = 1
                else:
                    overflow = 0
                b = 0xff & byte_arr[line][i]
                bs = (2 * b) % 256
                
                byte_arr[line][i] = bs + overflow
 
    hex_arr = []
    for line in range (0, len(byte_arr)):
        hex_arr.append(''.join(format(x, '02x') for x in byte_arr[line]))


    out_arr = []
    for line in range (0, len(hex_arr)):
        out_arr.append(hex_arr[line].decode('hex'))

    for i in range (0, len(out_arr)):
        print out_arr[i]

def step4():
    in_arr = [
        '2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B'.replace(' ', ''),
        '2B 4A 26 A3 83 A2 00 62 C0 E0 C3 62 C0 63 A3 83 20 6A 4A 4A 4A 09 EB 6B 4A 4A 4A 4A 4A 4A 4A 4A 4A 2B'.replace(' ', ''),
        '2B 4A C4 43 E2 20 E2 4A 62 00 E2 4A C0 43 E2 4A 82 63 83 62 C3 4A 22 A3 A3 00 C2 20 09 4A 4A 4A 4A 2B'.replace(' ', ''),
        '2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B'.replace(' ', ''),
        '2B 4A 87 A3 00 C0 43 4A 82 63 80 E2 4A 28 4A C2 E2 A2 00 E2 E2 20 4A 4A 4A 4A 4A 4A 4A 4A 4A 4A 4A 2B'.replace(' ', ''),
        '2B 4A 28 4A C0 A0 A3 4A 40 A3 63 83 C0 4A 69 4A 82 63 80 E2 4A E8 4A E3 63 83 E0 C0 E2 20 4A 4A 4A 2B'.replace(' ', ''),
        '2B 4A E6 62 20 C0 4A 68 4A 01 E2 00 A3 4A C2 E2 A2 00 E2 E2 20 4A 4A 4A 4A 4A 4A 4A 4A 4A 4A 4A 4A 2B'.replace(' ', ''),
        '2B 4A 82 A3 E0 00 4A 40 A3 63 83 C0 4A A3 83 E2 4A 08 4A C0 43 00 E2 E2 4A E3 63 83 E0 C0 E2 20 4A 2B'.replace(' ', ''),
        '2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B'.replace(' ', ''),
        '2B 4A 04 E2 82 E2 00 4A C0 A3 4A C0 43 E2 4A 22 62 22 43 E2 4A C2 E2 20 22 00 63 40 C0 63 A3 83 4A 2B'.replace(' ', ''),
        '2B 4A A3 83 4A 43 A3 A0 4A C0 A3 4A E0 20 E2 4A C0 43 E2 4A 22 A3 A3 00 C2 63 83 62 C0 E2 20 8B 4A 2B'.replace(' ', ''),
        '2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B 2B'.replace(' ', ''),
    ]

    byte_arr = []
    for line in range (0, len(in_arr)):
        byte_arr.append(bytearray.fromhex(in_arr[line]))

    for line in range (0, len(in_arr)):
        # invert
        for i in range (0, len(byte_arr[line])):
            byte_arr[line][i] = 255 - byte_arr[line][i]
        # <<3
        for i in range (0, len(byte_arr[line])):
            for rot in range (0, 3):
                if byte_arr[line][i] > 127:
                    overflow = 1
                else:
                    overflow = 0
                b = 0xff & byte_arr[line][i]
                bs = (2 * b) % 256
                
                byte_arr[line][i] = bs + overflow
        # xor 141
        for i in range (0, len(byte_arr[line])):
            byte_arr[line][i] = (0xff & byte_arr[line][i]) ^ 141

    hex_arr = []
    for line in range (0, len(byte_arr)):
        hex_arr.append(''.join(format(x, '02x') for x in byte_arr[line]))


    out_arr = []
    for line in range (0, len(hex_arr)):
        out_arr.append(hex_arr[line].decode('hex'))

    for i in range (0, len(out_arr)):
        print out_arr[i]


step1()
step2()
step3()
step4()

