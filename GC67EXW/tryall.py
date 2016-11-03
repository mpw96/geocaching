import os
import subprocess
import sys

def find_coordinates():
    for north in range(1000):
        for east in range(1000):
	    with open('gc67exw.txt.asc') as infile, open('cache.txt.asc', 'w') as outfile:
	        for line in infile:
		    line = line.replace('north', '{:03d}'.format(north))
	            line = line.replace('east', '{:03d}'.format(east))
		    outfile.write(line)

	    try:
	        subprocess.check_call(['gpg', '--verify', 'cache.txt.asc'])
	        print 'north: %d' % north
	        print 'east:  %d' % east
	        return 0
	    except subprocess.CalledProcessError:
	        pass

    return 1

if __name__ == '__main__':
    sys.exit(find_coordinates())

