#!/bin/bash

rm -Acme-Chef-1.01.tar.gz
rm -rf Acme-Chef-1.01
rm -rf modules

wget http://search.cpan.org/CPAN/authors/id/S/SM/SMUELLER/Acme-Chef-1.01.tar.gz
tar -xvzf Acme-Chef-1.01.tar.gz
mkdir modules

pushd Acme-Chef-1.01
perl Makefile.PL PREFIX=../modules
make
make install
popd

PERL5LIB=./modules/share/perl/5.20.2/ ; export PERL5LIB
perl chef_compile.pl
